package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.time.LocalDate;
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

@WebServlet("/index")
public class IndexServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private List<Member> member;
	
	@Inject
	private MemberDao memberDao;
	@Inject
	private MoodDao moodDao;
	
	
	public IndexServlet() {
		
	}
	
	@Override
	public void init() throws ServletException {
		getServletContext().setAttribute("memberCount", 0);
		getServletContext().setAttribute("motmCount", (long)0);
		getServletContext().setAttribute("memberCount", memberDao.count());
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("member", getMembers());
		request.setAttribute("memberCount", getServletContext().getAttribute("memberCount"));
		getServletContext().setAttribute("mood1CountEver",calcMoodEver(1));
		getServletContext().setAttribute("mood2CountEver",calcMoodEver(2));
		getServletContext().setAttribute("mood3CountEver",calcMoodEver(3));
		getServletContext().setAttribute("mood4CountEver",calcMoodEver(4));
		getServletContext().setAttribute("mood5CountEver",calcMoodEver(5));
		getServletContext().setAttribute("moodTotCountEver",calcMoodEverTot());
		getServletContext().setAttribute("mood1PourcEver", moodPourcCalc(1));
		getServletContext().setAttribute("mood2PourcEver", moodPourcCalc(2));
		getServletContext().setAttribute("mood3PourcEver", moodPourcCalc(3));
		getServletContext().setAttribute("mood4PourcEver", moodPourcCalc(4));
		getServletContext().setAttribute("mood5PourcEver", moodPourcCalc(5));
		getServletContext().setAttribute("moodAVGEver", moodAvgCalcEver());
		request.getRequestDispatcher("WEB-INF/index.jsp").forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getParameter("buttonRemove") != null) {
            memberDao.delete(request.getParameter("buttonRemove"));
            getServletContext().setAttribute("memberCount", memberDao.count());
            getServletContext().setAttribute("buttonRemove",null);
    		doGet(request, response);
            }
		else if(request.getParameter("buttonEdit") != null){
			System.out.println(Long.parseLong(request.getParameter("buttonEdit")));
			getServletContext().setAttribute("idActif",request.getParameter("buttonEdit"));
			Member memberActif = memberDao.findOne(Long.parseLong(request.getParameter("buttonEdit")));//Long.getLong(request.getParameter("buttonEdit")));
			String mailActif = memberActif.getMail();
			String birthActif = memberActif.getBirth();
			String nameActif = memberActif.getName();
			getServletContext().setAttribute("mailActif",mailActif);
			getServletContext().setAttribute("birthActif",birthActif);
			getServletContext().setAttribute("nameActif",nameActif);
			response.sendRedirect("add_member");
		}
		

	}	
	
	/*@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
				memberDao.delete();;
	}*/

	private List<Member> getMembers() {
		member = memberDao.findAll();
		return new ArrayList<Member>(member);
	}
	
	private long calcMoodEver( int mood) {
		long result = moodDao.countMoodEver(mood);
		return result;
	}
	
private long calcMoodEverTot() {
	    long result = moodDao.count();
		return result;
	}
	
	private long moodPourcCalc(int mood) {
		long result =0;
		long mood1 =  (long) getServletContext().getAttribute("mood"+mood+"CountEver");
		long moodtot = (long)getServletContext().getAttribute("moodTotCountEver");
		if(moodtot!=0) {
			result = mood1*100/moodtot;
		}
		return result;
	}
	
	private double moodAvgCalcEver() {
		long mood1 = (long)getServletContext().getAttribute("mood1CountEver");
		long mood2 = (long)getServletContext().getAttribute("mood2CountEver");
		long mood3 = (long)getServletContext().getAttribute("mood3CountEver");
		long mood4 = (long)getServletContext().getAttribute("mood4CountEver");
		long mood5 = (long)getServletContext().getAttribute("mood5CountEver");
		long moodtot = (long)getServletContext().getAttribute("moodTotCountEver");
		double resultIntermediaire = (mood1+2*mood2+3*mood3+4*mood4+5*mood5);
		double result=0;
		if(moodtot!=0) {
			result = resultIntermediaire/(double)moodtot;
			result=(int)(result*100);
			result=result/100;
		}
		return result;
	}
	
	
	
}
