package br.com.sgp.service;

import br.com.sgp.model.Projeto;
import br.com.sgp.repository.ProjetoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjetoService {

    @Autowired
    ProjetoRepository projetoRepository;

    public Projeto findByProjId(Integer projId) {
        return projetoRepository.getOne(projId);
    }

    public List<Projeto> listByFuncionarioId(Integer funcId) {
        return projetoRepository.listByFuncionarioId(funcId);
    }

    public List<Projeto> listAll() {
        return projetoRepository.findAll();
    }
}
