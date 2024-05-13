package br.univille.fabsoft_2024_1_petshop.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.univille.fabsoft_2024_1_petshop.entity.Funcionario;
import br.univille.fabsoft_2024_1_petshop.repository.FuncionarioRepository;
import br.univille.fabsoft_2024_1_petshop.service.FuncionarioService;

@Service
public class FuncionarioServiceImpl implements FuncionarioService{

    @Autowired
    private FuncionarioRepository repository;

    @Override
    public void save(Funcionario funcionario) {
        repository.save(funcionario);
    }

    @Override
    public Funcionario getById(long id) {
        return repository.getById(id);
    }

    @Override
    public List<Funcionario> getAll() {
       return repository.findAll();
    }

    @Override
    public Funcionario delete(long id) {
        var funcionario = getById(id);
        repository.deleteById(id);
        return funcionario;
    }
    
}
