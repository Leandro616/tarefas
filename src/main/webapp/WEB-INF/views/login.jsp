<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="pt-br">
   <c:url value="head.jsp" var="headUrl">
      <c:param name="css" value="resources/css/login.css" />
   </c:url>
   <c:import url="${headUrl}" />

   <body class="text-center">
      <c:import url="header.jsp" />

      <main class="form-signin">
         <form action="efetuar-login" method="POST">
            <h1 class="h3 mb-5 fw-normal">Login</h1>

            <p class="text-danger">${mensagem}</p>
            <div class="form-floating">
               <input type="email" class="form-control" name="email" id="email" 
                  placeholder="E-mail" autocomplete="none">
               <label for="email">E-mail</label>
            </div>
            <div class="form-floating">
               <input type="password" class="form-control" name="senha" id="senha" 
                  placeholder="Senha">
               <label for="senha">Senha</label>
            </div>
            <button class="btn w-100 btn-lg btn-primary" type="submit">Logar</button>
         </form>
      </main>

   </body>
</html>