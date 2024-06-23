package br.univille.fabsoft_2024_1_petshop.service;

import java.util.Date;
import java.util.List;

import br.univille.fabsoft_2024_1_petshop.entity.Agendamento;

public interface AgendamentoService {
    Agendamento save(Agendamento agendamento);
    List<Agendamento> getAllByDate(Date data);

}
