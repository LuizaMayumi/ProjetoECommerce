package br.com.ecommerce.api.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter

public class ProdutoDTO {
    private String nome_produto;
    private String descricao;
    private BigDecimal preco;
    private Integer estoque_disponivel;
    private String imagem_url;
}
