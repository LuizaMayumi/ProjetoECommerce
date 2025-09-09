package br.com.ecommerce.api.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Getter
@Setter
public class PagamentoDTO {
    private String formaPagamento;
    private String status;
    private OffsetDateTime dataPagamento;
}
