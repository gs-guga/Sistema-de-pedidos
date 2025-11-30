package com.lanchonete.sistema_pedido.mapper;

import com.lanchonete.sistema_pedido.DTO.PedidoRequestDTO;
import com.lanchonete.sistema_pedido.DTO.PedidoResponseDTO;
import com.lanchonete.sistema_pedido.model.Pedido;
import org.springframework.stereotype.Component;

@Component
public class PedidoMapper {

    public Pedido toEntity(PedidoRequestDTO dto){
        Pedido pedido = new Pedido();
        pedido.setStatus(dto.status);
        return pedido;
    }

    public PedidoResponseDTO toDTO(Pedido entity){
        PedidoResponseDTO dto = new PedidoResponseDTO();
        dto.id = entity.getId();
        dto.status = entity.getStatus();
        dto.dataHora = entity.getDataHora();
        return dto;
    }
}

