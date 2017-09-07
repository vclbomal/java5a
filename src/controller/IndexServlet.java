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
		getServletContext().setAttribute("mood1Count", 10);
		getServletContext().setAttribute("mood2Count", 5);
		getServletContext().setAttribute("mood3Count", 20);
		getServletContext().setAttribute("mood4Count", 10);
		getServletContext().setAttribute("mood5Count", 5);
		getServletContext().setAttribute("moodTotCount", 50);
		getServletContext().setAttribute("mood1Pourc", 0);
		getServletContext().setAttribute("mood2Pourc", 0);
		getServletContext().setAttribute("mood3Pourc", 0);
		getServletContext().setAttribute("mood4Pourc", 0);
		getServletContext().setAttribute("mood5Pourc", 0);
		getServletContext().setAttribute("moodAVG", 0);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("member", getMembers());
		request.setAttribute("memberCount", getServletContext().getAttribute("memberCount"));
		request.setAttribute("mood1Pourc", mood1PourcCalc());
		request.setAttribute("mood2Pourc", mood2PourcCalc());
		request.setAttribute("mood3Pourc", mood3PourcCalc());
		request.setAttribute("mood4Pourc", mood4PourcCalc());
		request.setAttribute("mood5Pourc", mood5PourcCalc());
		request.setAttribute("moodAVG", moodAvgCalc());
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
	
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
				decrementMemberCount();
	}
	
	private void decrementMemberCount() {
		memberDao.delete();
		Integer memberCount = (Integer) getServletContext().getAttribute("memberCount");
		//getServletContext().setAttribute("memberCount", memberCount - 1);
		getServletContext().setAttribute("memberCount", memberDao.count());
	}
	
	private int mood1PourcCalc() {
		Integer mood1 = (Integer)getServletContext().getAttribute("mood1Count");
		Integer moodtot = (Integer)getServletContext().getAttribute("moodTotCount");
		int result = mood1*100/moodtot;
		return result;
	}
	
	private int mood2PourcCalc() {
		Integer mood2 = (Integer)getServletContext().getAttribute("mood2Count");
		Integer moodtot = (Integer)getServletContext().getAttribute("moodTotCount");
		int result = mood2*100/moodtot;
		return result;
	}
	
	private int mood3PourcCalc() {
		Integer mood3 = (Integer)getServletContext().getAttribute("mood3Count");
		Integer moodtot = (Integer)getServletContext().getAttribute("moodTotCount");
		int result = mood3*100/moodtot;
		return result;
	}
	
	private int mood4PourcCalc() {
		Integer mood4 = (Integer)getServletContext().getAttribute("mood4Count");
		Integer moodtot = (Integer)getServletContext().getAttribute("moodTotCount");
		int result = mood4*100/moodtot;
		return result;
	}
	
	private int mood5PourcCalc() {
		Integer mood5 = (Integer)getServletContext().getAttribute("mood5Count");
		Integer moodtot = (Integer)getServletContext().getAttribute("moodTotCount");
		int result = mood5*100/moodtot;
		return result;
	}
	
	private double moodAvgCalc() {
		Integer mood1 = (Integer)getServletContext().getAttribute("mood1Count");
		Integer mood2 = (Integer)getServletContext().getAttribute("mood2Count");
		Integer mood3 = (Integer)getServletContext().getAttribute("mood3Count");
		Integer mood4 = (Integer)getServletContext().getAttribute("mood4Count");
		Integer mood5 = (Integer)getServletContext().getAttribute("mood5Count");
		Integer moodtot = (Integer)getServletContext().getAttribute("moodTotCount");
		double resultIntermediaire = (mood1+2*mood2+3*mood3+4*mood4+5*mood5);
		double result = resultIntermediaire/moodtot;
		return result;
	}
	
	
	
}
