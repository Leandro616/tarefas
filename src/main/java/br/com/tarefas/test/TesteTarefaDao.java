package br.com.tarefas.test;

import java.sql.Connection;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import br.com.tarefas.dao.TarefaDao;
import br.com.tarefas.jdbc.ConnectionFactory;
import br.com.tarefas.model.Tarefa;

public class TesteTarefaDao {
   public static void main(String[] args) {
      Connection conexao = new ConnectionFactory().getConnection();

      /*testeCadastrar(conexao, "desenhar");
      testeCadastrar(conexao, "estudar");
      testeCadastrar(conexao, "limpar");
      testeCadastrar(conexao, "cozinhar");
      testeCadastrar(conexao, "almoçar");
      testeCadastrar(conexao, "jantar");
      testeCadastrar(conexao, "dormir");*/
      //testeListar(conexao);
      //testePesquisar(conexao);
      //testeAlterar(conexao);
      //testeDeletar(conexao);
      /*testeFinalizar(conexao, 11);
      testeFinalizar(conexao, 14);
      testeFinalizar(conexao, 17);*/
      //testeListaSeparada(conexao);
      //testeExibição();
      try {
         
         conexao.close();
      } catch (Exception e) {
         //TODO: handle exception
      }
   }

   /*private static void testeCadastrar(Connection conexao, String descricao) {
      Tarefa tarefa = new Tarefa();
      tarefa.setDescricao(descricao);

      TarefaDao dao = new TarefaDao(conexao);
      dao.cadastrar(tarefa);
   }

   private static void testeListar(Connection conexao) {
      TarefaDao dao = new TarefaDao(conexao);
     
      List<Tarefa> lista =  dao.getLista();
      
      for (Tarefa tarefa : lista) {
         if (tarefa.isFinalizado()) {
            System.out.printf("%d %s %s %s\n", tarefa.getId(),
               tarefa.getDescricao(), "finalizada em:", tarefa.getDataString());
         }
         else {
            System.out.printf("%d %s %s\n", tarefa.getId(),
               tarefa.getDescricao(), "não finalizada");
         }
      }
   }

   private static void testePesquisar(Connection conexao) {
      TarefaDao dao = new TarefaDao(conexao);
      Tarefa tarefa = dao.pesquisar(1);

      System.out.printf("%d %s", tarefa.getId(), tarefa.getDescricao());
   }

   private static void testeAlterar(Connection conexao) {
      TarefaDao dao = new TarefaDao(conexao);
      Tarefa tarefa = dao.pesquisar(6);

      tarefa.setDescricao("cozinhar");
      

      dao.alterar(tarefa);
   }

   private static void testeDeletar(Connection conexao) {
      TarefaDao dao = new TarefaDao(conexao);
      Tarefa tarefa = dao.pesquisar(3);

      dao.deletar(tarefa);
   }

   private static void testeFinalizar(Connection conexao, int id) {

      TarefaDao dao = new TarefaDao(conexao);
      Tarefa tarefa = dao.pesquisar(id);

      dao.finalizarTarefa(tarefa);
   }

   private static void testeListaSeparada(Connection conexao) {
      TarefaDao dao = new TarefaDao(conexao);

      List<Tarefa> lista = dao.getLista();

      List<Tarefa> listaFinalizadas = lista.stream()
         .filter((Tarefa tarefa) -> tarefa.isFinalizado())
         .collect(Collectors.toList());

      List<Tarefa> listaNaoFinalizadas = lista.stream()
         .filter((Tarefa tarefa) -> !tarefa.isFinalizado())
         .collect(Collectors.toList());

      System.out.println("Lista de Finalizadas");
      for (Tarefa tarefa : listaFinalizadas) {
         System.out.println(tarefa.getId() + " " + tarefa.getDescricao());
      }

      System.out.println("\nLista de Não Finalizadas");
      for (Tarefa tarefa : listaNaoFinalizadas) {
         System.out.println(tarefa.getId() + " " + tarefa.getDescricao());
      }


   }

   private static void testeExibição() {
      int tarefas = 8;
      
      for (int i = 0; i < tarefas; i++) {
         
         if (i == 0)
            System.out.println("Abertura");
            
         if (i % 3 == 0 && i != 0) {
            System.out.println("fechamento");
            System.out.println("Abertura");
         }

         System.out.println("   coluna");   
      }

      System.out.println("fechamento");
      
   }*/
}
