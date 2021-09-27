package br.com.tarefas.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.tarefas.model.Tarefa;
/* Essa classe não sera mais usada, será usada a JpaTarefaDao com Hibernate */

@Repository
public class JdbcTarefaDao implements TarefaDao {
   private Connection conexao;

   // O construtor recebe a conexao do proprio spring
   // nao sendo necessario o uso da ConnectionFactory
   @Autowired
   public JdbcTarefaDao(DataSource dataSource) {
      try {
         this.conexao = dataSource.getConnection();
      }
      catch (SQLException e) {
         e.printStackTrace();
      }
   }

   @Override
   public void cadastrar(Tarefa tarefa) {

      String sql = "insert into tarefas(descricao) values(?);";

      try (PreparedStatement ps = conexao.prepareStatement(sql)) {
         
         ps.setString(1, tarefa.getDescricao());
         ps.execute();
      } catch (SQLException e) {
         e.printStackTrace();
      }      
   }

   @Override
   public List<Tarefa> listar() {

      String sql = "select idtarefa, descricao, finalizado, data_finalizacao"
                   + " from tarefas;";

      List<Tarefa> lista = new ArrayList<>();
      
      try (PreparedStatement ps = conexao.prepareStatement(sql)) {
         
         ResultSet result = ps.executeQuery();
         
         while (result.next()) {

            Tarefa tarefa = new Tarefa();
            tarefa.setId(result.getInt("idtarefa"));
            tarefa.setDescricao(result.getString("descricao"));
            tarefa.setFinalizado(result.getBoolean("finalizado"));

            if (result.getDate("data_finalizacao") != null) {
               tarefa.setDataFinalizacao(result.getDate("data_finalizacao") 
                  .toLocalDate());
            }

            lista.add(tarefa);
         }

         result.close();

      } catch (SQLException e) {

         e.printStackTrace();
      }

      return lista;
   }
   
   @Override
   public Tarefa buscarPorId(int id) {

      String sql = "select descricao, finalizado, data_finalizacao"
                     + " from tarefas where idtarefa = ?;";
                     
      Tarefa tarefa = new Tarefa();

      try (PreparedStatement ps = conexao.prepareStatement(sql)) {
         
         ps.setInt(1, id);

         ResultSet result = ps.executeQuery();
         
         while (result.next()) {
            tarefa.setId(id);
            tarefa.setDescricao(result.getString("descricao"));
            tarefa.setFinalizado(result.getBoolean("finalizado"));
            
            if (result.getDate("data_finalizacao") != null) {
               tarefa.setDataFinalizacao(result.getDate("data_finalizacao") 
                  .toLocalDate());
            }
         }
      } catch (SQLException e) {
         e.printStackTrace();
      }

      return tarefa;
   }
   
   @Override
   public void alterar(Tarefa tarefa) {

      String sql = "update tarefas set descricao = ?, finalizado = ?,"
                     + " data_finalizacao = ? where idtarefa = ?;";
      
      try (PreparedStatement ps = conexao.prepareStatement(sql)) {
         
         ps.setString(1, tarefa.getDescricao());
         ps.setBoolean(2, tarefa.isFinalizado());
         ps.setDate(3, null);

         if (tarefa.getDataFinalizacao() != null) {
            ps.setDate(3, Date.valueOf(tarefa.getDataFinalizacao()));
         }

         ps.setInt(4, tarefa.getId());

         ps.execute();

      } catch (SQLException e) {
         e.printStackTrace();
      }
   }

   @Override
   public void deletar(Tarefa tarefa) {
      String sql = "delete from tarefas where idtarefa = ?;";

      try (PreparedStatement ps = conexao.prepareStatement(sql)) {
         
         ps.setInt(1, tarefa.getId());

         ps.execute();
      } catch (SQLException e) {
         e.printStackTrace();
      }
   }

   @Override
   public void finalizar(int id) {
      Tarefa tarefa = buscarPorId(id);
      
      tarefa.setFinalizado(true);
      tarefa.setDataFinalizacao(LocalDate.now());

      alterar(tarefa);
   }
}
