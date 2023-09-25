package core;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet({ "/BasketServlet1", "/basket1" })
public class BasketServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();

		String product = request.getParameter("prod");
		String imagePath = getImagePath(product);

		out.print("<h1>선택한 상품: " + product + "</h1>");
		out.print("<img src=\"" + imagePath + "\" style=\"width:30%;\">");
		out.print("<hr>");
		out.print("<a href='" + request.getHeader("referer") + "'>상품 선택 화면</a>");
	}

	private String getImagePath(String product) {
		switch (product) {
		case "p001":
			return "/edu/images/1.jpg";
		case "p002":
			return "/edu/images/2.jpg";
		case "p003":
			return "/edu/images/3.jpg";
		case "p004":
			return "/edu/images/4.jpg";
		case "p005":
			return "/edu/images/5.jpg";
		case "p006":
			return "/edu/images/6.jpg";
		case "p007":
			return "/edu/images/7jpg";
		case "p008":
			return "/edu/images/8.jpg";
		case "p009":
			return "/edu/images/9.jpg";
		case "p010":
			return "/edu/images/10.jpg";
		default:
			return "/edu/images/default.jpg";
		}
	}
}
