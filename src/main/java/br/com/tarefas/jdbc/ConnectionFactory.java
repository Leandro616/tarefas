package br.com.tarefas.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

   private Connection connection;

   public Connection getConnection() {
     
      String url = "jdbc:mysql://localhost/java_web_caelum";
      String user = "root";
      String password = "1234";

      try {

         Class.forName("com.mysql.jdbc.Driver");
         connection = DriverManager.getConnection(url, user, password);
         
         System.out.println("Conectando no banco de dados");
      } 
      catch (SQLException e) {
         e.printStackTrace();
      }
      catch (ClassNotFoundException e) {
         e.printStackTrace();
      }

      return connection;
   }
}
