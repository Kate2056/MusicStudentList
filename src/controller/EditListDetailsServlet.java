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
 * Servlet implementation class EditListDetailsServlet
 */
@WebServlet("/editListDetailsServlet")
public class EditListDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditListDetailsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ListDetailsHelper dao = new ListDetailsHelper();
		ListMusicStudentHelper lih = new ListMusicStudentHelper();
		MusicTeacherHelper mth = new MusicTeacherHelper();
		Integer tempId = Integer.parseInt(request.getParameter("id"));
		ListDetails listToUpdate = dao.searchForListDetailsById(tempId);
		String newListName = request.getParameter("listName");
		String musicTeacherName = request.getParameter("musicTeacherName");
		MusicTeacher newMusicTeacher = mth.findMusicTeacher(musicTeacherName);
		try{													
			String[] selectedStudents = request.getParameterValues("allStudentsToAdd");
			List<ListMusicStudent> selectedStudentsInList = new ArrayList<ListMusicStudent>();
			for(
				int i = 0; i < selectedStudents.length; i++) {
				System.out.println(selectedStudents[i]);
				ListMusicStudent c = lih.searchForStudentById(Integer.parseInt(selectedStudents[i]));
				selectedStudentsInList.add(c);
			}
			listToUpdate.setListOfStudents(selectedStudentsInList);
			}catch(NullPointerException ex) {					
				List<ListMusicStudent> selectedStudentsInList = new ArrayList<ListMusicStudent>();
				listToUpdate.setListOfStudents(selectedStudentsInList);
			}
			listToUpdate.setListName(newListName);
			listToUpdate.setMusicTeacher(newMusicTeacher);
			dao.updateList(listToUpdate);
			getServletContext().getRequestDispatcher("/viewAllListsServlet").forward(request, response);
		}
	}

