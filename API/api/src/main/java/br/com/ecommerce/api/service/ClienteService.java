package br.com.ecommerce.api.service;

import br.com.ecommerce.api.dto.ClienteDTO;
import br.com.ecommerce.api.model.Cliente;
import br.com.ecommerce.api.repository.ClienteRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClienteService {
//    Injecao de dependencia - Service depende de alguem

    private final ClienteRepository clienteRepository;
//    final: constante

    public ClienteService(ClienteRepository repo){
        clienteRepository = repo;
    }

    //  Listar clientes
    public List<ClienteDTO> findAll() {
        List<Cliente> clientes = clienteRepository.findAll();

        return clientes.stream()
                .map(this::converterParaListagemDTO)
                .collect(Collectors.toList());
    }


    public Cliente cadastrarCliente(Cliente cl) {
        return clienteRepository.save(cl);
    }

    public Cliente getById(Integer id) {
        return clienteRepository.findById(id).orElse(null);
    }

    public Cliente deletarClienteById(Integer id) {
        Cliente cliente = getById(id);

        if (cliente == null) {
            return null;
        }

        clienteRepository.delete(cliente);
        return cliente;
    }

//    public Cliente atualizarCliente(Integer id, Cliente clienteNovo) {
//
//    }


    private ClienteDTO converterParaListagemDTO(Cliente cliente) {
        ClienteDTO dto = new ClienteDTO();

        // Mapeamento campo a campo
        dto.setCliente_id(cliente.getId());
        dto.setEmail(cliente.getEmail());
        dto.setDataCadastro(cliente.getDataCadastro());
        dto.setNome_completo(cliente.getNomeCompleto());

        return dto;
    }

}


