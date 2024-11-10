package com.example.demo_rabbitmq_init.consumer;

import com.example.demo_rabbitmq_init.services.PagamentoService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class PagamentoResponseSucessoConsumidor {

    @Autowired
    private PagamentoService pagamentoService;

    @RabbitListener(queues = {"pagamento-response-sucesso-queue"})
    public void receber(String message){
        pagamentoService.sucessoPagamento(message);
    }
}
