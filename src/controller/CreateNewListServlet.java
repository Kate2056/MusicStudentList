package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ListDetails;
import model.ListMusicStudent;
import model.MusicTeacher;


/**
 * Servlet implementation class CreateNewListServlet
 */
@WebServlet("/createNewListServlet")
public class CreateNewListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateNewListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
    	// TODO Auto-generated constructor stub
    	ListMusicStudentHelper lih = new ListMusicStudentHelper();
    	String listName = request.getParameter("listName");
    	String musicTeacherName = request.getParameter("musicTeacherName");
    	String[] selectedStudents = request.getParameterValues("allStudentsToAdd");
    	List<ListMusicStudent> selectedStudentsInList = new ArrayList<ListMusicStudent>();
    	if (selectedStudents != null && selectedStudents.length > 0) {
    		for(int i = 0; i<selectedStudents.length; i++) {
    			System.out.println(selectedStudents[i]);
    			ListMusicStudent c = lih.searchForStudentById(Integer.parseInt(selectedStudents[i]));
    			selectedStudentsInList.add(c);
    		}
    	}
    	MusicTeacher musicTeacher = new MusicTeacher(musicTeacherName);
    	ListDetails mtl = new ListDetails(listName, musicTeacher);
    	mtl.setListOfStudents(selectedStudentsInList);
    	ListDetailsHelper mth = new ListDetailsHelper();
    	mth.insertNewListDetails(mtl);
    	System.out.println(mtl.toString());
    	getServletContext().getRequestDispatcher("/viewAllStudentsServlet").forward(request, response);
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
