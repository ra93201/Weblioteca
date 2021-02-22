package org.weblioteca.application.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.weblioteca.application.model.Cliente;
import org.weblioteca.application.repository.ClienteRepository;

@Service
public class ClienteServiceImpl implements ClienteService {
	@Autowired
	private ClienteRepository clienteRepository;

	@Override
	public List<Cliente> getAllClientes() {
		return clienteRepository.findAll();
	}

	@Override
	public void salvarCliente(Cliente cliente) {
		clienteRepository.save(cliente);
	}

	@Override
	public Cliente getClienteById(Long id) {
		Optional<Cliente> optional = clienteRepository.findById(id);
		Cliente cliente = null;
		if (optional.isPresent()) {
			cliente = optional.get();
		} else {
			throw new RuntimeException("Cliente nao encontrado com id = " + id);
		}
		return cliente;
	}

	@Override
	public void deletarClienteById(Long id) {
		clienteRepository.deleteById(id);
	}

	@Override
	public Page<Cliente> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection) {
		Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending()
				: Sort.by(sortField).descending();

		Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
		return this.clienteRepository.findAll(pageable);
	}
}
