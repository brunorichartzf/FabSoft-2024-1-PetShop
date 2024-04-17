package br.univille.fabsoft_2024_1_petshop;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import br.univille.fabsoft_2024_1_petshop.entity.Cliente;
import br.univille.fabsoft_2024_1_petshop.service.ClienteService;

@Component
public class Startup {
    @Autowired
    private ClienteService service;
    
    @EventListener
    public void onApplicationEvent(ContextRefreshedEvent event){

        var cliente1 = new Cliente();
        cliente1.setNome("Bruno");
        cliente1.setEndereco("Perto da minha vó");
        cliente1.setDataNascimento(new Date(2024,04,17));
        service.save(cliente1);
    }
}
