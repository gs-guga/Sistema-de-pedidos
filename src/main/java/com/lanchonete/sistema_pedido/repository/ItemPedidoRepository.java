package com.lanchonete.sistema_pedido.repository;


import com.lanchonete.sistema_pedido.model.ItemPedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemPedidoRepository extends JpaRepository<ItemPedido, Long> {
}