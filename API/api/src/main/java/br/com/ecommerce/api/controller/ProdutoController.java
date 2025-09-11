package br.com.ecommerce.api.controller;

import br.com.ecommerce.api.model.Produto;
import br.com.ecommerce.api.service.ProdutoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/produtos")

@Tag(name = "Controller Produto", description = "Metodos do Produto")
public class ProdutoController {
    private final ProdutoService produtoService;

    public ProdutoController(ProdutoService service){
        produtoService = service;
    }

    @GetMapping
    @Operation(
            summary = "Lista todos os produtos",
            description = "Nao a filtros, retorna todos os dados"
    )
    public ResponseEntity<List<Produto>> getAllProdutos(){
        List<Produto> produtos = produtoService.findAll();
        return ResponseEntity.ok(produtos);
    }

    @PostMapping
    @Operation(
            summary = "Registra um produto"
    )
    public ResponseEntity<Produto> postProduto(@RequestBody Produto pr){
        Produto produto = produtoService.cadastraProduto(pr);

        if (produto == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(pr);
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(produto);
    }

    @GetMapping("/{id}")
    @Operation(
            summary = "Busca um produto usando Id"
    )
    public ResponseEntity<?> getProdutoById(@PathVariable Integer id){
        Produto produto = produtoService.produtoGetById(id);

        if (produto == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Produto nao encontrado");
        }

        return ResponseEntity.ok(produto);
    }

    @DeleteMapping("/{id}")
    @Operation(
            summary = "Deleta um produto usando Id",
            description = "Nao fica registro no banco"
    )
    public ResponseEntity<?> deleteProdutoById(@PathVariable Integer id){
        Produto produto = produtoService.deleteProdutoById(id);

        if (produto == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Produto nao encontrado");
        }

        return ResponseEntity.ok(produto);
    }

    @PutMapping("/{id}")
    @Operation(
            summary = "Atualiza um produto"
    )
    public ResponseEntity<?> putProduto(@PathVariable Integer id, @RequestBody Produto produto){
        Produto prod = produtoService.updateProduto(id, produto);

        if(produto == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Produto nao encontrado");
        }

        return  ResponseEntity.ok(produto);
    }
}
