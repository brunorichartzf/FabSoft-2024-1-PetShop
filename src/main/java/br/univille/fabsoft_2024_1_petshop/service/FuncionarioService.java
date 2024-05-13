package br.univille.fabsoft_2024_1_petshop.service;

import java.util.List;

import br.univille.fabsoft_2024_1_petshop.entity.Funcionario;

public interface FuncionarioService {
    void save(Funcionario funcionario);

    Funcionario getById(long id);

    List<Funcionario> getAll();

    Funcionario delete(long id);
}
