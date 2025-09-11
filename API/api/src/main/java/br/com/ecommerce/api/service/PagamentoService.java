package br.com.ecommerce.api.service;

import br.com.ecommerce.api.dto.PagamentoDTO;
import br.com.ecommerce.api.model.Pagamento;
import br.com.ecommerce.api.repository.PagamentoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PagamentoService {

    private final PagamentoRepository  pagamentoRepository;

    public PagamentoService(PagamentoRepository repo){
        pagamentoRepository = repo;
    }

    public List<PagamentoDTO> findAll() {
        List<Pagamento> pagamentos =  pagamentoRepository.findAll();
        return pagamentos.stream()
                .map(this::converterParaListagemDTO)
                .collect(Collectors.toList());
    }

    private PagamentoDTO converterParaListagemDTO(Pagamento pagamento) {
        PagamentoDTO dto = new PagamentoDTO();

        // Mapeamento campo a campo
        dto.setFormaPagamento(pagamento.getFormaPagamento());
        dto.setStatus(pagamento.getStatus());
        dto.setDataPagamento(pagamento.getDataPagamento());

        return dto;
    }

    public Pagamento cadastrarPagamento(Pagamento pg){
        return pagamentoRepository.save(pg);
    }

    public Pagamento pagamentoGetById(Integer id) {
        return pagamentoRepository.findById(id).orElse(null);
    }

    public Pagamento deletePagamentoById(Integer id){
        Pagamento pagamento = pagamentoGetById(id);

        if(pagamento == null){
            return null;
        }

        pagamentoRepository.delete(pagamento);
        return pagamento;
    }

    public Pagamento updatePagamento(Integer id, Pagamento pagamento){
        Pagamento pg = pagamentoGetById(id);

        if(pagamento == null){
            return null;
        }

        pg.setStatus(pagamento.getStatus());
        pg.setFormaPagamento(pagamento.getFormaPagamento());
        pg.setDataPagamento(pagamento.getDataPagamento());

        return pagamentoRepository.save(pg);
    }
}
