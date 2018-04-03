package br.com.sgp.controller;


import br.com.sgp.model.Funcionario;
import br.com.sgp.model.Login;
import br.com.sgp.service.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {

    @Autowired
    FuncionarioService funcionarioService;

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping(path = "/login",
            consumes = {MediaType.APPLICATION_JSON_UTF8_VALUE},
            produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public ResponseEntity<?> login(@RequestBody Login login) {


        Funcionario funcionario = funcionarioService.findByMatriculaAndSenha(login.getEmail(), login.getSenha());
        if (funcionario != null) {
            return new ResponseEntity<Funcionario>(funcionario, HttpStatus.OK);
        } else {
            return new ResponseEntity("Erro em algo", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
