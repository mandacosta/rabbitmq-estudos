package com.example.demo_rabbitmq_init.consumer;

import com.example.demo_rabbitmq_init.services.PagamentoService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class PagamentoResponseErroConsumidor {

    @Autowired private PagamentoService pagamentoService;

    @RabbitListener(queues = {"pagamento-response-erro-queue"})
    public void receber(String message){
        pagamentoService.erroPagamento(message);
    }
}
