package core;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/forward")
public class ForwardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("ForwardServlet 수행");
		RequestDispatcher rd = request.getRequestDispatcher("/clientexam/output.html"); //http가 제공하는 메서드로 포워드할 대상을 지정, 상대 URI를 줌.
		//forward는 같은 컨텍스트 안에 있는 것만 실행 가능하기 때문에 웹프로젝트 URI를 고정해두었다.
		/*RequestDispatcher rd = request.getRequestDispatcher("http://www.naver.com/");*/ //같은 컨텍스트 안에 존재해야한다.
		rd.forward(request,  response);
	}
}







