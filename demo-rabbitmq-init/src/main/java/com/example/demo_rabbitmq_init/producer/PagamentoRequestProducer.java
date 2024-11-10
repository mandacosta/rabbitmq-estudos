package com.example.demo_rabbitmq_init.producer;

import com.example.demo_rabbitmq_init.dto.PagamentoDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PagamentoRequestProducer {

    @Autowired
    private AmqpTemplate amqpTemplate;

    private final ObjectMapper objectMapper = new ObjectMapper();

    public void integrar (PagamentoDTO pagamento) throws JsonProcessingException {
        String pagamentoString = objectMapper.writeValueAsString(pagamento);
        amqpTemplate.convertAndSend(
                "pagamento-request-exchange",
                "pagamento-request-route-key",
                pagamentoString
        );
    }
}
