package br.com.ecommerce.api.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PagamentoCadastroDTO {
    // Campos que o cliente DEVE enviar para criar um pagamento
    private Integer pedidoId;
    private String formaPagamento;
}
