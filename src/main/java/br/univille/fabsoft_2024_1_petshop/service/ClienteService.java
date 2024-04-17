package br.univille.fabsoft_2024_1_petshop.service;

import java.util.List;

import br.univille.fabsoft_2024_1_petshop.entity.Cliente;

public interface ClienteService {
    void save(Cliente cliente);

    Cliente getById(long id);

    List<Cliente> getAll();
}
