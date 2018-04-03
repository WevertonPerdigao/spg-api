package br.com.sgp.controller;

import br.com.sgp.model.Projeto;
import br.com.sgp.service.ProjetoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/projetos")
public class ProjetoController {

    @Autowired
    ProjetoService projetoService;

    @GetMapping
    public ResponseEntity<?> listAllProjetos() {

        try {
            List<Projeto> listProjeto = projetoService.listAll();
            return ResponseEntity.ok().body(listProjeto);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e);
        }
    }

    @GetMapping("/funcionario/{id}")
    public ResponseEntity<?> findByfuncId(@PathVariable("id") Integer id) {

        try {
            List<Projeto> listProjeto = projetoService.listByFuncionarioId(id);

            return ResponseEntity.ok().body(listProjeto);
        } catch (Exception e) {

            return ResponseEntity.badRequest().body(e);
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

}
