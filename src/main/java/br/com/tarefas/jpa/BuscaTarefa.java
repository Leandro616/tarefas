package br.com.tarefas.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.tarefas.model.Tarefa;

public class BuscaTarefa {
   public static void main(String[] args) {
      Tarefa tarefaEncontrada = new Tarefa();
      

      EntityManagerFactory factory = Persistence
         .createEntityManagerFactory("tarefas");
      EntityManager manager = factory.createEntityManager();

      manager.getTransaction().begin();
      tarefaEncontrada = manager.find(Tarefa.class, 3);
      manager.getTransaction().commit();

      System.out.println(tarefaEncontrada.getId() + tarefaEncontrada.getDescricao());
   }
}
