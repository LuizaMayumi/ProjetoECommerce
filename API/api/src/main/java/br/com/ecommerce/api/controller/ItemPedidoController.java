package br.com.ecommerce.api.controller;

import br.com.ecommerce.api.dto.itemPedidoDTO;
import br.com.ecommerce.api.model.ItemPedido;
import br.com.ecommerce.api.service.ItemPedidoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/itemPedido")

public class ItemPedidoController {
    private final ItemPedidoService itemPedidoService;

    public ItemPedidoController(ItemPedidoService service) {
        itemPedidoService = service;
    }

    @GetMapping
    public ResponseEntity<List<ItemPedido>> getAllItemPedidos(){
        List<ItemPedido> itemPedidos = itemPedidoService.findAll();
        return ResponseEntity.ok(itemPedidos);
    }
    
    @PostMapping
    public ResponseEntity<ItemPedido> criarItemPedido(@RequestBody ItemPedido ip){
        ItemPedido itemPedido = itemPedidoService.criarItemPedido(ip);

        if (itemPedido == null){
            return ResponseEntity.badRequest().build();
        }
        
        return ResponseEntity.status(HttpStatus.CREATED).body(itemPedido);
    }
}
