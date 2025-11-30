package com.lanchonete.sistema_pedido.service;

import com.lanchonete.sistema_pedido.DTO.ItemPedidoRequestDTO;
import com.lanchonete.sistema_pedido.DTO.ItemPedidoResponseDTO;
import com.lanchonete.sistema_pedido.mapper.ItemPedidoMapper;
import com.lanchonete.sistema_pedido.model.ItemPedido;
import com.lanchonete.sistema_pedido.model.Produto;
import com.lanchonete.sistema_pedido.repository.ItemPedidoRepository;
import com.lanchonete.sistema_pedido.repository.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemPedidoService {

    private final ItemPedidoRepository itemPedidoRepository;
    private final ItemPedidoMapper itemPedidoMapper;
    private final ProdutoRepository produtoRepository;

    public ItemPedidoService(ItemPedidoRepository itemPedidoRepository,
                             ItemPedidoMapper itemPedidoMapper,
                             ProdutoRepository produtoRepository) {

        this.itemPedidoRepository = itemPedidoRepository;
        this.itemPedidoMapper = itemPedidoMapper;
        this.produtoRepository = produtoRepository;
    }


    public List<ItemPedidoResponseDTO> listar() {
        return itemPedidoRepository.findAll()
                .stream()
                .map(itemPedidoMapper::toDTO)
                .toList();
    }


    public ItemPedidoResponseDTO cadastrar(ItemPedidoRequestDTO dto){


        Produto produto = produtoRepository.findById(dto.produtoId)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado!"));


        ItemPedido itemPedido = itemPedidoMapper.toEntity(dto, produto);


        ItemPedido salvo = itemPedidoRepository.save(itemPedido);


        return itemPedidoMapper.toDTO(salvo);
    }
}

