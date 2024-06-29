package br.univille.fabsoft_2024_1_petshop.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.PostMapping;

import br.univille.fabsoft_2024_1_petshop.entity.Agendamento;
import br.univille.fabsoft_2024_1_petshop.service.AgendamentoService;
import br.univille.fabsoft_2024_1_petshop.service.PetService;
import br.univille.fabsoft_2024_1_petshop.service.FuncionarioService;
import br.univille.fabsoft_2024_1_petshop.service.ClienteService;
import br.univille.fabsoft_2024_1_petshop.viewmodel.Agenda;
import br.univille.fabsoft_2024_1_petshop.viewmodel.Dia;
import br.univille.fabsoft_2024_1_petshop.viewmodel.Semana;

@Controller
@RequestMapping("/agenda")
public class AgendaController {

    @Autowired
    private AgendamentoService service;
    @Autowired
    private ClienteService clienteService;
    @Autowired
    private PetService petService;
    @Autowired
    private FuncionarioService funcionarioService;
    
    @GetMapping({"","/","/{mes}/{ano}"})
    public ModelAndView calendario(@PathVariable(name="mes",required = false) Integer mes,
                                @PathVariable(name="ano",required = false) Integer ano) {

        HashMap<String,Object> dados = new HashMap<>();
        
        var agenda = new Agenda();
        if(mes == null || ano == null){
            var today = LocalDate.now();
            mes = today.getMonthValue();
            ano = today.getYear();
        }
        if(mes > 12){
            mes = 1;
            ano = ano + 1;
        }
        if(mes < 1){
            mes = 12;
            ano = ano - 1;
        }
        agenda.setMes(mes);
        agenda.setAno(ano);

        var data = LocalDate.of(agenda.getAno(), agenda.getMes(), 1);
        for(int semanacalend=1; semanacalend <= 6; semanacalend++){
            var semana = new Semana();
            agenda.getListaSemanas().add(semana);
            for(int diacalend=1; diacalend <= 7; diacalend++){
                var dia = new Dia();
                semana.getListaDias().add(dia);
                LocalDate dayValue = null;
                var dayWeek = data.getDayOfWeek();
                if(dayWeek.getValue() == diacalend){
                    dayValue = data;
                    var agendamentos = service.getAllByDate(new Date(dayValue.getYear()-1900, dayValue.getMonth().ordinal(), dayValue.getDayOfMonth()));
                    if(agendamentos.size() != 0)
                        dia.getListaAgendamentos().addAll(agendamentos);
                    data = data.plusDays(1);
                    dia.setDia(dayValue.getDayOfMonth());
                    dia.setMes(dayValue.getMonth().ordinal());
                    dia.setAno(dayValue.getYear()-1900);
                }
                
            }
        }
        dados.put("agenda", agenda);

        var listaAgendamentos = service.getAll();
        dados.put("listaAgendamentos", listaAgendamentos);

        return new ModelAndView("agenda/index",dados);
    }
    
    @GetMapping("/novo/{data}")
    public ModelAndView novo(@PathVariable("data") String data){
        var agendamento = new Agendamento();
        LocalDate localDate = LocalDate.parse(data);
        Date dataValor = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
        agendamento.setData(dataValor);

        var listaClientes = clienteService.getAll();
        var listaPets = petService.getAll();
        var listaFuncionarios = funcionarioService.getAll();

        HashMap<String,Object> dados = new HashMap<>();
        dados.put("agendamento",agendamento);
        dados.put("listaClientes",listaClientes);
        dados.put("listaPets",listaPets);
        dados.put("listaFuncionarios",listaFuncionarios);
        return new ModelAndView("agenda/form",dados);
    }

    @PostMapping
    public ModelAndView save(Agendamento agendamento){
        service.save(agendamento);
        return new ModelAndView("redirect:/agenda");
    }

    @GetMapping("/alterar/{id}")
    public ModelAndView alterar(@PathVariable("id") long id){
        var agendamento = service.getById(id);
        var listaClientes = clienteService.getAll();
        var listaPets = petService.getAll();
        var listaFuncionarios = funcionarioService.getAll();

        HashMap<String,Object> dados = new HashMap<>();
        dados.put("agendamento",agendamento);
        dados.put("listaClientes",listaClientes);
        dados.put("listaPets",listaPets);
        dados.put("listaFuncionarios",listaFuncionarios);
        return new ModelAndView("agenda/form",dados);
    }

    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable("id") long id){
        service.delete(id);
        return new ModelAndView("redirect:/agenda");
    }
}
