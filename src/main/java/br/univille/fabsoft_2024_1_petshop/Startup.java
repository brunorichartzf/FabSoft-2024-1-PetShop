package br.univille.fabsoft_2024_1_petshop;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import br.univille.fabsoft_2024_1_petshop.entity.Cliente;
import br.univille.fabsoft_2024_1_petshop.entity.Funcionario;
import br.univille.fabsoft_2024_1_petshop.entity.Pet;
import br.univille.fabsoft_2024_1_petshop.service.ClienteService;
import br.univille.fabsoft_2024_1_petshop.service.FuncionarioService;
import br.univille.fabsoft_2024_1_petshop.service.PetService;

@Component
public class Startup {
    @Autowired
    private ClienteService service;
    @Autowired
    private PetService petService;
    @Autowired
    private FuncionarioService funcionarioService;
    
    @EventListener
    public void onApplicationEvent(ContextRefreshedEvent event){

    }
}
