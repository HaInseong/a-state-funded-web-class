package core;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet({ "/getHTML", "/getXML", "/getJSON", "/getImage" })
public class ResponseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String uri = request.getRequestURI();
		System.out.println(uri);
		System.out.println(getServletContext().getServerInfo());
		System.out.println(getServletContext().getContextPath());
		System.out.println(getServletContext().getRealPath("/"));
		System.out.println(getServletContext().getMajorVersion());
		System.out.println(getServletContext().getMinorVersion());
		String filename = "";
		String contentType = "";
		if (uri.endsWith("getHTML")) {
			filename = getServletContext().getRealPath("/")+"/clientexam/sample.html";	
			contentType = "text/html; charset=utf-8";
		} else if (uri.endsWith("getXML")) {
			filename = getServletContext().getRealPath("/")+"/clientexam/sample.xml";	
			contentType = "text/xml; charset=utf-8";
		} else if (uri.endsWith("getJSON")) {
			filename = getServletContext().getRealPath("/")+"/clientexam/sample.json";	
			contentType = "text/json; charset=utf-8";
		} else {
			filename = getServletContext().getRealPath("/")+"/images/trans_duke.png";	
			contentType = "image/png";
		}
		File f = new File(filename);
		FileInputStream fis = new FileInputStream(f); //바이트스트림, 파일 열기, 이미지는 바이트스트림 그냥 사용하면 된다, 텍스트는 문자 스트림으로 변환해서 처리해야한다.
		response.setContentType(contentType);
		if(contentType.startsWith("image")) {
			byte[] content = new byte[(int)f.length()]; //파일의 내용 읽어서 저장
			ServletOutputStream sos = response.getOutputStream(); //이미지 리턴할 할 때는 getWriter()가 아니라 getOutputStream()써야함. 
			fis.read(content);
			sos.write(content);			
			sos.close();
		} else {
			InputStreamReader isr = new InputStreamReader(fis, "utf-8");
			BufferedReader br = new BufferedReader(isr);
			PrintWriter out = response.getWriter(); //텍스트 응답시에만 getWriter() 메소드 사용
			String line = null; 
			while((line = br.readLine()) != null) 
				out.println(line);
			out.close();
			br.close();
			isr.close();			
		}		
		fis.close();
	}
}
