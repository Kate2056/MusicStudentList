package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddStudentsForListServlet
 */
@WebServlet("/addStudentsForListServlet")
public class AddStudentsForListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddStudentsForListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,
    	IOException {
    		// TODO Auto-generated method stub
    		ListMusicStudentHelper dao = new ListMusicStudentHelper();
    		request.setAttribute("allStudents", dao.showAllStudents());
    		if(dao.showAllStudents().isEmpty()){
    		request.setAttribute("allStudents", " ");
    		}
    		getServletContext().getRequestDispatcher("/new-list.jsp").forward(request, response);
    		}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
