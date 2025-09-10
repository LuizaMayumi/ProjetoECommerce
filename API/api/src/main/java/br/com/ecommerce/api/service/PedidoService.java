package br.com.ecommerce.api.service;

import br.com.ecommerce.api.model.Pedido;
import br.com.ecommerce.api.repository.PedidoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoService {

    private final PedidoRepository pedidoRepository;

    public PedidoService(PedidoRepository repo){
        pedidoRepository = repo;
    }

    public List<Pedido> findAll() {
        return pedidoRepository.findAll();
    }

    public Pedido criarPedido(Pedido p){
        return pedidoRepository.save(p);
    }

    public Pedido pedidoGetById(int id){
        return pedidoRepository.findById(id).orElse(null);
    }

    public Pedido deletePedidoById(int id){
        Pedido pedido = pedidoGetById(id);

        if (pedido == null){
            return null;
        }

        pedidoRepository.delete(pedido);
        return pedido;
    }
}
