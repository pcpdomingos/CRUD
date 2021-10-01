package br.org.generation.minhaFarmacia.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

import br.org.generation.minhaFarmacia.model.Login;
import br.org.generation.minhaFarmacia.repository.LoginRepository;

@RestController
@RequestMapping("/Longis")
@CrossOrigin (origins = "*", allowedHeaders = "*")
public class LoginController {
	
	@Autowired
	private LoginRepository loginRepository;
	
	@GetMapping
	public ResponseEntity<List<Login>> GetAll (){
		return ResponseEntity.ok(loginRepository.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Login> getById(@PathVariable long id){
		return loginRepository.findById(id).
				map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping("/nome{nome}")
	public ResponseEntity<List<Login>> GetByNome(@PathVariable String nome){
		return ResponseEntity.ok(loginRepository.findAllByNomeContainingIgnoreCase(nome));
	}
	
	@PostMapping
	public ResponseEntity<Login> postLogin (@RequestBody Login login){
		return ResponseEntity.status(HttpStatus.CREATED).body(loginRepository.save(login));
	}
	
	@PutMapping
	public ResponseEntity<Login> putLogin (@RequestBody Login login){
		return ResponseEntity.status(HttpStatus.OK).body(loginRepository.save(login));
	}
	
	@DeleteMapping("/{id}")
	public void deleteLogin(@PathVariable long id) {
	loginRepository.deleteById(id);
	
	}

}
