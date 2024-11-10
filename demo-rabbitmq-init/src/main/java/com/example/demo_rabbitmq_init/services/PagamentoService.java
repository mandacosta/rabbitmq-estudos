package com.example.demo_rabbitmq_init.services;

import com.example.demo_rabbitmq_init.dto.PagamentoDTO;
import com.example.demo_rabbitmq_init.model.Pagamento;
import com.example.demo_rabbitmq_init.producer.PagamentoRequestProducer;
import com.example.demo_rabbitmq_init.repository.PagamentoRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class PagamentoService {
    @Autowired
    private PagamentoRequestProducer producer;

    @Autowired
    private PagamentoRepository pagamentoRepository;

    public PagamentoDTO solicitaPagamento(PagamentoDTO request) throws JsonProcessingException {
        LocalDate data = LocalDate.now();
        Pagamento pagamento = new Pagamento(null, request.getNumeroPedido(), request.getValor(), request.getProduto(), "waiting_approval", data);
        Pagamento pagamentoSaved = pagamentoRepository.save(pagamento);
        PagamentoDTO pagamentoIntegrar = new PagamentoDTO(pagamentoSaved.getId(), request.getNumeroPedido(), request.getValor(), request.getProduto(), "waiting_approval");
        producer.integrar(pagamentoIntegrar);
        return pagamentoIntegrar;
    }

    public void sucessoPagamento(String payload) {
        System.out.println("=== RESPOSTA DE SUCESSO ===" + payload);
    }

    public void erroPagamento(String payload) {
        System.err.println("=== RESPOSTA DE ERRO ===" + payload);
    }
}
