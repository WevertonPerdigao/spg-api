package br.com.sgp.service;

import br.com.sgp.model.Cargo;
import br.com.sgp.model.Funcao;
import br.com.sgp.model.Funcionario;
import br.com.sgp.model.Perfil;
import br.com.sgp.model.Setor;
import br.com.sgp.model.StatusFuncionario;
import br.com.sgp.model.Unidade;
import br.com.sgp.repository.CargoRepository;
import br.com.sgp.repository.FuncaoRepository;
import br.com.sgp.repository.FuncionarioRepository;
import br.com.sgp.repository.PerfilRepository;
import br.com.sgp.repository.SetorRepository;
import br.com.sgp.repository.StatusFuncionarioRepository;
import br.com.sgp.repository.UnidadeRepository;
import br.com.sgp.security.PasswordEncoder;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FuncionarioService {

	@Autowired
	FuncionarioRepository funcionarioRepository;

	@Autowired
	SetorRepository setorRepository;

	@Autowired
	PerfilRepository perfilRepository;
	
	@Autowired
	FuncaoRepository funcaoRepository;

	@Autowired
	CargoRepository cargoRepository;
	
	@Autowired
	UnidadeRepository unidadeRepository;
	
	@Autowired
	StatusFuncionarioRepository statusRepository;
	
	@Autowired
	PasswordEncoder encoder;

	public Funcionario findByMatriculaAndSenha(String email, String senha) {

		Funcionario funcionario = findByEmail(email);

		return funcionario;
	}

	public Funcionario findByEmail(String email) {
		return funcionarioRepository.findByEmail(email);
	}

	public List<Funcionario> listAll() {
		return funcionarioRepository.findAll();
	}

	/**
	 * Metodo para salvar e criptografar a senha
	 * 
	 * @param entity
	 */
	public void salvar(Funcionario entity) {
		entity.setFuncSenha(encoder.encode(entity.getFuncSenha()));// criptografa senha

		funcionarioRepository.save(entity);
	}

	public List<Setor> getAllSetor() {

		return setorRepository.findAll();
	}

	public List<Perfil> getAllPerfil() {

		return perfilRepository.findAll();
	}

	public List<Funcao> getAllFuncao() {
		
		return funcaoRepository.findAll();
	}

	public List<Cargo> getAllCargo() {
		
		return cargoRepository.findAll();
	}

	public List<Unidade> getAllUnidade() {

		return unidadeRepository.findAll();
	}

	public List<StatusFuncionario> getallStatus() {

		return statusRepository.findAll();
	}

}
