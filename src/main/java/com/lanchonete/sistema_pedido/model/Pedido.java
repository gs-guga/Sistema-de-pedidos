package com.lanchonete.sistema_pedido.model;

import jakarta.persistence.*; //- permite que essa classe seja uma entidade do banco de dados
import lombok.Data;
import java.time.LocalDateTime; // data e hora do pedido
import java.util.List;

@Entity // diz ao Spring que essa classe será uma tabela no banco de dados
@Data

public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //auto incremento
    private Long id;
    private LocalDateTime dataHora;
    private String status;

    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL)
    private List<ItemPedido> itens;
}
