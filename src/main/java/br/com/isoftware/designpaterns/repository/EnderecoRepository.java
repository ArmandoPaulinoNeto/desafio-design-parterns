package br.com.isoftware.designpaterns.repository;

import br.com.isoftware.designpaterns.domain.Endereco;
import org.springframework.data.repository.CrudRepository;

public interface EnderecoRepository extends CrudRepository<Endereco, String> {}
