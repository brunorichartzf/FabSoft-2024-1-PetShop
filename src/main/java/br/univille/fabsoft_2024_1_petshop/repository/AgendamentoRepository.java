package br.univille.fabsoft_2024_1_petshop.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.univille.fabsoft_2024_1_petshop.entity.Agendamento;
import br.univille.fabsoft_2024_1_petshop.entity.Pet;

@Repository
public interface AgendamentoRepository extends JpaRepository<Agendamento,Long>{
    
    List<Agendamento> findAllByData(Date data);
    List<Agendamento> findAllByCliente_Id(long id);
}
