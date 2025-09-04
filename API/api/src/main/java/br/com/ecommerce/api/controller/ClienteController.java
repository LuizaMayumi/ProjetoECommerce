package br.com.ecommerce.api.controller;

import br.com.ecommerce.api.service.ClienteService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
// RequestMapping define a rota para encontrar a Controller cliente
@RequestMapping("/api/clientes")

public class ClienteController {
//    Controller depende do Service
//    Service depende de Repository

    private final ClienteService clienteService;

    public ClienteController(ClienteService service){
        clienteService = service;
    }
}
