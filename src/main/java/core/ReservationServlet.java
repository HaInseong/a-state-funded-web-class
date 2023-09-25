package core;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet({ "/ReservationServlet", "/reservation" })
public class ReservationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();

		String name = request.getParameter("name");
		// getParameter 입력되지 않은 파라미터의 경우 null이 아니라 빈문자열 반환함.
		String paw = request.getParameter("password");
		System.out.println(paw);
		String room = request.getParameter("room");
		String[] order = request.getParameterValues("order");
		String date = request.getParameter("date");
		String formattedDate = date.replace("-", "년 ").replace("-", "월 ") + "일";

		if (name == null || name == "") {
			RequestDispatcher rd = request.getRequestDispatcher("/first.html"); //이름이 항상 전달되는 것이 아니라서 전역변수로 생성하지 않고 필요할 때 생성하는게 좋음.
			rd.forward(request, response);
		} else if (paw == null || paw =="") {
			response.sendRedirect("http://www.daum.net"); // 절대 URI를 줌
		} else {
			out.println("<h1>" + name + "님의 예약내용</h1>");
			out.println("<hr>");
			out.println("<ul>");
//			out.println("<li>" + "룸 : " + room + "</li>");
			out.println("<li>룸 : " + room + "</li>");
			out.print("<li>" + "추가 요청사항 : ");
			if (order != null) {
				for (int i = 0; i < order.length; i++) {
					out.print(order[i]);
					if (i < order.length - 1) {
						out.print(", ");
					}
				}
			} else {
				out.println("없음");
			}
			out.println("</li>");
			out.println("<li>" + "예약 날짜 : " + formattedDate + "</li>");
			out.println("</ul>");

			out.print("<hr><a href='" + request.getHeader("referer") + "'>예약 입력 화면으로</a>");
		}
	}

}