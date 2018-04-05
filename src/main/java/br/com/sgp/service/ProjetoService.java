package br.com.sgp.service;

import br.com.sgp.model.Arquivo;
import br.com.sgp.model.Projeto;
import br.com.sgp.model.SituacaoProjeto;
import br.com.sgp.model.TermoAditivo;
import br.com.sgp.model.TipoProjeto;
import br.com.sgp.repository.ProjetoRepository;
import br.com.sgp.repository.SituacaoProjetoRepository;
import br.com.sgp.repository.TipoProjetoRepository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.MultiValueMap;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Fetch;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Order;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.Subquery;

@Service
public class ProjetoService {

	@Autowired
	ProjetoRepository projetoRepository;
	
	@Autowired TipoProjetoRepository tipoProjetoRepository;
	
	@Autowired SituacaoProjetoRepository situacaoRepository;

	@PersistenceContext
	private EntityManager em;

	public Projeto findByProjId(Integer projId) {
		return projetoRepository.getOne(projId);
	}

	public synchronized List<Projeto> listByFuncionarioId(Integer funcId) {

		List<Projeto> list = projetoRepository.listByFuncionarioId(funcId);

		for (Projeto projeto : list) {
			projeto.setCusto(getCusto(projeto));
		}

		return list;
	}

	/**
	 * Metodo para pegar o custo do projeto
	 */

	private synchronized BigDecimal getCusto(Projeto projeto) {

		Query query = this.em.createNativeQuery("EXEC sp_ProjetoCusto_Selecionar 	@proj_id = :proj_id")
				.setParameter("proj_id", projeto.getProjId());

		List<Object[]> result = query.getResultList();

		for (Object[] objects : result) {
			return new BigDecimal(objects[3].toString());
		}

		return null;
	}

	public List<Projeto> listAll() {
		return projetoRepository.findAll();
	}

	public Projeto salvar(Projeto entity) {
		return projetoRepository.save(entity);
	}

	public List<Projeto> getTodosProjetos() {

		return projetoRepository.getTodosProjetos();
	}


	public List<TipoProjeto> getTodosTipos(){
		return tipoProjetoRepository.findAll();
	}

	
	public List<SituacaoProjeto> getAllSituacao(){
		return situacaoRepository.findAll();
	}

	public List<Projeto> finBy(String likenome, String empresaid, String situacaoid, String tipoid, 
			boolean datainicial,
			boolean datafinal, 
			boolean crescente) {
		
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<Projeto> query = builder.createQuery(Projeto.class);
		Root<Projeto> root = query.from(Projeto.class);
		root.fetch("projEmprId",JoinType.LEFT);
		root.fetch("projFuncId",JoinType.LEFT);
		root.fetch("projSiprId");
		Fetch<Projeto, TipoProjeto> fetchTipo = root.fetch("projTipos",JoinType.LEFT);
		root.fetch("projTeadId",JoinType.LEFT);
		
		Set<Predicate> predicates= new HashSet<>();
		
		query.select(root);
		query.distinct(true);
		
		if (likenome!=null) {
			predicates.add(builder.equal(root.get("projNome"), likenome));
		}
	
		if (empresaid!=null) {
			predicates.add(builder.equal(root.get("projEmprId").get("emprId"), empresaid));
		}
		if (situacaoid!=null) {				
			predicates.add(builder.equal(root.get("projSiprId").get("siprId"), situacaoid));
		}
		
		if (tipoid!=null) {
			
			predicates.add(builder.equal(root.join("projTipos").get("tiprId"), tipoid));
		}
		
		List<Order> ordem = new ArrayList<>();
		if (datainicial) {
			Path<Object> orderInicial = root.get("projDataInicial");
			ordem.add(crescente?builder.asc(orderInicial):builder.desc(orderInicial));
		}
		
		if (datafinal) {
			Path<Object> orderfinal = root.get("projDataFinal");
			ordem.add(crescente?builder.asc(orderfinal):builder.desc(orderfinal));
		}
		query.orderBy(ordem);
		
		Predicate[] express = predicates.toArray(new Predicate[predicates.size()]);
		query.where(express);
		TypedQuery<Projeto> typed = em.createQuery(query);
		
		return typed.getResultList();
	}

	@Transactional
	public TermoAditivo salvarTermoArquivo(String termoid, Arquivo v) {
		
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<TermoAditivo> query = builder.createQuery(TermoAditivo.class);
		Root<TermoAditivo> root = query.from(TermoAditivo.class);
		query.select(root).distinct(true);
		query.where(builder.equal(root.get("teadId"), termoid));
		TypedQuery<TermoAditivo> typed = em.createQuery(query);
		
		TermoAditivo entity = typed.getSingleResult();
		entity.setArquivo(v);//verificar se salva no banco
		
		
		return entity;
	}
}
