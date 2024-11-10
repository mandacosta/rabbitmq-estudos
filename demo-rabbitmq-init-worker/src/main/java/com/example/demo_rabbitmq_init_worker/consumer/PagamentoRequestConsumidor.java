package com.example.demo_rabbitmq_init_worker.consumer;

import com.example.demo_rabbitmq_init_worker.dto.PagamentoDTO;
import com.example.demo_rabbitmq_init_worker.producer.PagamentoErroProdutor;
import com.example.demo_rabbitmq_init_worker.producer.PagamentoSucessoProdutor;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Random;

@Component
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PagamentoRequestConsumidor {

    @Autowired
    private PagamentoErroProdutor erroProdutor;

    @Autowired
    private PagamentoSucessoProdutor sucessoProdutor;

    private final ObjectMapper objectMapper = new ObjectMapper();

    @RabbitListener(queues = {"pagamento-request-queue"})
    public void receberMensagem(String message) throws JsonProcessingException {
        PagamentoDTO pagamentoDTO = objectMapper.readValue(message, PagamentoDTO.class);
        if (new Random().nextBoolean()){
           sucessoProdutor.gerarResposta(pagamentoDTO);
        } else{
            erroProdutor.gerarResposta(pagamentoDTO);
        }

    }
}
