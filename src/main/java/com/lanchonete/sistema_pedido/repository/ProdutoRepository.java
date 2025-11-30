package com.lanchonete.sistema_pedido.repository;

import com.lanchonete.sistema_pedido.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;// ja vem com os metodos prontos

//entidade que sera manipulada reconhecida por id
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}

