package br.com.sgp.controller;

import br.com.sgp.model.Cargo;
import br.com.sgp.model.Funcao;
import br.com.sgp.model.Funcionario;
import br.com.sgp.model.Login;
import br.com.sgp.model.Perfil;
import br.com.sgp.model.Provisao;
import br.com.sgp.model.Setor;
import br.com.sgp.model.StatusFuncionario;
import br.com.sgp.model.Unidade;
import br.com.sgp.security.PasswordEncoder;
import br.com.sgp.service.FuncionarioService;
import br.com.sgp.util.Constants;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {

	@Autowired
	FuncionarioService funcionarioService;

	@Autowired
	PasswordEncoder encoder;

	@PostMapping(path = "/login", consumes = { MediaType.APPLICATION_JSON_UTF8_VALUE }, produces = {
			MediaType.APPLICATION_JSON_UTF8_VALUE })
	public ResponseEntity<?> login(@RequestBody Login login) {

		Funcionario funcionario = funcionarioService.findByMatriculaAndSenha(login.getEmail(), login.getSenha());
		if (funcionario != null) {

			if (encoder.matches(login.getSenha(), funcionario.getFuncSenha())) {
				return new ResponseEntity<Funcionario>(funcionario, HttpStatus.OK); // retorno 200
			} else
				return new ResponseEntity("Senha incorreta", HttpStatus.FORBIDDEN); // retorn 403
		} else {
			return new ResponseEntity("Usuário não encontrado", HttpStatus.NOT_ACCEPTABLE);// retorno 406
		}
	}

	@GetMapping(value = "docrypt")
	public ResponseEntity<?> doCrypt(@RequestParam String pass) {

		if (pass != null) {
			return new ResponseEntity(encoder.encode(pass), HttpStatus.OK);
		}
		return new ResponseEntity(HttpStatus.BAD_REQUEST);

	}

	@GetMapping
	public ResponseEntity<?> listAllFuncionarios(@RequestParam(required = false) String nome,
			@RequestParam(required = false) String email) {
		try {
			List<Funcionario> listFuncionario = funcionarioService.listAll(nome,email);
			return ResponseEntity.ok().body(listFuncionario);
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e);
		}
	}

	@PostMapping(value = "salvar")
	public ResponseEntity<?> salvarFuncionario(@RequestBody Funcionario entity) {
		try {
			funcionarioService.salvar(entity);
			if (entity.getFuncSenha() == null) {
				return new ResponseEntity("Não pode salvar senha em branco", HttpStatus.BAD_REQUEST);
			}
			return new ResponseEntity<Funcionario>(entity, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity("Erro ao salvar", HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping(value = "setor")
	public @ResponseBody List<Setor> getAllSetors() {
		return funcionarioService.getAllSetor();
	}

	@GetMapping(value = "perfil")
	public @ResponseBody List<Perfil> getAllPerfil(@RequestParam(required = false) String text) {
		return funcionarioService.getAllPerfil(text);
	}

	/**
	 * Metodo para listar todos perfis do funcionario
	 * 
	 * @param id
	 *            do funcionario
	 * @return Lista de perfil do funcionario
	 */
	@GetMapping(value = "perfil/{id}")
	public @ResponseBody Perfil getPerfilFuncionario(@PathVariable("id") Integer id) {
		return funcionarioService.getPerfilFuncionario(id);
	}

	@GetMapping(value = "funcao")
	public @ResponseBody List<Funcao> getAllFuncao() {
		return funcionarioService.getAllFuncao();
	}

	@GetMapping(value = "cargo")
	public @ResponseBody List<Cargo> getAllCargo() {
		return funcionarioService.getAllCargo();
	}

	@GetMapping(value = "unidade")
	public @ResponseBody List<Unidade> getAllUnicade() {
		return funcionarioService.getAllUnidade();
	}

	@GetMapping(value = "status")
	public @ResponseBody List<StatusFuncionario> getAllStatus() {
		return funcionarioService.getallStatus();
	}

	/**
	 * 
	 * Metodo para retornar todas provisoes do funcionario
	 * 
	 * @param codigo
	 *            do funcionario
	 * @return lista de provisoes do usuario
	 */
	@GetMapping(value = "provisao/{id}")
	public @ResponseBody List<Provisao> getProvisoes(@PathVariable("id") Integer codigo) {
		return funcionarioService.getProvisoes(codigo);
	}

	@PostMapping(value = "provisao/add")
	public @ResponseBody Provisao addProvisao(@RequestBody Provisao entity) {

		funcionarioService.salvar(entity);

		return entity;
	}

	

}
