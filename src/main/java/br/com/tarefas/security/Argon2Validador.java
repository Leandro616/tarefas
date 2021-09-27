package br.com.tarefas.security;

import org.springframework.security.crypto.argon2.Argon2PasswordEncoder;

public class Argon2Validador {
   private static final Argon2PasswordEncoder encoder = new Argon2PasswordEncoder();

   public static String criarHash(String senha) {
      
      return encoder.encode(senha);
   }

   public static boolean validarSenha(String senha, String hash) {
      
      return encoder.matches(senha, hash);
   }
}
