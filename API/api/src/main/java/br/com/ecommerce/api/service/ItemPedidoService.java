package br.com.ecommerce.api.service;

import br.com.ecommerce.api.repository.ItemPedidoRepository;
import org.springframework.stereotype.Service;

@Service
public class ItemPedidoService {
    private final ItemPedidoRepository itemPedidoRepository;

    public ItemPedidoService(ItemPedidoRepository repo) {
        itemPedidoRepository = repo;
    }
}
