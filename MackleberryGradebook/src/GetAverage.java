

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GetAverage
 */
@WebServlet("/GetAverage")
public class GetAverage extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private String message;  
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetAverage() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try{
			  message="";  
    	 String url = "jdbc:oracle:thin:testuser/password@localhost"; 
    	 Class.forName("oracle.jdbc.driver.OracleDriver");
	        //properties for creating connection to Oracle database
	        Properties props = new Properties();
	        props.setProperty("user", "testdb");
	        props.setProperty("password", "password");
	        Connection conn = DriverManager.getConnection(url,props);
	        //creating connection to Oracle database using JDBC              

           PreparedStatement ps=conn.prepareStatement("select avg(grade) as Avg from gradebook ");
          
           ResultSet rs=ps.executeQuery(); 
           

           /* Printing column names */

         
      
           while(rs.next())

              {
        	   	     System.out.println("Avg="+rs.getInt("Avg"));
        	   		message+="Average Grade = "+rs.getInt("Avg");

                
           }
           

          
           request.setAttribute("message", message);
           getServletContext().getRequestDispatcher("/output.jsp").forward(request, response);

    }catch (Exception e2)

      {

        System.out.println(e2.getMessage());

      }

	}

	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
