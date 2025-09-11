package br.com.ecommerce.api.controller;

import br.com.ecommerce.api.dto.PagamentoDTO;
import br.com.ecommerce.api.model.Pagamento;
import br.com.ecommerce.api.service.PagamentoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/pagamentos")

@Tag(name = "Controller Pagamento", description = "Metodos do Pagamento")
public class PagamentoController {
    private final PagamentoService pagamentoService;

    public PagamentoController(PagamentoService service) {
        pagamentoService = service;
    }

    @GetMapping
    @Operation(
            summary = "Lista todos os pagamentos",
            description = "Lista todos, sem excecoes"
    )
    public ResponseEntity<List<PagamentoDTO>> getAllPagamento(){
        List<PagamentoDTO> pagamentos = pagamentoService.findAll();
        return ResponseEntity.ok(pagamentos);
    }

    @PostMapping
    @Operation(
            summary = "Cria um pagamento"
    )
    public ResponseEntity<Pagamento> cadastrarPagamento(@RequestBody Pagamento pg){
        Pagamento pagamento = pagamentoService.cadastrarPagamento(pg);

        if (pagamento == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(pagamento);
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(pagamento);
    }

    @GetMapping("/{id}")
    @Operation(
            summary = "Busca um pagamento por Id",
            description = "Retorna somente um item"
    )
    public ResponseEntity<?> getPagamentoById(@PathVariable Integer id){
        Pagamento pagamento = pagamentoService.pagamentoGetById(id);

        if (pagamento == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Metodo de pagamento nao encontrado");
        }

        return ResponseEntity.ok(pagamento);
    }

    @DeleteMapping("/{id}")
    @Operation(
            summary = "Deleta um pagamento por Id",
            description = "Apaga o registro no banco"
    )
    public ResponseEntity<?> deletePagamentoById(@PathVariable Integer id){
        Pagamento pagamento = pagamentoService.deletePagamentoById(id);

        if (pagamento == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Metodo de pagamento nao encontrado");
        }

        return ResponseEntity.ok(pagamento);
    }

    @PutMapping("/{id}")
    @Operation(
            summary = "Atualiza um pedido por Id"
    )
    public ResponseEntity<?> updatePagamentoById(@PathVariable Integer id, @RequestBody Pagamento pagamento){
        Pagamento pg = pagamentoService.updatePagamento(id, pagamento);

        if (pg == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Pagamento nao encontrado");
        }

        return ResponseEntity.ok(pagamento);
    }
}
