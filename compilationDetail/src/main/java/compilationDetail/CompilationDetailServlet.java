package compilationDetail;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/details")
public class CompilationDetailServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter writer = resp.getWriter();
		writer.print("<center><h3><b> Project Compilation Details : <b></h3>");
		writer.print("<br><br>");
		ProjectCompilationDetails projectCompilationDetails = new ProjectCompilationDetails();
		Map<String, String> details = projectCompilationDetails.getDetails(getServletContext());
		for (Entry<String, String> detail : details.entrySet()) {
			writer.print("<h4><b> " + detail.getKey() + "<b>   &nbsp;&nbsp&nbsp;&nbsp; : &nbsp;&nbsp;&nbsp;&nbsp; "
					+ detail.getValue() + " </h4><br>");
		}
		writer.print("<br>");
		writer.print("<h5>*************************************</h5></center>");

	}

}
