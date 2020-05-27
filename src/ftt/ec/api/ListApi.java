package ftt.ec.api;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//TODO: Ler arquivo no init
//TODO: Criar MashMap no init() e carregar dados do arquivo
//TODO: Salvador dados no ArrayList no arquivo no destroy()
//TODO: Implementar os verbos HTTP para controlar a lista de dados

//https://www.lynda.com/Flask-tutorials/CRUD-REST-basics/521200/533063-4.html
//https://www.geeksforgeeks.org/hashmap-remove-method-in-java/
//-> JavaNotesForProfessionals.pdf
//https://books.goalkicker.com/JavaBook/

/**
 * Servlet implementation class ListApi
 */
@WebServlet("/ListApi")
public class ListApi extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private HashMap<String, String> userData;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListApi() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		// https://www.geeksforgeeks.org/hashmap-remove-method-in-java/
		
		 
		this.userData = new HashMap<String, String>(); //ID, Nome
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, 
			             HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("id");
		
		if (id == null) 
			response.getWriter().append(this.userData.toString()); //Retornar em fetch (paginação)
		else {
			try {
			response.getWriter().append(this.userData.get(id).toString());
			} catch(Exception e) {
				response.getWriter().append("Ops!! " + id + " not found!!");
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPut(request, response);
	}

	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String id = request.getParameter("id");
		String name = request.getParameter("name");
		
		response.getWriter().append(this.userData.put(id, name));
	}

	/**
	 * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
	 */
	protected void doDelete(HttpServletRequest request, 
			                HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("id");
		
		if(id != null) {
			response.getWriter().append(this.userData.remove(id));
		} else {
			response.getWriter().append("Ops! Inform an id number!");
		} //if
		
}

}
