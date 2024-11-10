package com.example.demo_rabbitmq_init.repository;

import com.example.demo_rabbitmq_init.model.Pagamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface PagamentoRepository extends JpaRepository<Pagamento, Integer> {
}
