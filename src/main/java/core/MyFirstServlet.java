package core;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormatSymbols;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet({ "/MyFirstServlet", "/myfirst" })
public class MyFirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		LocalDate d = LocalDate.now();
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();

		String name = request.getParameter("name");
		if (name == null) {
			name = "geust";
		}
		DateFormatSymbols dfs = new DateFormatSymbols();
		String[] weekdays = dfs.getWeekdays();
		String kDay = weekdays[d.getDayOfWeek().getValue()];

		out.print("<h2>" + name + "님 반가워요! 오늘은 " + kDay + "입니다!!</h2>");
	}

}
