package br.com.tarefas.test;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Random;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;

public class TesteHashSalt {

   private static final Random RANDOM = new SecureRandom();

   public static void main(String[] args) throws UnsupportedEncodingException, DecoderException, NoSuchAlgorithmException {

      String senha = "leandro123";

      //System.out.println(Hex.encodeHexString(stringToHash(senha)));

      //System.out.println(Hex.encodeHexString(gerarSalt()));

      //System.out.println(Hex.encodeHexString(criarHashSalt(senha, gerarSalt())));

      autenticar(senha);
   }

   private static byte[] gerarSalt() throws DecoderException {

      byte[] salt = new byte[20];
      RANDOM.nextBytes(salt);

      return salt;
   }

   // Concatenar senha com o salt
   private static byte[] stringToHash(String senha) {
      try {
         MessageDigest digest = MessageDigest.getInstance("SHA-256");
         digest.reset();
         byte[] hash = digest.digest(senha.getBytes());

         return hash;
      } catch (Exception e) {
         e.printStackTrace();
      }

      return null;
   }

   private static byte[] HashSalt(String senha, byte[] salt) throws NoSuchAlgorithmException, DecoderException {
      MessageDigest digest = MessageDigest.getInstance("SHA-256");

      digest.reset();
      digest.update(salt);
      byte[] hash = digest.digest(senha.getBytes());

      return hash;
   }

   //
   private static void autenticar(String senha) throws DecoderException, NoSuchAlgorithmException {
      byte[] saltSalvo = Hex.decodeHex("7bf0cd961c974da98bf53e83466cbb554aba0c1d");
      String senhaSalva = "74c7a027edac7ee22a6603a32bbc5484fce5e81e6f628659fcb030c0e79a324d";
      
      boolean senhaCorreta = senhaSalva.equals(Hex.encodeHexString(HashSalt(senha, saltSalvo)));

      if (senhaCorreta) {
         System.out.println("Senha Correta!!");
      }
      else {
         System.out.println("Senha Incorreta!!!");
      }
   } 
}

/*
 * Exemplo public class Passwords {
 * 
 * private static final Random RANDOM = new SecureRandom(); private static final
 * int ITERATIONS = 10000; private static final int KEY_LENGTH = 256;
 * 
 * 
 * private Passwords() { }
 * 
 * 
 * public static byte[] getNextSalt() { byte[] salt = new byte[16];
 * RANDOM.nextBytes(salt); return salt; }
 * 
 * 
 * public static byte[] hash(char[] password, byte[] salt) { PBEKeySpec spec =
 * new PBEKeySpec(password, salt, ITERATIONS, KEY_LENGTH); Arrays.fill(password,
 * Character.MIN_VALUE); try { SecretKeyFactory skf =
 * SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1"); return
 * skf.generateSecret(spec).getEncoded(); } catch (NoSuchAlgorithmException |
 * InvalidKeySpecException e) { throw new
 * AssertionError("Error while hashing a password: " + e.getMessage(), e); }
 * finally { spec.clearPassword(); } }
 * 
 * 
 * public static boolean isExpectedPassword(char[] password, byte[] salt, byte[]
 * expectedHash) { byte[] pwdHash = hash(password, salt); Arrays.fill(password,
 * Character.MIN_VALUE); if (pwdHash.length != expectedHash.length) return
 * false; for (int i = 0; i < pwdHash.length; i++) { if (pwdHash[i] !=
 * expectedHash[i]) return false; } return true; }
 * 
 * 
 * public static String generateRandomPassword(int length) { StringBuilder sb =
 * new StringBuilder(length); for (int i = 0; i < length; i++) { int c =
 * RANDOM.nextInt(62); if (c <= 9) { sb.append(String.valueOf(c)); } else if (c
 * < 36) { sb.append((char) ('a' + c - 10)); } else { sb.append((char) ('A' + c
 * - 36)); } } return sb.toString(); } }
 * 
 * 
 */