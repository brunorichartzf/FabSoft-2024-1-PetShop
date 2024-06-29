package br.univille.fabsoft_2024_1_petshop.service;

import java.util.Date;
import java.util.List;

import br.univille.fabsoft_2024_1_petshop.entity.Agendamento;
import br.univille.fabsoft_2024_1_petshop.entity.Cliente;
import br.univille.fabsoft_2024_1_petshop.entity.Pet;

public interface AgendamentoService {
    Agendamento save(Agendamento agendamento);
    List<Agendamento> getAllByDate(Date data);
    Agendamento getById(long id);
    List<Agendamento> getAll();
    Agendamento delete(long id);
    List<Agendamento> getAllByClienteId(long id);
}
