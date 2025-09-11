package br.com.ecommerce.api.controller;

import br.com.ecommerce.api.model.Pedido;
import br.com.ecommerce.api.service.PedidoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pedido")

@Tag(name = "Controller Pedido", description = "Metodos do Pedido")
public class PedidoController {
    private final PedidoService pedidoService;

    public PedidoController(PedidoService service){
        pedidoService = service;
    }

    @GetMapping
    @Operation(
            summary = "Lista todos os pedidos",
            description = "Lista todos os pedidos, sem resticao"
    )
    public ResponseEntity<List<Pedido>> getAllPedido(){
        List<Pedido> pedidos = pedidoService.findAll();
        return ResponseEntity.ok(pedidos);
    }

    @PostMapping
    @Operation(
            summary = "Cria pedido",
            description = "Criacao do registro de pedido"
    )
    public ResponseEntity<Pedido> criarPedido(@RequestBody Pedido p){
        Pedido pedido = pedidoService.criarPedido(p);
        if (pedido == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(pedido);
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(pedido);
    }

    @GetMapping("/{id}")
    @Operation(
            summary = "Busca um pedido usando Id",
            description = "Busca pedido usando o id"
    )
    public ResponseEntity<?> pedidoGetById(@RequestParam Integer id){
        Pedido pedido = pedidoService.pedidoGetById(id);

        if (pedido == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Pedido nao encontrado");
        }

        return ResponseEntity.ok(pedido);
    }

    @DeleteMapping("/{id}")
    @Operation(
            summary = "Deleta um pedido usando Id",
            description = "Dado e apagado no banco, nao tem como recuperar"
    )
    public ResponseEntity<?> deletePedidoById(@PathVariable Integer id){
        Pedido pedido = pedidoService.deletePedidoById(id);

        if (pedido == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Pedido nao encontrado");
        }

        return ResponseEntity.ok(pedido);
    }

    @PutMapping("/{id}")
    @Operation(
            summary = "Atualiza um pedido por Id",
            description = "Busca pedido por id e atualiza o mesmo"
    )
    public ResponseEntity<?> updatePedidoById(@PathVariable Integer id, @RequestBody Pedido pedido){
        Pedido pd = pedidoService.deletePedidoById(id);
        if (pd == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Pedido nao encontrado");
        }

        return ResponseEntity.ok(pd);
    }
}
