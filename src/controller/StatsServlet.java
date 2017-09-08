package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.Month;
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

@WebServlet("/stats")
public class StatsServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private List<Mood> mood;
	
	@Inject
	private MoodDao moodDao;
	
	public StatsServlet() {
	}
	
	@Override
	public void init() throws ServletException {
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("moodStat", getMoods());
		String monthStat=request.getParameter("month");
		String yearStat=request.getParameter("year");
		request.setAttribute("monthget", monthStat);
		request.setAttribute("yearget", yearStat);
		request.setAttribute("moodCommentStat", getCommentMoods(monthStat,Integer.parseInt(yearStat)));
		getServletContext().setAttribute("mood1CountStat",calcMoodStat(1,monthStat,Integer.parseInt(yearStat)));
		getServletContext().setAttribute("mood2CountStat",calcMoodStat(2,monthStat,Integer.parseInt(yearStat)));
		getServletContext().setAttribute("mood3CountStat",calcMoodStat(3,monthStat,Integer.parseInt(yearStat)));
		getServletContext().setAttribute("mood4CountStat",calcMoodStat(4,monthStat,Integer.parseInt(yearStat)));
		getServletContext().setAttribute("mood5CountStat",calcMoodStat(5,monthStat,Integer.parseInt(yearStat)));
		getServletContext().setAttribute("moodTotCountStat",calcMoodStatTot(monthStat,Integer.parseInt(yearStat)));
		getServletContext().setAttribute("mood1PourcStat", moodPourcCalcStat(1));
		getServletContext().setAttribute("mood2PourcStat", moodPourcCalcStat(2));
		getServletContext().setAttribute("mood3PourcStat", moodPourcCalcStat(3));
		getServletContext().setAttribute("mood4PourcStat", moodPourcCalcStat(4));
		getServletContext().setAttribute("mood5PourcStat", moodPourcCalcStat(5));
		getServletContext().setAttribute("moodAVGStat", moodAvgCalcStat());
		request.getRequestDispatcher("WEB-INF/stats.jsp").forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.sendRedirect("dashboard");
	}
	
	private List<Mood> getMoods() {
		mood = moodDao.moodStat();
		return new ArrayList<Mood>(mood);
	}
	
	private List<Mood> getCommentMoods(String month, int year) {
		mood = moodDao.moodCommentStat(month,year);
		return new ArrayList<Mood>(mood);
	}
	
	private long moodPourcCalcStat(int mood) {
		long result =0;
		long mood1 =  (long) getServletContext().getAttribute("mood"+mood+"CountStat");
		long moodtot = (long)getServletContext().getAttribute("moodTotCountStat");
		if(moodtot!=0) {
			result = mood1*100/moodtot;
		}
		return result;
	}
	
	private long calcMoodStat( int mood, String month, int year) {
		long result = moodDao.countMoodStat(mood,month,year);
		return result;
	}
	
	private long calcMoodStatTot( String month, int year) {
		long result = moodDao.countMoodStatTot(month,year);
		return result;
	}
	
	private double moodAvgCalcStat() {
		long mood1 = (long)getServletContext().getAttribute("mood1CountStat");
		long mood2 = (long)getServletContext().getAttribute("mood2CountStat");
		long mood3 = (long)getServletContext().getAttribute("mood3CountStat");
		long mood4 = (long)getServletContext().getAttribute("mood4CountStat");
		long mood5 = (long)getServletContext().getAttribute("mood5CountStat");
		long moodtot = (long)getServletContext().getAttribute("moodTotCountStat");
		double resultIntermediaire = (mood1+2*mood2+3*mood3+4*mood4+5*mood5);
		double result;
		if(moodtot!=0) {
			result = resultIntermediaire/(double)moodtot;
			result=(int)(result*100);
			result=result/100;
		}
		else
			result = 0;
		return result;
	}
	
}
