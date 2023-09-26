
package core;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/basket2")
public class BasketServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();

		HttpSession session = request.getSession();
		if (session.getAttribute("cnt") == null) {
			session.setAttribute("cnt", new int[10]);
		}
		
		String product = request.getParameter("prod");
		int imageNum = getImageNum(product);
		
		System.out.println(product);
		System.out.println(imageNum);
		int[] count = (int[]) session.getAttribute("cnt");
		
		count[imageNum-1]++;
		

		out.print("<h1>선택한 상품 리스트</h1>");
		out.print("-------------------------------------------");
		out.print("<ul>");
		if (product != null) {
			// 선택한 상품이 있을 경우 기존 리스트에 카운팅하여 출력
			out.println("<li>" + product + " 상품 " + count[imageNum-1] + "개</li>");
		} else {
			// 선택한 상품이 없을 경우 메시지 표시
			out.println("<li>선택한 상품이 없습니다.</li>");
		}

		out.print("</ul>");

		out.print("<a href='" + request.getHeader("referer") + "'>상품 선택 화면</a>");
		
		out.print("&nbsp;" + "&nbsp;" + "&nbsp;" + "&nbsp;" + "&nbsp;");

		out.print("<a href='#'>" + " 상품 비우기 </a>");
	}
	private int getImageNum(String product) {
		switch (product) {
		case "p001":
			return 1;
		case "p002":
			return 2;
		case "p003":
			return 3;
		case "p004":
			return 4;
		case "p005":
			return 5;
		case "p006":
			return 6;
		case "p007":
			return 7;
		case "p008":
			return 8;
		case "p009":
			return 9;
		case "p010":
			return 10;
		default:
			return 0;
		}
	}
}
