package br.com.tarefas.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.tarefas.model.Usuario;

public class UsuarioDao {
   private Connection conexao;

   public UsuarioDao(Connection conexao) {
      this.conexao = conexao;
   }

   // Conferir este metodo
   public void cadastrar(Usuario usuario) {
      String sql = "insert into usuarios(email, senha) values(?, ?);";

      try (PreparedStatement ps = conexao.prepareStatement(sql)) {

         ps.setString(1, usuario.getEmail());
         ps.setString(2, usuario.getSenha());

         ps.execute();
         
      } catch (SQLException e) {
         e.printStackTrace();
      }
   }

   public Usuario pesquisar(String email) {
      String sql = "select idusuario, email, senha from usuarios "
         + "where email = ?;";

      try (PreparedStatement ps = conexao.prepareStatement(sql)) {
         ps.setString(1, email);
         ResultSet rs = ps.executeQuery();

         Usuario usuario = new Usuario();
         
         if (rs.next()) {
            
            usuario.setId(rs.getInt("idusuario"));
            usuario.setEmail(rs.getString("email"));
            usuario.setSenha(rs.getString("senha"));
         
            return usuario;
         }

      } catch (SQLException e) {
         e.printStackTrace();
      }

      return null;
   }
}
