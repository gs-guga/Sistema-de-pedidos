package com.lanchonete.sistema_pedido.service;

import com.lanchonete.sistema_pedido.DTO.PedidoRequestDTO;
import com.lanchonete.sistema_pedido.DTO.PedidoResponseDTO;
import com.lanchonete.sistema_pedido.DTO.ItemPedidoRequestDTO;
import com.lanchonete.sistema_pedido.mapper.ItemPedidoMapper;
import com.lanchonete.sistema_pedido.mapper.PedidoMapper;
import com.lanchonete.sistema_pedido.mapper.ProdutoMapper;
import com.lanchonete.sistema_pedido.model.ItemPedido;
import com.lanchonete.sistema_pedido.model.Pedido;
import com.lanchonete.sistema_pedido.model.Produto;
import com.lanchonete.sistema_pedido.repository.ItemPedidoRepository;
import com.lanchonete.sistema_pedido.repository.PedidoRepository;
import com.lanchonete.sistema_pedido.repository.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class PedidoService {

    private final PedidoRepository pedidoRepository;
    private final ProdutoRepository produtoRepository;
    private final ItemPedidoRepository itemPedidoRepository;
    private final PedidoMapper pedidoMapper;
    private final ItemPedidoMapper itemPedidoMapper;

    public PedidoService(PedidoRepository pedidoRepository,
                         ProdutoRepository produtoRepository,
                         ItemPedidoRepository itemPedidoRepository,
                         PedidoMapper pedidoMapper,
                         ItemPedidoMapper itemPedidoMapper) {

        this.pedidoRepository = pedidoRepository;
        this.produtoRepository = produtoRepository;
        this.itemPedidoRepository = itemPedidoRepository;
        this.pedidoMapper = pedidoMapper;
        this.itemPedidoMapper = itemPedidoMapper;
    }

    public PedidoResponseDTO cadastrar(PedidoRequestDTO dto) {


        Pedido pedido = pedidoMapper.toEntity(dto);
        pedido.setDataHora(LocalDateTime.now());

        Pedido pedidoSalvo = pedidoRepository.save(pedido);


        List<ItemPedido> itens = new ArrayList<>();

        for (ItemPedidoRequestDTO itemDTO : dto.itens) {


            Produto produto = produtoRepository.findById(itemDTO.produtoId)
                    .orElseThrow(() -> new RuntimeException("Produto não encontrado"));


            ItemPedido item = itemPedidoMapper.toEntity(itemDTO, produto);
            item.setPedido(pedidoSalvo);


            ItemPedido salvo = itemPedidoRepository.save(item);

            itens.add(salvo);
        }


        pedidoSalvo.setItens(itens);
        pedidoRepository.save(pedidoSalvo);

        return pedidoMapper.toDTO(pedidoSalvo);
    }

    public List<PedidoResponseDTO> listar() {
        return pedidoRepository.findAll()
                .stream()
                .map(pedidoMapper::toDTO)
                .toList();
    }
}

