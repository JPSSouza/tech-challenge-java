package com.fiap.fiapburger.adapter.out;

import com.fiap.fiapburger.adapter.out.repository.ProdutoRepository;
import com.fiap.fiapburger.adapter.out.repository.entity.ProdutoEntity;
import com.fiap.fiapburger.adapter.out.repository.mapper.ProdutoEntityMapper;
import com.fiap.fiapburger.application.core.domain.ProdutoDTO;
import com.fiap.fiapburger.application.core.exception.ProdutoNaoEncontradoException;
import com.fiap.fiapburger.application.core.exception.ExceptionsMessageEnum;
import com.fiap.fiapburger.application.ports.out.EditarProdutoOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EditarProdutoAdapter implements EditarProdutoOutputPort {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private ProdutoEntityMapper produtoEntityMapper;

    @Override
    public void editar(ProdutoDTO produtoDTO) {
        ProdutoEntity produtoEntity = produtoRepository.findById(produtoDTO.getId())
                .orElseThrow(() -> new ProdutoNaoEncontradoException(ExceptionsMessageEnum.PRODUTO_NAO_ENCONTRADO.value()));

        produtoEntityMapper.updateEntityFromDTO(produtoDTO, produtoEntity);
        produtoRepository.save(produtoEntity);
    }
}