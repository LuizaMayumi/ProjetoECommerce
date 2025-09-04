package br.com.ecommerce.api.service;

import br.com.ecommerce.api.repository.PedidoRepository;
import org.springframework.stereotype.Service;

@Service
public class PedidoService {

    private final PedidoRepository pedidoRepository;

    public PedidoService(PedidoRepository repo){
        pedidoRepository = repo;
    }
}
