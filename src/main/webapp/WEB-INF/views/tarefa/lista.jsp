<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!DOCTYPE html>
<html lang="pt-br">
   <c:import url="../head.jsp" />

   <body>
      <c:import url="../header.jsp" />

      <main class="container-sm py-lg-5">
         <h3 class="text-center">Bem-vindo ${usuarioLogado.email} !</h3>
         <h2 class="my-5 ms-1">Lista de Tarefas</h2>

         <table class="table table-warning">
            <thead>
               <tr class="table-light">
                  <th scope="col" class="col-10">Descrição</th>
                  <th scope="col" class="col-1"></th>
                  <th scope="col" class="col-1"></th>
               </tr>
            </thead>
            <tbody>
               <c:forEach var="tarefa" items="${tarefasNaoFinalizadas}">
                  <tr>
                     <td>${tarefa.descricao}</td>
                     <td><a href="concluir-tarefa?id=${tarefa.id}" class="btn btn-success btn-sm">Concluir</a></td>
                     <td><a href="deletar-tarefa?id=${tarefa.id}" class="btn btn-danger btn-sm">
                        <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-trash" viewBox="0 0 16 16">
                           <path d="M5.5 5.5A.5.5 0 0 1 6 6v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5zm2.5 0a.5.5 0 0 1 .5.5v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5zm3 .5a.5.5 0 0 0-1 0v6a.5.5 0 0 0 1 0V6z"/>
                           <path fill-rule="evenodd" d="M14.5 3a1 1 0 0 1-1 1H13v9a2 2 0 0 1-2 2H5a2 2 0 0 1-2-2V4h-.5a1 1 0 0 1-1-1V2a1 1 0 0 1 1-1H6a1 1 0 0 1 1-1h2a1 1 0 0 1 1 1h3.5a1 1 0 0 1 1 1v1zM4.118 4 4 4.059V13a1 1 0 0 0 1 1h6a1 1 0 0 0 1-1V4.059L11.882 4H4.118zM2.5 3V2h11v1h-11z"/>
                        </svg>
                     </a></td>
                  </tr>
               </c:forEach>
            </tbody>
         </table>

         <h4 class="mt-5 mb-3 ms-1">Concluídas</h4>

         <table class="table table-success">
            <thead>
               <tr class="table-light">
                  <th scope="col" class="col-10">Descrição</th>
                  <th scope="col" class="col-2">Finalizado</th>
               </tr>
            </thead>
            <tbody>
               <c:forEach var="tarefa" items="${tarefasFinalizadas}">
                  <tr>
                     <td>${tarefa.descricao}</td>
                     <td>${tarefa.getDataString()}</td>
                  </tr>
               </c:forEach>
            </tbody>
         </table>

         <!-- CARDS 
            problema do tamanho da lista e problema do end inclusivo resolvido 
         <c:set var="tamanho" value="${fn:length(tarefasNaoFinalizadas)}" />
         <c:forEach var="num" begin="0" end="${tamanho - 1}">
            
            <c:if test="${num == 0}">
               <div class="row gx-4 mb-4 justify-content-center">
            </c:if>

            <c:if test="${num % 3 == 0 and num != 0}">
               </div>
               <div class="row gx-4 mb-4 justify-content-center">
            </c:if>


            <c:forEach var="tarefa" items="${tarefasNaoFinalizadas}" end="${num}">
               <c:set var="descricao" value="${tarefa.descricao}" />
               <c:set var="id" value="${tarefa.id}" />
            </c:forEach>

            <div class="col-3">
               <div class="card p-3 bg-light">
                  <div class="card-header">
                     <h5 class="card-title mb-4">${descricao}</h5>
                  </div>
                  <div class="d-inline">
                     <a href="concluir-tarefa?id=${id}" class="btn px-5 btn-success">Concluir</a>
                     <a href="deletar-tarefa?id=${id}" class="btn btn-danger">
                        <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-trash" viewBox="0 0 16 16">
                           <path d="M5.5 5.5A.5.5 0 0 1 6 6v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5zm2.5 0a.5.5 0 0 1 .5.5v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5zm3 .5a.5.5 0 0 0-1 0v6a.5.5 0 0 0 1 0V6z"/>
                           <path fill-rule="evenodd" d="M14.5 3a1 1 0 0 1-1 1H13v9a2 2 0 0 1-2 2H5a2 2 0 0 1-2-2V4h-.5a1 1 0 0 1-1-1V2a1 1 0 0 1 1-1H6a1 1 0 0 1 1-1h2a1 1 0 0 1 1 1h3.5a1 1 0 0 1 1 1v1zM4.118 4 4 4.059V13a1 1 0 0 0 1 1h6a1 1 0 0 0 1-1V4.059L11.882 4H4.118zM2.5 3V2h11v1h-11z"/>
                        </svg>
                     </a>
                  </div>
               </div>
            </div>

         </c:forEach>

         </div>

         <h4 class="mt-5 mb-3 ms-5" >Concluídas</h4>

         <c:set var="tamanho" value="${fn:length(tarefasFinalizadas)}" />
         <c:forEach var="num" begin="0" end="${tamanho - 1}">
            
            <c:if test="${num == 0}">
               <div class="row gx-4 mb-4 justify-content-center">
            </c:if>

            <c:if test="${num % 3 == 0 and num != 0}">
               </div>
               <div class="row gx-4 mb-4 justify-content-center">
            </c:if>


            <c:forEach var="tarefa" items="${tarefasFinalizadas}" end="${num}">
               <c:set var="descricao" value="${tarefa.descricao}" />
               <c:set var="data" value="${tarefa.getDataString()}" />
            </c:forEach>

            <div class="col-3">
               <div class="card p-3 bg-light">
                  <div class="card-header">               
                     <h5 class="card-title mb-4">${descricao}</h5>
                  </div>
                  <p class="card-text">Finalizado: ${data}</p>
               </div>
            </div>
            
         </c:forEach>

         </div>
         -->

      </main>
   </body>
</html>