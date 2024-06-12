package br.univille.fabsoft_2024_1_petshop.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.univille.fabsoft_2024_1_petshop.entity.Pet;
import br.univille.fabsoft_2024_1_petshop.service.ClienteService;
import br.univille.fabsoft_2024_1_petshop.service.PetService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;




@Controller
@RequestMapping("/pets")
public class PetController {

    @Autowired
    private PetService service;

    @Autowired
    private ClienteService clienteService;
    
    @GetMapping
    public ModelAndView index(){
        var listaPets = service.getAll();
        return new ModelAndView("pet/index","listaPets",listaPets);
    }

    @GetMapping("/novo")
    public ModelAndView novo(){
        var pet = new Pet();
        var listaClientes = clienteService.getAll();

        HashMap<String,Object> dados = new HashMap<>();
        dados.put("pet",pet);
        dados.put("listaClientes",listaClientes);

        return new ModelAndView("pet/form",dados);
    }

    @PostMapping
    public ModelAndView save(Pet pet){
        service.save(pet);
        return new ModelAndView("redirect:/pets");
    }

    @GetMapping("/alterar/{id}")
    public ModelAndView alterar(@PathVariable("id") long id){
        var pet = service.getById(id);
        var listaClientes = clienteService.getAll();

        HashMap<String,Object> dados = new HashMap<>();
        dados.put("pet",pet);
        dados.put("listaClientes",listaClientes);

        return new ModelAndView("pet/form",dados);
    }

    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable("id") long id){
        service.delete(id);
        return new ModelAndView("redirect:/pets");
    }
}
