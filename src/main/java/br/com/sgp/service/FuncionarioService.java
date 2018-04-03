package br.com.sgp.service;

import br.com.sgp.model.Funcionario;
import br.com.sgp.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class FuncionarioService {

    @Autowired
    FuncionarioRepository funcionarioRepository;

    //private BCryptPasswordEncoder bCryptPasswordEncoder;

    public Funcionario findByMatriculaAndSenha(String email, String senha) {

        Funcionario funcionario = findByEmail(email);

     //  if (funcionario != null && bCryptPasswordEncoder.matches(senha, funcionario.getFuncSenha())) {
    //        return funcionario;
//
    //    } else {
  //          return null;
   //     }

        return  funcionario;
    }


    public Funcionario findByEmail(String email) {
        return funcionarioRepository.findByEmail(email);


    }


}
