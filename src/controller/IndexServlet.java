package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;
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

@WebServlet("/index")
public class IndexServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private List<Member> member;
	private List<String> users;
	@Inject
	private MemberDao memberDao;
	
	public IndexServlet() {
		
	}
	
	@Override
	public void init() throws ServletException {
		getServletContext().setAttribute("memberCount", 0);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("member", getMembers());
		request.setAttribute("memberCount", getServletContext().getAttribute("memberCount"));
		request.getRequestDispatcher("WEB-INF/index.jsp").forward(request, response);
	}
	
	private List<String> getUsers(){
		return new ArrayList<String>(users);
	}
	
	private List<Member> getMembers() {
		member = memberDao.findAll();
		return new ArrayList<Member>(member);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
	
	private void decrementMemberCount(Member u) {
		//memberDao.delete(u);
		
		Integer memberCount = (Integer) getServletContext().getAttribute("memberCount");
		getServletContext().setAttribute("memberCount", memberCount - 1);
	}
	
	
	
}
