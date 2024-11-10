package com.example.demo_rabbitmq_init_worker.producer;

import com.example.demo_rabbitmq_init_worker.dto.PagamentoDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PagamentoSucessoProdutor {

    @Autowired
    private AmqpTemplate amqpTemplate;

    private final ObjectMapper objectMapper = new ObjectMapper();

    public void gerarResposta (PagamentoDTO pagamento) throws JsonProcessingException {
        pagamento.setStatus("approved");
        String pagamentoString = objectMapper.writeValueAsString(pagamento);
        amqpTemplate.convertAndSend(
                "pagamento-response-sucesso-exchange",
                "pagamento-response-sucesso-route-key",
                pagamentoString
        );
    }
}
