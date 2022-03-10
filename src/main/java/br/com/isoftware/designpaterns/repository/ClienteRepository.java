package br.com.isoftware.designpaterns.repository;

import br.com.isoftware.designpaterns.domain.Cliente;
import org.springframework.data.repository.CrudRepository;

public interface ClienteRepository extends CrudRepository<Cliente, Long> {

}
