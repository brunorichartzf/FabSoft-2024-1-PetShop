package br.univille.fabsoft_2024_1_petshop.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.univille.fabsoft_2024_1_petshop.entity.Agendamento;
import br.univille.fabsoft_2024_1_petshop.entity.Cliente;
import br.univille.fabsoft_2024_1_petshop.entity.Pet;
import br.univille.fabsoft_2024_1_petshop.repository.AgendamentoRepository;
import br.univille.fabsoft_2024_1_petshop.service.AgendamentoService;

@Service
public class AgendamentoServiceImpl 
    implements AgendamentoService {

    @Autowired
    private AgendamentoRepository repository;
    @Override
    public Agendamento save(Agendamento agendamento) {
        return repository.save(agendamento);
    }

    @Override
    public List<Agendamento> getAllByDate(Date data) {
        return repository.findAllByData(data);
    }
    
    @Override
    public List<Agendamento> getAll() {
       return repository.findAll();
    }

    @Override
    public Agendamento getById(long id) {
        return repository.getById(id);
    }

    @Override
    public List<Agendamento> getAllByClienteId(long id) {
       return repository.findAllByCliente_Id(id);
    }

    @Override
    public Agendamento delete(long id) {
        var agendamento = getById(id);
        repository.deleteById(id);
        return agendamento;
    }
}
