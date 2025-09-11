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

    public ItemPedido criarItemPedido(ItemPedido itemPedido){
        return itemPedidoRepository.save(itemPedido);
    }

    public ItemPedido itemPedidoById(Integer id){
        return itemPedidoRepository.findById(id).orElse(null);
    }

    public ItemPedido deleteItemPedido(Integer id){
        ItemPedido itemPedido = itemPedidoById(id);

        if (itemPedido == null){
            return null;
        }

        itemPedidoRepository.delete(itemPedido);
        return itemPedido;
    }

    public ItemPedido updateItemPedido(Integer id, ItemPedido itemPedido){
        ItemPedido ip = itemPedidoRepository.findById(id).orElse(null);

        if (ip == null){
            return null;
        }

        ip.setQuantidade(itemPedido.getQuantidade());
        ip.setPedido(itemPedido.getPedido());
        ip.setProduto(itemPedido.getProduto());

        return itemPedidoRepository.save(ip);
    }
}
