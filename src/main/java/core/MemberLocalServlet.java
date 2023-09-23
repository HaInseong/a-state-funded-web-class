package core;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/memberlocal")
public class MemberLocalServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	int member_v = 0; //멤버변수는 서블릿 객체 생성(클라이언트로부터 서블릿 요청이 최초로 전달됐을 때)될 때 메모리에 같이 올라감. 한번 메모리 할당되면 서블릿 객체가 살아있는 한 유지된다.

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		int local_v = 0; //지역변수는 메서드 요청시마다 새롭게 만들어짐
		member_v++;
		local_v++;
		out.print("<h2>member_v(멤버변수) : " + member_v + "</h2>");
		out.print("<h2>local_v(지역변수) : " + local_v + "</h2>");
		out.close();
	}
}
