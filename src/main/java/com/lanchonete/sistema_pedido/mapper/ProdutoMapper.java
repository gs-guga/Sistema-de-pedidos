package com.lanchonete.sistema_pedido.mapper;


import com.lanchonete.sistema_pedido.DTO.ProdutoRequestDTO;
import com.lanchonete.sistema_pedido.DTO.ProdutoResponseDTO;
import com.lanchonete.sistema_pedido.model.Produto;
import org.springframework.stereotype.Component;

@Component
public class ProdutoMapper {

    public Produto toEntity(ProdutoRequestDTO dto) {
        Produto produto = new Produto();
        produto.setNome(dto.nome);
        produto.setPreco(dto.preco);
        produto.setCategoria(dto.categoria);
        return produto;
    }

    public ProdutoResponseDTO toDTO(Produto entity) {
        ProdutoResponseDTO dto = new ProdutoResponseDTO();
        dto.id = entity.getId();
        dto.nome = entity.getNome();
        dto.preco = entity.getPreco();
        dto.categoria = entity.getCategoria();
        return dto;
    }
}

