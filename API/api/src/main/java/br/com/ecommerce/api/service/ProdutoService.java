package br.com.ecommerce.api.service;

import br.com.ecommerce.api.dto.ProdutoDTO;
import br.com.ecommerce.api.model.Produto;
import br.com.ecommerce.api.repository.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {
    private final ProdutoRepository produtoRepository;

    public ProdutoService(ProdutoRepository repo){
        produtoRepository = repo;
    }

    public List<Produto> findAll(){
        return produtoRepository.findAll();
    }

    public Produto cadastraProduto(Produto pr){
        return produtoRepository.save(pr);
    }

    public Produto produtoGetById(Integer id){
        return produtoRepository.findById(id).orElse(null);
    }

    public Produto deleteProdutoById(Integer id){
        Produto produto = produtoGetById(id);

        if (produto == null){
            return null;
        }

        produtoRepository.delete(produto);
        return produto;
    }

    public Produto updateProduto(Produto produto){
        Produto prod =  produtoGetById(produto.getId());

        if (prod == null){
            return null;
        }

        prod.setDescricao(produto.getDescricao());
        prod.setPreco(produto.getPreco());
        return produtoRepository.save(prod);
    }

    public ProdutoDTO converterParaListagemDTO(Produto produto){
        ProdutoDTO dto = new ProdutoDTO();

        dto.setDescricao(produto.getDescricao());
        dto.setNome_produto(produto.getNomeProduto());
        dto.setPreco(produto.getPreco());
        dto.setEstoque_disponivel(produto.getEstoqueDisponivel());
        dto.setImagem_url(produto.getImagemUrl());

        return dto;
    }
}
