package br.com.isoftware.designpaterns.controller;

import br.com.isoftware.designpaterns.controller.iservice.ClienteIService;
import br.com.isoftware.designpaterns.domain.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("cliente")
public class ControllerRestClientes {

    @Autowired
    private ClienteIService clienteIService;

    @GetMapping
    public ResponseEntity<Iterable<Cliente>> findAllClients(){
        System.out.println("findAllClients");
        return ResponseEntity.ok(clienteIService.findAllClients());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Cliente> findIdClient(@PathVariable Long id){

        return ResponseEntity.ok(clienteIService.findIdClient(id));
    }
    @PostMapping
    public ResponseEntity<Cliente> insert(@RequestBody Cliente cliente){
        clienteIService.insert(cliente);
        return ResponseEntity.ok(cliente);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Cliente> updadte(@PathVariable Long id, @RequestBody Cliente cliente){
        clienteIService.update(id, cliente);
        return ResponseEntity.ok(cliente);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Cliente> delete(@PathVariable Long id){
        clienteIService.delete(id);
        return ResponseEntity.ok().build();
    }

    /*
    enviar imagem com javascript
        https://cursos.alura.com.br/forum/topico-envio-de-json-e-imagem-em-uma-requisicao-post-com-spring-boot-62481
    */
}
