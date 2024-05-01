package br.univille.fabsoft_2024_1_petshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.univille.fabsoft_2024_1_petshop.entity.Cliente;
import br.univille.fabsoft_2024_1_petshop.service.ClienteService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;




@Controller
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService service;
    
    @GetMapping
    public ModelAndView index(){
        var listaClientes = service.getAll();
        return new ModelAndView("cliente/index","listaClientes",listaClientes);
    }

    @GetMapping("/novo")
    public ModelAndView novo(){
        var cliente = new Cliente();
        return new ModelAndView("cliente/form","cliente",cliente);
    }

    @PostMapping
    public ModelAndView save(Cliente cliente){
        service.save(cliente);
        return new ModelAndView("redirect:/clientes");
    }

    @GetMapping("/alterar/{id}")
    public ModelAndView alterar(@PathVariable("id") long id){
        var cliente = service.getById(id);
        return new ModelAndView("cliente/form","cliente",cliente);
    }

    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable("id") long id){
        service.delete(id);
        return new ModelAndView("redirect:/clientes");
    }
}
