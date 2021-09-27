package br.com.tarefas.test;

import org.apache.log4j.Logger;

public class HelloWordLog {
   
   public static void main(String[] args) {
      try {
         dividir();
      } catch (ArithmeticException e) {
         Logger log = Logger.getLogger(HelloWordLog.class);
         log.error("Exception não tratada no helloword", e);
      }
   }

   private static void dividir() {
      int i = 10 / 0;

      System.out.println("dividindo");
   }
}
