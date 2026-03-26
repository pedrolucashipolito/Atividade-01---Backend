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
import com.br.model.Usuario;
import com.br.repository.UsuarioRepository;


@RequestMapping("/cusuario/")
@RestController
@CrossOrigin(origins="*")
public class UsuarioController {
	
	
	//Cria o repositório JPA de forma automática e autogerenciado
	@Autowired
	private UsuarioRepository urep;
	
	
	//Método listar - trazer todos os usuários do banco
	@GetMapping("/usuario")
	public List<Usuario> listar(){
		
		return this.urep.findAll(Sort.by(Sort.Direction.DESC, "codigo"));
		
	}
	
	//Método consultar - trazer um usuário, caso exista, pelo codigo
	@GetMapping("/usuario/{id}")
	public ResponseEntity<Usuario> consultar(@PathVariable Long id) {
		
		Usuario usuario = this.urep.findById(id).orElseThrow(()->
		new ResourceNotFoundException("Usuario nao encontrado: " + id));
		
		return ResponseEntity.ok(usuario);
		
	}
	
	
	//Método inserir - insere um usuário
	@PostMapping("/usuario")
	public Usuario inserir(@RequestBody Usuario usuario) {
		
		return this.urep.save(usuario);
		
	}
}