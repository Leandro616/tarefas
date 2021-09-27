package br.com.tarefas.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.tarefas.dao.UsuarioDao;
import br.com.tarefas.jdbc.ConnectionFactory;
import br.com.tarefas.model.Usuario;
import br.com.tarefas.security.Argon2Validador;

@Controller
public class LoginController {
   
   @RequestMapping("form-login")
   public String formLogin() {
      return "login";
   }

   @RequestMapping("efetuar-login")
   public String efetuarLogin(HttpSession session, Usuario usuario) {

      UsuarioDao dao = new UsuarioDao(new ConnectionFactory().getConnection());
      Usuario usu = dao.pesquisar(usuario.getEmail());

      if (usu == null) {
         session.setAttribute("mensagem", "Usuario nao encontrado");

         return "redirect:form-login";
      }
      else {

         if (Argon2Validador.validarSenha(usuario.getSenha(), usu.getSenha())) {
            session.setAttribute("usuarioLogado", usu);

            return "redirect:lista-tarefas";
         }
         else {
            session.setAttribute("mensagem", "Senha incorreta");
            return "redirect:form-login";
         }
      }
      
   }

   @RequestMapping("logout")
   public String efetuarLogout(HttpSession session) {
      session.invalidate();
      return "redirect:loginForm";
   }

   @RequestMapping("form-sign") 
   public String formSign() {
      return "sign-up";
   }

   @RequestMapping("efetuar-sign") 
   public String efetuarSign(HttpSession session, Usuario usuario) {

      UsuarioDao dao = new UsuarioDao(new ConnectionFactory().getConnection());

      if (dao.pesquisar(usuario.getEmail()) != null) {
         session.setAttribute("mensagem", "E-mail já cadastrado");

         return "redirect:form-sign";
      }
      else {
         String hash = Argon2Validador.criarHash(usuario.getSenha());
         usuario.setSenha(hash);
         
         dao.cadastrar(usuario);

         session.setAttribute("usuarioLogado", usuario);

         return "redirect:lista-tarefas";
      }   
   }
}
