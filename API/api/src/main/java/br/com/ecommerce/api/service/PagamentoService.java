package br.com.ecommerce.api.service;

import br.com.ecommerce.api.repository.ClienteRepository;
import br.com.ecommerce.api.repository.PagamentoRepository;
import org.springframework.stereotype.Service;

@Service
public class PagamentoService {

    private final PagamentoRepository  pagamentoRepository;

    public PagamentoService(PagamentoRepository repo){
        pagamentoRepository = repo;
    }
}
