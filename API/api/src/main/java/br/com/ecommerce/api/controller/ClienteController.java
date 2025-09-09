package br.com.ecommerce.api.controller;

import br.com.ecommerce.api.model.Cliente;
import br.com.ecommerce.api.service.ClienteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
// RequestMapping define a rota para encontrar a Controller cliente
@RequestMapping("/api/clientes")

public class ClienteController {
//    Controller depende do Service
//    Service depende de Repository
//    Repository depende do Banco de dados

    private final ClienteService clienteService;

    public ClienteController(ClienteService service){
        clienteService = service;
    }

//    Listar todos
    @GetMapping
    public ResponseEntity<List<Cliente>> getAllCliente(){
        List<Cliente> clientes = clienteService.findAll();
        return ResponseEntity.ok(clientes);
    }

    @PostMapping
    public ResponseEntity<Cliente> cadastrarCliente(@RequestBody Cliente cl){
        Cliente cliente = clienteService.cadastrarCliente(cl);
//        Para retornar 200
//        return ResponseEntity.ok(cliente);

        if (cliente == null){
            return ResponseEntity.badRequest().build();
        }
//        Para retornar 201
        return ResponseEntity.status(HttpStatus.CREATED).body(cliente);
    }
}
