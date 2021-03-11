package org.weblioteca.application.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.weblioteca.application.model.Cliente;
// https://datatables.net/examples/styling/bootstrap4
@Repository                              
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
	List<Cliente> findByNomeContainingIgnoreCase(String nome);
}
