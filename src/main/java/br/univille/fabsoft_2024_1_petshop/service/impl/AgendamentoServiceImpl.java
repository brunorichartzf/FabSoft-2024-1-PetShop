package br.univille.fabsoft_2024_1_petshop.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.univille.fabsoft_2024_1_petshop.entity.Agendamento;
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
    
}
