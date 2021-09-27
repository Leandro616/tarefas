<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<header>
   <nav class="navbar navbar-expand-sm navbar-dark bg-dark">
      <div class="container-fluid">
         
         <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
         </button>
         <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
               <li class="nav-item">
               <a class="nav-link active" aria-current="page" href="index.jsp">Home</a>
               </li>
               <li class="nav-item">
               <a class="nav-link" href="lista-tarefas">Tarefas</a>
               </li>
               <li class="nav-item">
               <a class="nav-link" href="nova-tarefa">Nova</a>
               </li>
            </ul>
            <div class="d-flex">
               <c:choose>
                  <c:when test="${usuarioLogado == null}">
                     <a class="me-3 btn btn-outline-light" href="form-login">Entrar</a>
                     <a class="me-3 btn btn-success" href="form-sign">Inscrever-se</a>
                  </c:when>
                  <c:otherwise>
                     <a class="me-3 btn btn-outline-light" href="logout">Sair</a>
                  </c:otherwise>
               </c:choose>
            </div>
         </div>
      </div>
   </nav>
</header>