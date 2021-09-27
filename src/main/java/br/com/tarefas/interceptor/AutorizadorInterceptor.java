package br.com.tarefas.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;

public class AutorizadorInterceptor implements HandlerInterceptor {

   @Override
   public boolean preHandle(HttpServletRequest request,
         HttpServletResponse response, Object handler) throws Exception {
      
      String uri = request.getRequestURI();

      if (uri.endsWith("form-login") || uri.endsWith("efetuar-login") 
            || uri.contains("resources") || uri.endsWith("form-sign") 
            || uri.endsWith("efetuar-sign")) {

         return true;
      }

      if (request.getSession().getAttribute("usuarioLogado") != null) {

         return true;
      }

      response.sendRedirect("form-login");
      return false;
   }
}
