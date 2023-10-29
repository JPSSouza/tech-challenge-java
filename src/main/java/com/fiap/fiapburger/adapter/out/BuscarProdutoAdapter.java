package com.fiap.fiapburger.adapter.out;

import com.fiap.fiapburger.adapter.out.repository.ProdutoRepository;
import com.fiap.fiapburger.adapter.out.repository.entity.ProdutoEntity;
import com.fiap.fiapburger.adapter.out.repository.mapper.ProdutoMapper;
import com.fiap.fiapburger.application.core.domain.ProdutoDTO;
import com.fiap.fiapburger.application.ports.out.BuscarProdutoOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class BuscarProdutoAdapter implements BuscarProdutoOutputPort {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private ProdutoMapper produtoMapper;

    @Override
    public ProdutoDTO buscar(Long id) {
        Optional<ProdutoEntity> produtoEntity = produtoRepository.findById(id);
        return produtoEntity.map(produtoMapper::toProdutoDTO).orElse(null);
    }
}