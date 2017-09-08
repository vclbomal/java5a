package controller;

import java.io.IOException;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import dao.MotmDao;
import model.Motm;

@WebServlet("/edit_motm")
public class Edit_motmServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private MotmDao motmDao;
	
	public Edit_motmServlet() {
		
	}
	@Override
	public void init() throws ServletException {

	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("WEB-INF/edit_motm.jsp").forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Motm motm = parseMotm(req);
		req.getSession().setAttribute("formulaire", motm);
		incrementMotmCount();
		motmDao.save(motm);
		resp.sendRedirect("index");
	}
	
	private Motm parseMotm(HttpServletRequest req) {
		String emailSubject = req.getParameter("emailSubject");
		String emailTemplate = req.getParameter("emailTemplate");
		String formTemplate = req.getParameter("formTemplate");
		return new Motm(emailSubject,emailTemplate,formTemplate);
		
	}
	

	private void incrementMotmCount() {
		LocalDate aujourdhui = LocalDate.now();
		LocalDate premJourMois = aujourdhui.with(TemporalAdjusters.firstDayOfNextMonth());
		int comparison = aujourdhui.compareTo(premJourMois);
		if (comparison == 0) {
			Integer motmCount = (Integer) getServletContext().getAttribute("motmCount");
			getServletContext().setAttribute("motmCount", motmCount + 1);
		}
	}
}

