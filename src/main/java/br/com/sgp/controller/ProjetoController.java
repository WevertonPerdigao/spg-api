package br.com.sgp.controller;

import br.com.sgp.model.Projeto;
import br.com.sgp.model.SituacaoProjeto;
import br.com.sgp.model.TipoProjeto;
import br.com.sgp.service.ProjetoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("projetos")
public class ProjetoController {

    @Autowired
    ProjetoService projetoService;

    @GetMapping
    public ResponseEntity<?> listAllProjetos() {

        try {
            List<Projeto> listProjeto = projetoService.getTodosProjetos();
            return ResponseEntity.ok().body(listProjeto);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e);
        }
    }

    @GetMapping("/funcionario/{id}")
    public ResponseEntity<?> findByfuncId(@PathVariable("id") Integer id) {

        try {
            List<Projeto> listProjeto = projetoService.listByFuncionarioId(id);
            return new ResponseEntity(listProjeto,HttpStatus.OK);
        } catch (Exception e) {

        	return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);//400
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

    @PostMapping(value = "/salvar" , consumes= {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_JSON_UTF8_VALUE},produces= {MediaType.APPLICATION_JSON_UTF8_VALUE})
	public ResponseEntity<?> salvar(@RequestBody Projeto entity) {    	    	
    	
    	try {
			return new ResponseEntity<Projeto>(projetoService.salvar(entity),HttpStatus.OK); 
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);//400
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
	public ResponseEntity<?> findBy(@RequestParam(required= false)  String likenome,@RequestParam(required= false) 
	String empresaid,@RequestParam(required= false)  String situacaoid, @RequestParam(required= false)   String tipoid, @RequestParam(required= false,defaultValue="false")  boolean datainicial,@RequestParam(required= false,defaultValue="false")   boolean datafinal,@RequestParam(required= false,defaultValue="false") boolean crescente) {
		return new ResponseEntity(projetoService.finBy(likenome,empresaid,situacaoid,tipoid,datainicial,datafinal,crescente),HttpStatus.OK);
	}



}
