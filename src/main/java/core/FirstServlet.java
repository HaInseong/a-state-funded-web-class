package core;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet({ "/FirstServlet", "/first" }) //자바는 배열 { } 중괄호로 선언, 자스는 [ ] 대괄호로 선언
//서블릿 클래스 이름으로 요청하는 것은 보안적으로 좋지 않으므로 관례적으로 다른 매핑명을 설정하여 접근한다.
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	//404 상태코드: 서블릿 클래스를 찾지 못하는 경우 //405 상태코드: 요청한 방식과 지원한 방식이 맞지 않은 경우, url을 입력해서 요청하는 것은 무조건 get 방식으로 서버로 전달됨.
	//지원하는 방식의 메서드가 없다면 부모 클래스의 doGet을 찾아간다. 그 부모 클래스의 doGet 메서드는 요청한 방식과 지원한 방식이 맞지 않는다는 것으 알리게 설정되어 있다.
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("FirstServlet 실행....");
		response.setContentType("text/html; charset=utf-8"); //MIME 타입으로 작성, 브라우저는 이러한 설정이 없으면 모두 물음표 ?로 출력함.
		//마임타입에 오타 있으면 서블릿을 저장하려고 한다.
		//plain = 그냥 플레인(일반 텍스트) 타입이라는 의미
		PrintWriter out = response.getWriter();
		out.print("<h1 style=color:gold;>안녕? Servlet!!</h1>");
		out.close();
	}
}
