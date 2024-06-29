package br.univille.fabsoft_2024_1_petshop;

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

        var cliente1 = new Cliente();
        cliente1.setNome("Cliente1");
        cliente1.setTelefone(1234567890);
        cliente1.setEmail("cliente@email.com");
        cliente1.setEndereco("Rua 123");
        cliente1.setDataNascimento(new Date(2024,04,17));
        service.save(cliente1);

        var pet1 = new Pet();
        pet1.setNome("Pet1");
        pet1.setEspecie("Cachorro");
        pet1.setRaca("só deus sabe");
        pet1.setCliente(cliente1);
        petService.save(pet1);

        var funcionario1 = new Funcionario();
        funcionario1.setNome("Funcionário1");
        funcionarioService.save(funcionario1);

    }
}
