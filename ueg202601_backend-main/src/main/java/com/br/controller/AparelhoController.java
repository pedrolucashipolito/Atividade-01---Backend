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
import com.br.model.Aparelho;
import com.br.repository.AparelhoRepository;


@RequestMapping("/caparelho/")
@RestController
@CrossOrigin(origins="*")
public class AparelhoController {
	
	
	//Cria o repositório JPA de forma automática e autogerenciado
	@Autowired
	private AparelhoRepository arep;
	
	
	//Método listar - trazer todos os aparelhos do banco
	@GetMapping("/aparelho")
	public List<Aparelho> listar(){
		
		return this.arep.findAll(Sort.by(Sort.Direction.DESC, "codigo"));
		
	}
	
	//Método consultar - trazer um aparelho, caso exista, pelo codigo
	@GetMapping("/aparelho/{id}")
	public ResponseEntity<Aparelho> consultar(@PathVariable Long id) {
		
		Aparelho aparelho = this.arep.findById(id).orElseThrow(()->
		new ResourceNotFoundException("Aparelho nao encontrado: " + id));
		
		return ResponseEntity.ok(aparelho);
		
	}
	
	
	//Método inserir - insere um aparelho
	@PostMapping("/aparelho")
	public Aparelho inserir(@RequestBody Aparelho aparelho) {
		
		return this.arep.save(aparelho);
		
	}
}