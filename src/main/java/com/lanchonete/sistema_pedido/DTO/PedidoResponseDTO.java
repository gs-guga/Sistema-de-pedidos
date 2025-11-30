package com.lanchonete.sistema_pedido.DTO;

import java.time.LocalDateTime;
import java.util.List;

public class PedidoResponseDTO {

    public Long id;
    public String status;
    public LocalDateTime dataHora;
    public List<ItemPedidoResponseDTO> itens;

}
