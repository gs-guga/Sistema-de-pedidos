package com.lanchonete.sistema_pedido.service;


import com.lanchonete.sistema_pedido.DTO.ProdutoRequestDTO;
import com.lanchonete.sistema_pedido.DTO.ProdutoResponseDTO;
import com.lanchonete.sistema_pedido.mapper.ProdutoMapper;
import com.lanchonete.sistema_pedido.model.Produto;
import com.lanchonete.sistema_pedido.repository.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProdutoService {

    private final ProdutoRepository repository;
    private final ProdutoMapper mapper;

    public ProdutoService(ProdutoRepository repository, ProdutoMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }


    public List<ProdutoResponseDTO> listar() {
        return repository.findAll()
                .stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }


    public ProdutoResponseDTO cadastrar(ProdutoRequestDTO dto) {

        Produto produto = mapper.toEntity(dto);
        Produto salvo = repository.save(produto);

        return mapper.toDTO(salvo);
    }
}

