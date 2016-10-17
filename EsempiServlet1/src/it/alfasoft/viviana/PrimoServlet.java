package it.alfasoft.viviana;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import sun.org.mozilla.javascript.internal.Context;

/**
 * Servlet implementation class PrimoServlet
 */
@WebServlet(description = "Questo è un esempio iniziale", urlPatterns = { "/Percorso" })
public class PrimoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			
			String nome=request.getParameter("username");
			response.setContentType("text/html");
			
			HttpSession session=request.getSession();//serve per mmorizzare i dati e contenerli
			ServletContext context=request.getServletContext();
			
			PrintWriter writer=response.getWriter();//torna dietro l'oggetto rsponse
			if(!nome.isEmpty() && nome!=null){//se la pass è giusta allora mando messaggio
				
				session.setAttribute("usernameSalvato", nome);
				context.setAttribute("userSalvatoContext",nome);
				}
			writer.println("ciao "+nome+"<br>");
			writer.println("ciao da session "+session.getAttribute("usernameSalvato")+"<br>");
			writer.println("ciao da context "+context.getAttribute("userSalvatoContext")+"<br>");
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		response.setContentType("text/html");
	
		PrintWriter writer=response.getWriter();//torna dietro l'oggetto rsponse
		if(password.equals("123")){//se la pass è giusta allora mando messaggio

		writer.println("Benvenuto "+ username);
		}else{
			//se  è sbagliata rimndo alla pagina login
			response.sendRedirect("login.html");
		}
		
		
}
}
