package br.com.ecommerce.api.service;

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
}
