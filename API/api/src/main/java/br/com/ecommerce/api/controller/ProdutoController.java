package br.com.ecommerce.api.controller;

import br.com.ecommerce.api.model.Produto;
import br.com.ecommerce.api.service.ProdutoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
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
}
