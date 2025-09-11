package br.com.ecommerce.api.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter

public class ClienteDTO {
    private Integer cliente_id;
    private String nome_completo;
    private String email;
    private LocalDate dataCadastro;
}
