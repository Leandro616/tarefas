package br.com.tarefas.dao;

import java.util.List;

import br.com.tarefas.model.Tarefa;

public interface TarefaDao {

   void cadastrar(Tarefa tarefa);
   void alterar(Tarefa tarefa);
   void deletar(Tarefa tarefa);
   void finalizar(int id);
   List<Tarefa> listar();
   Tarefa buscarPorId(int id);
}
