package br.org.generation.minhaFarmacia.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.org.generation.minhaFarmacia.model.Login;

@Repository
public interface LoginRepository extends JpaRepository<Login, Long> {
	
	public List<Login> findAllByNomeContainingIgnoreCase (String nome);

}
