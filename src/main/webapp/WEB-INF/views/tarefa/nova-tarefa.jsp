<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!DOCTYPE html>
<html lang="pt-br">
   <c:import url="../head.jsp" />

   <body>
      <c:import url="../header.jsp" />

      <main class="container-sm">
         <h2 class="py-5 text-center">Nova Tarefa</h2>

         <h6 class="text-danger"><form:errors path="tarefa.descricao" /></h6>
   
         <form action="criar-tarefa" method="post">
            <div class="mb-3 col-7">
               <label for="descricao" class="form-label">Descrição</label>
               <textarea class="form-control" id="descricao" rows="2" name="descricao"></textarea>
            </div>

            <button type="submit" class="btn btn-success">Salvar</button>
         </form>
      </main>

   </body>
</html>