package com.example.demo_rabbitmq_init.controllers;

import com.example.demo_rabbitmq_init.dto.PagamentoDTO;
import com.example.demo_rabbitmq_init.services.PagamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pagamentos")
public class PagamentoController {

    @Autowired
    private PagamentoService service;

    @PostMapping
    public ResponseEntity<?> processaPagamento(@RequestBody PagamentoDTO request){

        try{
            PagamentoDTO pago =  service.solicitaPagamento(request);
            return ResponseEntity.status(201).body(pago);

        }catch (Exception e){
            return ResponseEntity.status(500).body("Erro ao processar pagamento");
        }

    }
}
