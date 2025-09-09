package br.com.ecommerce.api.service;

import br.com.ecommerce.api.model.Cliente;
import br.com.ecommerce.api.repository.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {
//    Injecao de dependencia - Service depende de alguem

    private final ClienteRepository clienteRepository;
//    final: constante

    public ClienteService(ClienteRepository repo){
        clienteRepository = repo;
    }

    //  Listar clientes
    public List<Cliente> findAll() {
        return clienteRepository.findAll();
    }


    public Cliente cadastrarCliente(Cliente cl) {
        return clienteRepository.save(cl);
    }

}


