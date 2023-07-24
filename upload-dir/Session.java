

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Session
 */
@WebServlet("/Session")
public class Session extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Session() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		 request.setAttribute("helo", "hello");
		request.getRequestDispatcher("/WEB-INF/Client.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
	  String  user =request.getParameter("user");
	  String  pass =request.getParameter("pass");
	  
	  HttpSession session = request.getSession(true);

	  
	  request.setAttribute("user", user);
	  
	  
	  if (user.equals("admin")&& pass.equals("admin")) {
	  
		  session.setAttribute("user", user);
      //  request.setAttribute("user", user);
		
              request.getRequestDispatcher("/User.jsp").forward(request, response);
	}
	  else 
	  {
		  request.setAttribute("msg", "erreeeeur !!!");
		  request.getRequestDispatcher("/WEB-INF/Client.jsp").forward(request, response);}
	}
	

}
