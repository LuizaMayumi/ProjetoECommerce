package br.com.ecommerce.api.controller;

import br.com.ecommerce.api.model.Cliente;
import br.com.ecommerce.api.service.ClienteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
