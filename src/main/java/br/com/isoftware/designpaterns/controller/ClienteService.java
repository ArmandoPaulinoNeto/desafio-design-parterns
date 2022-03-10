package br.com.isoftware.designpaterns.controller;

import br.com.isoftware.designpaterns.controller.iservice.ClienteIService;
import br.com.isoftware.designpaterns.controller.iservice.ZipCodeIService;
import br.com.isoftware.designpaterns.domain.Cliente;
import br.com.isoftware.designpaterns.domain.Endereco;
import br.com.isoftware.designpaterns.repository.ClienteRepository;
import br.com.isoftware.designpaterns.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class ClienteService implements ClienteIService {

    @Autowired
    ClienteRepository clienteRepository;

    @Autowired
    EnderecoRepository enderecoRepository;

    @Autowired
    ZipCodeIService zipCodeIService;

    @Override
    public Iterable<Cliente> findAllClients() {

        return clienteRepository.findAll();
    }

    @Override
    public Cliente findIdClient(Long id) {

        Optional<Cliente> cliente = clienteRepository.findById(id);
        return cliente.get();
    }

    @Override
    public boolean insert(Cliente cliente) {

        saveClient(cliente);
        return true;
    }


    @Override
    public boolean update(Long id, Cliente cliente) {

        Optional<Cliente> client = clienteRepository.findById(id);
        if(client.isPresent()){
            saveClient(cliente);
        }
        return false;
    }

    @Override
    public boolean delete(Long id) {
        clienteRepository.deleteById(id);
        return false;
    }

    private void saveClient(Cliente cliente) {
        String zipCode = cliente.getEndereco().getCep();
        Endereco address = enderecoRepository.findById(zipCode).orElseGet(() ->{
            Endereco newAddress = zipCodeIService.zipCodeConsult(zipCode);
            enderecoRepository.save(newAddress);
            return newAddress;
        });
        cliente.setEndereco(address);
        clienteRepository.save(cliente);
    }
}
