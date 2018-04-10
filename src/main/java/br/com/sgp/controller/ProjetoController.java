package br.com.sgp.controller;

import br.com.sgp.model.Arquivo;
import br.com.sgp.model.Atividade;
import br.com.sgp.model.Funcionario;
import br.com.sgp.model.Projeto;
import br.com.sgp.model.SituacaoProjeto;
import br.com.sgp.model.TipoProjeto;
import br.com.sgp.service.ProjetoService;
import br.com.sgp.util.Constants;
import io.swagger.models.Response;

import org.hibernate.hql.internal.ast.tree.DisplayableNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;



import java.io.IOException;

import java.util.List;


import javax.websocket.server.PathParam;

@RestController
@RequestMapping("projetos")
public class ProjetoController {

	
	@Autowired
	ProjetoService projetoService;

	@GetMapping
	public ResponseEntity<?> listAllProjetos() {

		try {			
			return ResponseEntity.ok().body(projetoService.getTodos());
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e);
		}
	}

	@GetMapping("/funcionario/{id}")
	public ResponseEntity<?> findByfuncId(@PathVariable("id") Integer id) {

		try {
			List<Projeto> listProjeto = projetoService.listByFuncionarioId(id);
			return new ResponseEntity(listProjeto, HttpStatus.OK);
		} catch (Exception e) {

			return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);// 400
		}
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> findById(@PathVariable("id") Integer id) {

		try {
			Projeto projeto = projetoService.findByProjId(id);

			return ResponseEntity.ok().body(projeto);
		} catch (Exception e) {

			return ResponseEntity.badRequest().body(e);
		}
	}

	@PostMapping(value = "/salvar", consumes = { 
			MediaType.APPLICATION_JSON_UTF8_VALUE }, produces = { MediaType.APPLICATION_JSON_UTF8_VALUE })
	public ResponseEntity<?> salvar(@RequestBody Projeto entity) {

		try {
			return new ResponseEntity<Projeto>(projetoService.salvar(entity), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);// 400
		}

	}

	@GetMapping(value = "tipos")
	public @ResponseBody List<TipoProjeto> getTipos() {
		return projetoService.getTodosTipos();
	}

	@GetMapping(value = "situacao")
	public @ResponseBody List<SituacaoProjeto> getSituacao() {
		return projetoService.getAllSituacao();
	}

	@GetMapping(value = "findby")
	public ResponseEntity<?> findBy(@RequestParam(required = false) String likenome,
			@RequestParam(required = false) String empresaid, @RequestParam(required = false) String situacaoid,
			@RequestParam(required = false) String tipoid,
			@RequestParam(required = false, defaultValue = "false") boolean datainicial,
			@RequestParam(required = false, defaultValue = "false") boolean datafinal,
			@RequestParam(required = false, defaultValue = "false") boolean crescente) {
		return new ResponseEntity(
				projetoService.finBy(likenome, empresaid, situacaoid, tipoid, datainicial, datafinal, crescente),
				HttpStatus.OK);
	}

	
	@PostMapping(value ="uploadtermo",consumes = {MediaType.MULTIPART_FORM_DATA_VALUE}) // //new annotation since 4.3
	public ResponseEntity<?> uploudTermo(@RequestHeader String termoid,@RequestParam("file") MultipartFile file) {

		if (file.isEmpty()) {
			return new ResponseEntity(HttpStatus.GONE);// 410
		}

		try {

			
			return new ResponseEntity(projetoService.salvarTermoArquivo(termoid,file), HttpStatus.OK);

		} catch (IOException e) {
			e.printStackTrace();
			return new ResponseEntity("Não foi possivel carregar arquivo\n\r" + e.getMessage(), HttpStatus.BAD_REQUEST);
		}

	}
	
	@PostMapping(value = "addmembro/{id}")
	public ResponseEntity<?> addMembros(@PathVariable("id") Integer id, @RequestBody List<Funcionario> list) {

		try {
			return new ResponseEntity(projetoService.addMembros(id,list),HttpStatus.OK);	
		} catch (Exception e) {
			return new ResponseEntity(e,HttpStatus.BAD_REQUEST);	
		}		
		
	}

	
	@GetMapping(value = "getmembros/{id}")
	public @ResponseBody List<Funcionario> getMembros(@PathVariable String id) {
		
		return projetoService.getAllMembros(id);
	}
	
	@GetMapping(value = "atividades/{id}")
	public ResponseEntity<?> getMethodName(@PathVariable("id") Integer id) {
		
		try {
			return new ResponseEntity(projetoService.getTodasAtividades(id),HttpStatus.OK);
		} catch (Exception e) {
		
			return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
		}
	}
	
	@PostMapping(value = "addatividade/{id}")
	public ResponseEntity<?> addAtividade(@PathParam("id") Integer id, @RequestBody Atividade entity) {
		
		try {
			projetoService.addAtividade(id,entity);
			return new ResponseEntity<>(entity,HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity("Problema ao salvar",HttpStatus.BAD_REQUEST);
		}
		
	}


//	@GetMapping(value = "dispendios")
//	public @ResponseBody List getMethodName(@RequestParam String param) {
//		return new SomeData();
//	}

	
	
}
