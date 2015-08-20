

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Gradebook
 */
@WebServlet("/Gradebook")
public class Gradebook extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private String message;  
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Gradebook() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String url2="";
		
			// get parameters from the request
			String Assignment = request.getParameter("Assignment");
			String grade= request.getParameter("Grade");
			int gr=Integer.parseInt(grade);
			System.out.println(Assignment+"\n"+gr);
			// store data in User object and save User object in db
			 try{
				  message="";  
				  String url= "jdbc:oracle:thin:testuser/password@localhost"; 
				  Class.forName("oracle.jdbc.driver.OracleDriver");
		        //properties for creating connection to Oracle database
		        Properties props = new Properties();
		        props.setProperty("user", "testdb");
		        props.setProperty("password", "password");
		        Connection conn = DriverManager.getConnection(url,props);
		        //creating connection to Oracle database using JDBC              

	             PreparedStatement ps=conn.prepareStatement("insert into gradebook values(grade_id_seq.nextval,'"+Assignment+"',"+gr+")");
	            
	             ps.executeQuery();  
	             message+="The Information you enetered is as follows:<br>";
	             message+="Assignment:"+Assignment+"<br>Grade:"+grade;
			// set User object in request object and set URL
			request.setAttribute("message", message);
			url2="/output.jsp";
			getServletContext().getRequestDispatcher(url2).forward(request, response);
			}catch(Exception e){
				System.out.println(e.getMessage());

			}
		
	}

}
