package br.com.ecommerce.api.controller;

import br.com.ecommerce.api.model.Produto;
import br.com.ecommerce.api.service.ProdutoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {
    private final ProdutoService produtoService;

    public ProdutoController(ProdutoService service){
        produtoService = service;
    }

    @GetMapping
    public ResponseEntity<List<Produto>> getAllProdutos(){
        List<Produto> produtos = produtoService.findAll();
        return ResponseEntity.ok(produtos);
    }

    @PostMapping
    public ResponseEntity<Produto> postProduto(@RequestBody Produto pr){
        Produto produto = produtoService.cadastraProduto(pr);

        if (produto == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(pr);
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(produto);
    }
}
