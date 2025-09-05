package br.com.ecommerce.api.service;

import br.com.ecommerce.api.model.ItemPedido;
import br.com.ecommerce.api.repository.ItemPedidoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemPedidoService {
    private final ItemPedidoRepository itemPedidoRepository;

    public ItemPedidoService(ItemPedidoRepository repo) {
        itemPedidoRepository = repo;
    }

    public List<ItemPedido> findAll() {
        return itemPedidoRepository.findAll();
    }
}
