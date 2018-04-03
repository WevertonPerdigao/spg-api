package br.com.sgp.service;

import br.com.sgp.model.Funcionario;
import br.com.sgp.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FuncionarioService {

    @Autowired
    FuncionarioRepository funcionarioRepository;

    //private BCryptPasswordEncoder bCryptPasswordEncoder;

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

}
