package core;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet({ "/VisitorServlet", "/visitor" })
public class VisitorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8"); 
		
		LocalDate d = LocalDate.now();
		DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy년 MM월 dd일");
		PrintWriter out = response.getWriter();
		
		String name = request.getParameter("name");
		String memo = request.getParameter("memo");
		if (name == null) {
			name = "geust";
		}
		
		String day = d.format(dateFormatter);
		
		out.print("<h1>" + name + "님이 " + day + "에 남긴글입니다!!</h1>");
		out.print("<hr>");
		out.print("<h2>" + memo + "</h2>");
		
		
		out.print("<a href='"+request.getHeader("referer")+"'>입력화면으로 가기</a>"); // 바로전의 url을 뽑는 메서드, referer 속성은 내장 속성인가봄
	}

}
