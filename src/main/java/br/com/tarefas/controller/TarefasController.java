package br.com.tarefas.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.tarefas.dao.TarefaDao;
import br.com.tarefas.model.Tarefa;

@Transactional
@Controller
public class TarefasController { 

   // utilizando a interface TarefaDao, 
   // temos duas implementações o spring não saberá qual deve implementar 
   // utilizamos o @Qualifier para dizer qual implementação usar
   // colocar 
   @Autowired
   @Qualifier("jpaTarefaDao")
   TarefaDao dao;
      
   @RequestMapping("criar-tarefa")
   public String criarTarefa(@Valid Tarefa tarefa, BindingResult result) {
      
      if (result.hasFieldErrors("descricao")) {
         return "tarefa/nova-tarefa";
      }
      
      dao.cadastrar(tarefa);

      // O retorno é um arquivo jsp, mas sem colocar o .jsp
      return "tarefa/tarefa-adicionada";
   }

   @RequestMapping("nova-tarefa")
   public String formTarefa() {
      return "tarefa/nova-tarefa";
   }

   @RequestMapping("lista-tarefas")
   public String listar(Model model) {

      List<Tarefa> listaFinalizadas = dao.listar().stream()
         .filter((Tarefa tarefa) -> tarefa.isFinalizado())
         .collect(Collectors.toList());

      List<Tarefa> listaNaoFinalizadas = dao.listar().stream()
         .filter((Tarefa tarefa) -> !tarefa.isFinalizado())
         .collect(Collectors.toList());
      
      // nome com hifen(tarefas-finalizadas) estava dando erro
      model.addAttribute("tarefasFinalizadas", listaFinalizadas);
      model.addAttribute("tarefasNaoFinalizadas", listaNaoFinalizadas);

      model.addAttribute("tarefas", dao.listar());

      return "tarefa/lista";
   }

   @RequestMapping("deletar-tarefa")
   public String deletar(Tarefa tarefa) {
   
      dao.deletar(tarefa);

      return "redirect:lista-tarefas";
   }

   @RequestMapping("concluir-tarefa") 
   public String concluir(Tarefa tarefa) {

      dao.finalizar(tarefa.getId());

      return "redirect:lista-tarefas";
   }
}
