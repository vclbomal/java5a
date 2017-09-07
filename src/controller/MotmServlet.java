package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MemberDao;
import dao.MoodDao;
import model.Member;
import model.Mood;

@WebServlet("/motm")
public class MotmServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private MoodDao moodDao;
	
	public MotmServlet() {
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("WEB-INF/motm.jsp").forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Mood u = parseMood(req);
		req.getSession().setAttribute("user", u);
		moodDao.save(u);
		resp.sendRedirect("dashboard");
	}
	
	private Mood parseMood(HttpServletRequest req) {
		String moodresp = req.getParameter("moodresp");
		String commentresp = req.getParameter("commentresp");
		String monthresp = req.getParameter("monthresp");
		String yearresp = req.getParameter("yearresp");
		String publicresp = req.getParameter("publicresp");
		int mood = Integer.parseInt(moodresp);
		int year=Integer.parseInt(yearresp);
		boolean pub= Boolean.parseBoolean(publicresp);
		return new Mood(mood, monthresp,year,commentresp,pub);
	}
}
