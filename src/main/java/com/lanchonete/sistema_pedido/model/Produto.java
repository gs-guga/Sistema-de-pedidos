package com.lanchonete.sistema_pedido.model;

import jakarta.persistence.*; // entidade de banco de dados
import lombok.Data; //metodos automaticos
import java.math.BigDecimal; // valores monetarios com precisao

@Entity
@Data
public class Produto {
    @Id //indentificador
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto incremento
    private Long id; // tipo do id

    private String nome;
    private BigDecimal preco;
    private String categoria;

}
