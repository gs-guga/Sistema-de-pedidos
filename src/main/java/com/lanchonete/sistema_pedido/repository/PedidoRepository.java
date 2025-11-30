package com.lanchonete.sistema_pedido.repository;


import com.lanchonete.sistema_pedido.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
}
