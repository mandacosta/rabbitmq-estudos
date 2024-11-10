package com.example.demo_rabbitmq_init_worker.dto;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.ToString;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class PagamentoDTO {
    private Integer id;
    private String numeroPedido;
    private Float valor;
    private String produto;
    private String status;
}

