package org.weblioteca.application.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.weblioteca.application.model.Autor;

@Service
public interface AutorService {
	List<Autor> getAllAutores();

	List<Autor> findByNomeContainingIgnoreCase(String nome);
	

/*
	List<Autor> findByActiveTrue();

	List<Autor> findByNameContainingAndActiveTrue(String name);

	List<Autor> findByNameContainingAndActiveFalse(String name);
	*/

	void salvarAutor(Autor autor);

	Autor getAutorById(Long id);

	void deletarAutorById(Long id);

	Page<Autor> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection);
}
