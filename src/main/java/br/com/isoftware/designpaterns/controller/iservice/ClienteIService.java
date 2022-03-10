package br.com.isoftware.designpaterns.controller.iservice;

import br.com.isoftware.designpaterns.domain.Cliente;

public interface ClienteIService {

    Iterable<Cliente> findAllClients();

    Cliente findIdClient(Long id);

    boolean insert(Cliente cliente);

    boolean update(Long id, Cliente cliente);

    boolean delete(Long id);
}
