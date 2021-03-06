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

@WebServlet("/add_member")
public class Add_memberServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private MemberDao memberDao;
	
	public Add_memberServlet() {
	}
	
	@Override
	public void init() throws ServletException {
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("WEB-INF/add_member.jsp").forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Member u = parseUser(req);
		req.getSession().setAttribute("member", u);
		if(getServletContext().getAttribute("idActif") != null) {
			memberDao.update(Long.parseLong((String)getServletContext().getAttribute("idActif")),u.getName(),u.getMail(),u.getBirth());
			getServletContext().setAttribute("idActif", null);
			getServletContext().setAttribute("nameActif", null);
			getServletContext().setAttribute("mailActif", null);
			getServletContext().setAttribute("birthActif", null);
		}
		else {
			memberDao.save(u);
		}
		incrementMemberCount();
		resp.sendRedirect("index");
		
	}
	
	private Member parseUser(HttpServletRequest req) {
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String birth = req.getParameter("date");
		return new Member(name, email, birth);
	}
	
	private void incrementMemberCount() {
		getServletContext().setAttribute("memberCount", memberDao.count());

	}
	
}
