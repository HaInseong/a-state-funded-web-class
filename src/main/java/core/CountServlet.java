package core;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/CountServlet")
public class CountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();

		HttpSession session = request.getSession();

		if (session.getAttribute("cnt") == null) {
			session.setAttribute("cnt", new int[1]); //보관하는 데이터는 반드시 객체여야한다. 그래서 엘리먼트 1개 짜리 배열 선언.
			//name="cnt" ? 아 key, value값으로 저장
		}
		int[] count = (int[]) session.getAttribute("cnt"); //getAttribute 리턴값이 Object라서 형변환하여 count라는 변수에 주소값을 담는다.
		count[0]++;
		out.print("<h3>당신은 " + count[0] + "번째 방문입니다.</h3>");
		out.close();
	}
}
