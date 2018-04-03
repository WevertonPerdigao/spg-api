package br.com.sgp.service;


import br.com.sgp.model.Projeto;
import br.com.sgp.repository.ProjetoRepository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Service
public class ProjetoService {

	@Autowired
	ProjetoRepository projetoRepository;

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

}
