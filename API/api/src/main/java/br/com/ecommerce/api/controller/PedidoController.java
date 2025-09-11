package br.com.ecommerce.api.controller;

import br.com.ecommerce.api.model.Pedido;
import br.com.ecommerce.api.service.PedidoService;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pedido")

public class PedidoController {
    private final PedidoService pedidoService;

    public PedidoController(PedidoService service){
        pedidoService = service;
    }

    @GetMapping
    public ResponseEntity<List<Pedido>> getAllPedido(){
        List<Pedido> pedidos = pedidoService.findAll();
        return ResponseEntity.ok(pedidos);
    }

    @PostMapping
    public ResponseEntity<Pedido> criarPedido(@RequestBody Pedido p){
        Pedido pedido = pedidoService.criarPedido(p);
        if (pedido == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(pedido);
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(pedido);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> pedidoGetById(@RequestParam Integer id){
        Pedido pedido = pedidoService.pedidoGetById(id);

        if (pedido == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Pedido nao encontrado");
        }

        return ResponseEntity.ok(pedido);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePedidoById(@PathVariable Integer id){
        Pedido pedido = pedidoService.deletePedidoById(id);

        if (pedido == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Pedido nao encontrado");
        }

        return ResponseEntity.ok(pedido);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updatePedidoById(@PathVariable Integer id, @RequestBody Pedido pedido){
        Pedido pd = pedidoService.deletePedidoById(id);
        if (pd == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Pedido nao encontrado");
        }

        return ResponseEntity.ok(pd);
    }
}
