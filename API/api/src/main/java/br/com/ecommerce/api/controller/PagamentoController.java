package br.com.ecommerce.api.controller;

import br.com.ecommerce.api.dto.PagamentoCadastroDTO;
import br.com.ecommerce.api.dto.PagamentoDTO;
import br.com.ecommerce.api.model.Pagamento;
import br.com.ecommerce.api.service.PagamentoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/pagamentos")
public class PagamentoController {
    private final PagamentoService pagamentoService;

    public PagamentoController(PagamentoService service) {
        pagamentoService = service;
    }

    @GetMapping
    public ResponseEntity<List<PagamentoDTO>> getAllPagamento(){
        List<PagamentoDTO> pagamentos = pagamentoService.findAll();
        return ResponseEntity.ok(pagamentos);
    }

    @PostMapping
    public ResponseEntity<Pagamento> cadastrarPagamento(@RequestBody Pagamento pg){
        Pagamento pagamento = pagamentoService.cadastrarPagamento(pg);

        if (pagamento == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(pagamento);
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(pagamento);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getPagamentoById(@PathVariable Integer id){
        Pagamento pagamento = pagamentoService.pagamentoGetById(id);

        if (pagamento == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Metodo de pagamento nao encontrado");
        }

        return ResponseEntity.ok(pagamento);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePagamentoById(@PathVariable Integer id){
        Pagamento pagamento = pagamentoService.deletePagamentoById(id);

        if (pagamento == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Metodo de pagamento nao encontrado");
        }

        return ResponseEntity.ok(pagamento);
    }
}
