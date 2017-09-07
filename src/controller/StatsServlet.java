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
import model.Member;

@WebServlet("/stats")
public class StatsServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private MemberDao userDao;
	
	public StatsServlet() {
	}
	
	@Override
	public void init() throws ServletException {
		getServletContext().setAttribute("liveUserCount", 0);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("WEB-INF/stats.jsp").forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Member u = parseUser(req);
		req.getSession().setAttribute("user", u);
		incrementLiveUserCount();
		userDao.save(u);
		resp.sendRedirect("dashboard");
	}
	
	private Member parseUser(HttpServletRequest req) {
		String name = req.getParameter("name");
		String mail = req.getParameter("mail");
		String birth = req.getParameter("birth");
		return new Member(name, mail, birth);
	}
	
	private void incrementLiveUserCount() {
		Integer liveUserCount = (Integer) getServletContext().getAttribute("liveUserCount");
		getServletContext().setAttribute("liveUserCount", liveUserCount + 1);
	}
}
