import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class Currency
 */
@WebServlet(name="convert",urlPatterns={"/convert"})
public class Currency extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter pw=response.getWriter();
		response.setContentType("text/html");
		String con_from = request.getParameter("convertfrom");
		String con_to = request.getParameter("convertto");
		int amount = Integer.parseInt(request.getParameter("amount"));
		con_from = con_from.toUpperCase();
		con_to = con_to.toUpperCase();
		double converted = 0;
		if((con_from.equals("USD") || con_from.equals("DOLLAR")) && (con_to.equals("RUPEE") || con_to.equals("RS") || con_to.equals("INR"))){
			converted = amount * 75;
		}else if((con_from.equals("RUPEE") || con_from.equals("RS") || con_from.equals("INR")) && (con_to.equals("USD") || con_to.equals("DOLLAR"))){
			converted = amount / 75;
		}else if((con_from.equals("USD") || con_from.equals("DOLLAR")) && (con_to.equals("POUND"))){
			converted = amount * 0.72;
		}else if((con_from.equals("POUND")) && (con_to.equals("DOLLAR") || con_to.equals("USD"))){
			converted = amount * 1.35;
		}
		else if((con_from.equals("RUPEE") || con_from.equals("INR") || con_from.equals("RS")) && (con_to.equals("POUND"))){
			converted = amount / 101;
		}else if((con_from.equals("POUND")) && (con_to.equals("RUPEE") || con_to.equals("INR") || con_to.equals("RS"))){
			converted = amount * 101;
		}else {
			pw.println("<body style=\"background-color:powderblue;font-size:250%;text-align:center;\"><p><strong>ONLY THE FOLLOWING CONVERSIONS AVAILABLE:</strong></p>");
			pw.println("<p>RUPEE  --->  DOLLAR</p>");
			pw.println("<p>RUPEE  --->  POUND</p>");
			pw.println("<p>DOLLAR --->  RUPEE</p>");
			pw.println("<p>DOLLAR --->  POUND</p>");
			pw.println("<p>POUND  --->  DOLLAR</p>");
			pw.println("<p>POUND  --->  RUPEE</p></body>");
		}
		pw.println("<body style=\"background-color:powderblue;font-size:300%;text-align:center;\">Converted:</body>" +" "+ converted);
		pw.close();
	}
}
