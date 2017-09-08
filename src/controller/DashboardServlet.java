package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MoodDao;
import model.Mood;

@WebServlet("/dashboard")
public class DashboardServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	private List<Mood> mood;
	@Inject
	private MoodDao moodDao;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		getServletContext().setAttribute("CurrentMonth", LocalDate.now().getMonth());
		getServletContext().setAttribute("CurrentYear", LocalDate.now().getYear());
		LocalDate date = LocalDate.now();
		Month month = date.getMonth();
		String monthresp = String.valueOf(month);
		getServletContext().setAttribute("mood1Count",calcMood(1,monthresp));
		getServletContext().setAttribute("mood2Count",calcMood(2,monthresp));
		getServletContext().setAttribute("mood3Count",calcMood(3,monthresp));
		getServletContext().setAttribute("mood4Count",calcMood(4,monthresp));
		getServletContext().setAttribute("mood5Count",calcMood(5,monthresp));
		getServletContext().setAttribute("moodTotCount",calcMoodMonthTot(monthresp));
		getServletContext().setAttribute("mood1Pourc", moodPourcCalc(1));
		getServletContext().setAttribute("mood2Pourc", moodPourcCalc(2));
		getServletContext().setAttribute("mood3Pourc", moodPourcCalc(3));
		getServletContext().setAttribute("mood4Pourc", moodPourcCalc(4));
		getServletContext().setAttribute("mood5Pourc", moodPourcCalc(5));
		getServletContext().setAttribute("moodAVG", moodAvgCalc());
		request.setAttribute("mood", getMood());
		request.getRequestDispatcher("WEB-INF/dashboard.jsp").forward(request, response);
	}
	
	private List<Mood> getMood() {
		mood = moodDao.findAll();
		return new ArrayList<Mood>(mood);
	}
	
	private long moodPourcCalc(int mood) {
		long result =0;
		long mood1 =  (long) getServletContext().getAttribute("mood"+mood+"Count");
		long moodtot = (long)getServletContext().getAttribute("moodTotCount");
		if(moodtot!=0) {
			result = mood1*100/moodtot;
		}
		return result;
	}
	
	private long calcMood( int mood, String month) {
		long result = moodDao.countMoodMonth(mood,month);
		return result;
	}
	
	private long calcMoodMonthTot( String month) {
		long result = moodDao.countMoodMonthTot(month);
		return result;
	}
	
	private double moodAvgCalc() {
		long mood1 = (long)getServletContext().getAttribute("mood1Count");
		long mood2 = (long)getServletContext().getAttribute("mood2Count");
		long mood3 = (long)getServletContext().getAttribute("mood3Count");
		long mood4 = (long)getServletContext().getAttribute("mood4Count");
		long mood5 = (long)getServletContext().getAttribute("mood5Count");
		long moodtot = (long)getServletContext().getAttribute("moodTotCount");
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
