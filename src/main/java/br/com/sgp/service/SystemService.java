package br.com.sgp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.sgp.model.Cidade;
import br.com.sgp.model.Estado;
import br.com.sgp.repository.CidadeRepository;
import br.com.sgp.repository.EstadoRepository;

@Service
public class SystemService {

	@Autowired
	CidadeRepository cidadeRepository;
	
	@Autowired
	EstadoRepository estadoRepository;
	
	public List<Estado> getEstados(){
		return estadoRepository.findAll();
	}
	
	
	public List<Cidade> getCidadeByEstado(Integer id){
		return cidadeRepository.getCidadesByEstado(id);
	}
	
	
}


