package br.univille.fabsoft_2024_1_petshop.service;

import java.util.List;

import br.univille.fabsoft_2024_1_petshop.entity.Produto;

public interface ProdutoService {
    void save(Produto produto);

    Produto getById(long id);

    List<Produto> getAll();

    Produto delete(long id);
}
