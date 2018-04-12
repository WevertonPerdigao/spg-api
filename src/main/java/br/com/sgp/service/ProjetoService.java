package br.com.sgp.service;

import br.com.sgp.model.Arquivo;
import br.com.sgp.model.Atividade;
import br.com.sgp.model.Dispendio;
import br.com.sgp.model.DispendioAnexo;
import br.com.sgp.model.Funcionario;
import br.com.sgp.model.Projeto;
import br.com.sgp.model.SituacaoProjeto;
import br.com.sgp.model.TermoAditivo;
import br.com.sgp.model.TipoDispendio;
import br.com.sgp.model.TipoProjeto;
import br.com.sgp.repository.ArquivoRepository;
import br.com.sgp.repository.AtividadeRepository;
import br.com.sgp.repository.DispendioAnexoRepository;
import br.com.sgp.repository.DispendioRepository;
import br.com.sgp.repository.ProjetoRepository;
import br.com.sgp.repository.SituacaoProjetoRepository;
import br.com.sgp.repository.TipoDispendioRepository;
import br.com.sgp.repository.TipoProjetoRepository;
import br.com.sgp.util.Constants;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.MultiValueMap;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonBackReference;

//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.fileUpload;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
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

@Service
public class ProjetoService {

	@Autowired
	ProjetoRepository projetoRepository;

	@Autowired
	TipoProjetoRepository tipoProjetoRepository;

	@Autowired
	SituacaoProjetoRepository situacaoRepository;

	@Autowired
	ArquivoRepository arquivoRepository;

	@Autowired
	AtividadeRepository atividadeRepository;

	@Autowired
	TipoDispendioRepository tipoDispendioRepository;

	@Autowired
	DispendioRepository dispendioRepository;

	@Autowired
	DispendioAnexoRepository dispendioAnexoRepository;
	
	@PersistenceContext
	private EntityManager em;

	public Projeto findByProjId(Integer projId) {

		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<Projeto> query = builder.createQuery(Projeto.class);
		Root<Projeto> root = query.from(Projeto.class);
		root.fetch("atividades", JoinType.LEFT);

		query.distinct(true).select(root).where(builder.equal(root.get("projId"), projId));
		TypedQuery<Projeto> typed = em.createQuery(query);

		Projeto proj = typed.getSingleResult();
		proj.setCusto(getCusto(proj));
		return proj;
	}

	public synchronized List<Projeto> listByFuncionarioId(Integer funcId) {

		List<Projeto> list = projetoRepository.listByFuncionarioId(funcId);

		for (Projeto projeto : list) {
			projeto.setCusto(getCusto(projeto));
		}

		return list;
	}

	public List<Projeto> getTodos() {
		List<Projeto> list = projetoRepository.getTodos();

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

	public List<TipoProjeto> getTodosTipos() {
		return tipoProjetoRepository.findAll();
	}

	public List<SituacaoProjeto> getAllSituacao() {
		return situacaoRepository.findAll();
	}

	public List<Projeto> finBy(String likenome, String empresaid, String situacaoid, String tipoid, boolean datainicial,
			boolean datafinal, boolean crescente) {

		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<Projeto> query = builder.createQuery(Projeto.class);
		Root<Projeto> root = query.from(Projeto.class);
		root.fetch("projEmprId", JoinType.LEFT);
		root.fetch("projFuncId", JoinType.LEFT);
		root.fetch("projSiprId");
		Fetch<Projeto, TipoProjeto> fetchTipo = root.fetch("projTipos", JoinType.LEFT);
		root.fetch("projTeadId", JoinType.LEFT);

		Set<Predicate> predicates = new HashSet<>();

		query.select(root);
		query.distinct(true);

		if (likenome != null) {
			predicates.add(builder.equal(root.get("projNome"), likenome));
		}

		if (empresaid != null) {
			predicates.add(builder.equal(root.get("projEmprId").get("emprId"), empresaid));
		}
		if (situacaoid != null) {
			predicates.add(builder.equal(root.get("projSiprId").get("siprId"), situacaoid));
		}

		if (tipoid != null) {

			predicates.add(builder.equal(root.join("projTipos").get("tiprId"), tipoid));
		}

		List<Order> ordem = new ArrayList<>();
		if (datainicial) {
			Path<Object> orderInicial = root.get("projDataInicial");
			ordem.add(crescente ? builder.asc(orderInicial) : builder.desc(orderInicial));
		}

		if (datafinal) {
			Path<Object> orderfinal = root.get("projDataFinal");
			ordem.add(crescente ? builder.asc(orderfinal) : builder.desc(orderfinal));
		}
		query.orderBy(ordem);

		Predicate[] express = predicates.toArray(new Predicate[predicates.size()]);
		query.where(express);
		TypedQuery<Projeto> typed = em.createQuery(query);

		return typed.getResultList();
	}

	/*
	 * Salva a entidade do arquivo no banco, atualiza o termo, se o termo ja tem um
	 * arquivo, o arquivo antigo sera apagado do banco e do diretório fisico
	 * 
	 */
	@Transactional
	public TermoAditivo salvarTermoArquivo(String termoid, MultipartFile file) throws IOException {

		Arquivo v = getArquivo(Constants.getFolderAnexoTermo(), file);


		arquivoRepository.save(v);
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<TermoAditivo> query = builder.createQuery(TermoAditivo.class);
		Root<TermoAditivo> root = query.from(TermoAditivo.class);
		query.select(root).distinct(true);
		query.where(builder.equal(root.get("teadId"), termoid));
		TypedQuery<TermoAditivo> typed = em.createQuery(query);
		TermoAditivo entity = typed.getSingleResult();
		if (entity.getArquivo() != null) {
			deleteArquivo(entity.getArquivo());
			arquivoRepository.delete(entity.getArquivo());
		}

		entity.setArquivo(v);// verificar se salva no banco

		return entity;
	}

	private boolean deleteArquivo(Arquivo arquivo) {
		java.nio.file.Path path = Paths.get(Constants.UPLOADED_FOLDER + arquivo.getPath());

		return path.toFile().delete();
	}

	@Transactional
	public Projeto addMembros(Integer id, List<Funcionario> list) {
		Optional<Projeto> seeker = projetoRepository.findById(id);
		Projeto projeto = seeker.get();

		projeto.addMembro(list);

		projetoRepository.save(projeto);

		return projeto;
	}

	public List<Funcionario> getAllMembros(String id) {

		CriteriaBuilder builder = em.getCriteriaBuilder();

		CriteriaQuery<Projeto> query = builder.createQuery(Projeto.class);

		Root<Projeto> root = query.from(Projeto.class);

		root.fetch("equipe", JoinType.LEFT);

		query.select(root);

		query.where(builder.equal(root.get("projId"), id));

		TypedQuery<Projeto> typedquery = em.createQuery(query);

		return typedquery.getSingleResult().getEquipe();
	}

	public List<Atividade> getTodasAtividades(Integer id) throws Exception {

		Projeto p = projetoRepository.getOne(id);
		List<Atividade> list = p.getAtividades();
		if (p == null || list == null) {
			throw new NullPointerException("Nenhum projeto ou atividade encontrada");
		}

		return list;
	}

	public void addAtividade(Atividade entity) {

		atividadeRepository.save(entity);
	}

	public List<TipoDispendio> getAllTipoDispendio() {
		return tipoDispendioRepository.findAll();
	}

	public List<Map<String, ?>> getAllTipoDispendioResumo(Integer projetoId) {

		List<Map<String, ?>> list = new ArrayList<>();

		Projeto p = projetoRepository.getOne(projetoId);

		List<TipoDispendio> tipos = p.tiposDispendios();

		for (TipoDispendio tipoDispendio : tipos) {

			Map<String, Object> map = new HashMap<>();
			float sum = 0;

			for (Dispendio d : p.getDispendios()) {
				if (d.getTipo().getTidiId().equals(tipoDispendio.getTidiId())) {
					sum += d.getValor().floatValue();
				}
			}

			map.put("tidiId", tipoDispendio.getTidiId());
			map.put("tidiNome", tipoDispendio.getTidiNome());
			map.put("total", "" + sum);
			list.add(map);

		}

		return list;
	}

	public List<Dispendio> getDispencios(Integer projetctId, Integer tipo) {

		CriteriaBuilder builder = em.getCriteriaBuilder();

		CriteriaQuery<Dispendio> query = builder.createQuery(Dispendio.class);

		Root<Dispendio> root = query.from(Dispendio.class);
		query.select(root);

		query.distinct(true).where(builder.equal(root.get("prdi_proj_id").get("projId"), projetctId),
				builder.equal(root.get("tipo").get("tidiId"), tipo));

		TypedQuery<Dispendio> typed = em.createQuery(query);

		return typed.getResultList();
	}

	public Set<Dispendio> getDispencios(Integer projetctId) {

		Projeto p = projetoRepository.getOne(projetctId);

		return p.getDispendios();
	}

	public void addDispendio(Dispendio entity) {
		dispendioRepository.save(entity);
	}

	@Transactional
	public void addAnexoDispendio(Integer id, MultipartFile file) {
		try {
			Arquivo arquivo = getArquivo(Constants.getFolderAnexoDispendio(), file);
			DispendioAnexo anexo = dispendioRepository.getAnexo(id);			
			anexo.setAnexo(arquivo);
//			dispendioRepository.save(anexo)			
			
		} catch (IOException e) {		
			e.printStackTrace();
		}
	}

	public Arquivo getArquivo(String caminho, MultipartFile file) throws IOException {
		Arquivo v = new Arquivo(file);
		// Get the file and save it somewhere
		byte[] bytes = file.getBytes();
		java.nio.file.Path path = Paths.get(caminho + v.getPath());

		File fileSystem = path.toFile();
		if (!fileSystem.getParentFile().exists()) {
			fileSystem.getParentFile().mkdir();
		}

		if (fileSystem.createNewFile()) {
			Files.write(path, bytes);
			return v;
		} else
			return null;

	}

	public void addDispendioAnexo(DispendioAnexo entity) {
		dispendioAnexoRepository.save(entity);
	}
}
