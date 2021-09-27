package br.com.tarefas.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.tarefas.model.Tarefa;

public class AdicionaTarefa {
   
   public static void main(String[] args) {

      Tarefa tarefa = new Tarefa();
      tarefa.setDescricao("cantar");

      EntityManagerFactory factory = Persistence.createEntityManagerFactory("tarefas");
      EntityManager manager = factory.createEntityManager();
      
      manager.getTransaction().begin();
      manager.persist(tarefa);
      manager.getTransaction().commit();
   }
}
