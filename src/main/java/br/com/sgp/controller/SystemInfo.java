package br.com.sgp.controller;

import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.sgp.model.Cidade;
import br.com.sgp.model.Estado;
import br.com.sgp.service.SystemService;

@RestController
@RequestMapping("system")
public class SystemInfo {

	
	@Autowired
	SystemService systemService;
	
	
	@GetMapping(value = "clock")
	public ResponseEntity<?> getGetTime() {		
		Calendar c = Calendar.getInstance();
		return new ResponseEntity(c.getTime(),HttpStatus.OK);
	}

	
	
	@GetMapping(value = "estados")
	public @ResponseBody List<Estado> getEstados() {
		return systemService.getEstados();
	}
	
	
	@GetMapping(value = "cidade/{id}")
	public @ResponseBody List<Cidade> getCidades(@PathVariable("id") Integer id) {
		return systemService.getCidadeByEstado(id);
	}

	
	

}
