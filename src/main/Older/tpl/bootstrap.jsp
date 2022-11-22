<%@ page language="java" contentType="text/html; charset=ISO-8859-1" import="it.contrader.dto.UserDTO"
         pageEncoding="ISO-8859-1"%>

<%

  /**
   * Variabili globali ed inizializzazione dinamiche
   */

  /**
   * CONTROLLO LOGIN IN OGNI PAGINA
   * Controllo se utente accede a pagine dove deve essere loggato ma
   * non ha effettuato login
   */
  // Oggetto current user valorizzato se non presente in sessione
  if (request.getSession(false) == null) {
    // Se non presente in sessione significa che la sessione è scaduta oppure
    // che si sta accedendo senza aver effettuato il login e reindirizzo a lougout
    response.sendRedirect(request.getContextPath());
//    request.getRequestDispatcher("/index.jsp").forward(request,response);
  } else {
    UserDTO currentUser = (UserDTO) request.getSession().getAttribute("currentUser");
  }
%>
