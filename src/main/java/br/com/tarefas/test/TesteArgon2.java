package br.com.tarefas.test;

import java.sql.Connection;

import org.springframework.security.crypto.argon2.Argon2PasswordEncoder;

import br.com.tarefas.dao.UsuarioDao;
import br.com.tarefas.jdbc.ConnectionFactory;
import br.com.tarefas.model.Usuario;

public class TesteArgon2{
   

   public static void main(String[] args) {
      validarUsuario();
      
   }

   private static String criarHash(String senha) {
      Argon2PasswordEncoder encoder = new Argon2PasswordEncoder();

      return encoder.encode(senha);
   }

   private static boolean validarSenha(String senha, String hash) {
      Argon2PasswordEncoder encoder = new Argon2PasswordEncoder();

      return encoder.matches(senha, hash);
   }

   private static void cadastrarUsuario() {
      Connection conexao = new ConnectionFactory().getConnection();

      Usuario usuario = new Usuario();
      usuario.setEmail("joao@email.com");
      usuario.setSenha(criarHash("joao123"));

      UsuarioDao dao = new UsuarioDao(conexao);

      dao.cadastrar(usuario);
   }

   private static void validarUsuario() {
      Connection conexao = new ConnectionFactory().getConnection();
      UsuarioDao dao = new UsuarioDao(conexao);

      Usuario usuario = dao.pesquisar("joao@email.com");
      System.out.printf("usuario %d encontrado\n", usuario.getId());

      String senha = "Joao123";

      if (validarSenha(senha, usuario.getSenha()))
         System.out.println("Senha Correta!!");
      else 
         System.out.println("Senha Incorreta!!!!!");

   }
   
}
