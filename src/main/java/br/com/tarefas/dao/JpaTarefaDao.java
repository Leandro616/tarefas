package br.com.tarefas.dao;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.com.tarefas.model.Tarefa;

@Repository
public class JpaTarefaDao implements TarefaDao {

   @PersistenceContext
   EntityManager manager;

   @Override
   public void cadastrar(Tarefa tarefa) {
      manager.persist(tarefa);
   }

   @Override
   public void alterar(Tarefa tarefa) {
      manager.merge(tarefa);
   }

   @Override
   public void deletar(Tarefa tarefa) {
      Tarefa t = buscarPorId(tarefa.getId());
      manager.remove(t);
   }

   @Override
   public void finalizar(int id) {
      Tarefa tarefa = buscarPorId(id);
      tarefa.setFinalizado(true);
      tarefa.setDataFinalizacao(LocalDate.now());
   }

   @Override
   public Tarefa buscarPorId(int id) {

      return manager.find(Tarefa.class, id);
   }

   @Override
   public List<Tarefa> listar() {
      
      return manager.createQuery("select t from Tarefa t")
         .getResultList();
   }
 
}
