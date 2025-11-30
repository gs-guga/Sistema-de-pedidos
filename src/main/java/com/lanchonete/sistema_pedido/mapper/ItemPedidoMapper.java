package com.lanchonete.sistema_pedido.mapper;

import com.lanchonete.sistema_pedido.DTO.ItemPedidoRequestDTO;
import com.lanchonete.sistema_pedido.DTO.ItemPedidoResponseDTO;
import com.lanchonete.sistema_pedido.model.ItemPedido;
import com.lanchonete.sistema_pedido.model.Produto;
import org.springframework.stereotype.Component;

@Component
public class ItemPedidoMapper {


    private final ProdutoMapper produtoMapper;

    public ItemPedidoMapper(ProdutoMapper produtoMapper) {
        this.produtoMapper = produtoMapper;
    }

    public ItemPedido toEntity(ItemPedidoRequestDTO dto, Produto produto){
        ItemPedido item = new ItemPedido();
        item.setQuantidade(dto.quantidade);
        item.setProduto(produto);
        return item;
    }

    public ItemPedidoResponseDTO toDTO(ItemPedido entity){
        ItemPedidoResponseDTO dto = new ItemPedidoResponseDTO();
        dto.id = entity.getId();
        dto.quantidade = entity.getQuantidade();
        dto.produto = produtoMapper.toDTO(entity.getProduto());
        return dto;
    }
}
