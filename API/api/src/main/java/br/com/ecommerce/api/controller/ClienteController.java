package br.com.ecommerce.api.controller;

import br.com.ecommerce.api.dto.ClienteDTO;
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
    public ResponseEntity<List<ClienteDTO>> getAllCliente(){
        List<ClienteDTO> clientes = clienteService.findAll();

        return ResponseEntity.ok(clientes);
    }

    @PostMapping
    public ResponseEntity<?> cadastrarCliente(@RequestBody Cliente cl){
        Cliente cliente = clienteService.cadastrarCliente(cl);
//        Para retornar 200
//        return ResponseEntity.ok(cliente);

        if (cliente == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Erro no cadastro de cliente");
        }
//        Para retornar 201
        return ResponseEntity.status(HttpStatus.CREATED).body(cliente);
    }

//    Request onde se envia um valor na url
    @GetMapping("/{id}")
    public ResponseEntity<?> getClienteById(@PathVariable Integer id){
        Cliente cliente = clienteService.getById(id);

        if (cliente == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Cliente nao encontrado");
        }
        return ResponseEntity.ok(cliente);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletarClienteById(@PathVariable Integer id){
        Cliente cliente = clienteService.deletarClienteById(id);

        if (cliente == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Cliente nao encontrado");
        }
        return ResponseEntity.ok(cliente);
    }
}
