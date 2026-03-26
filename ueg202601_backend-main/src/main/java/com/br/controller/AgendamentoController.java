package com.br.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.exception.ResourceNotFoundException;
import com.br.model.Agendamento;
import com.br.repository.AgendamentoRepository;


@RequestMapping("/cagendamento/")
@RestController
@CrossOrigin(origins="*")
public class AgendamentoController {
	
	
	//Cria o repositório JPA de forma automática e autogerenciado
	@Autowired
	private AgendamentoRepository agrep;
	
	
	//Método listar - trazer todos os agendamentos do banco
	@GetMapping("/agendamento")
	public List<Agendamento> listar(){
		
		return this.agrep.findAll(Sort.by(Sort.Direction.DESC, "codigo"));
		
	}
	
	//Método consultar - trazer um agendamento, caso exista, pelo codigo
	@GetMapping("/agendamento/{id}")
	public ResponseEntity<Agendamento> consultar(@PathVariable Long id) {
		
		Agendamento agendamento = this.agrep.findById(id).orElseThrow(()->
		new ResourceNotFoundException("Agendamento nao encontrado: " + id));
		
		return ResponseEntity.ok(agendamento);
		
	}
	
	
	//Método inserir - insere um agendamento
	@PostMapping("/agendamento")
	public Agendamento inserir(@RequestBody Agendamento agendamento) {
		
		return this.agrep.save(agendamento);
		
	}
}