package Bank;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/validation")
public class Custemer_Admin  extends HttpServlet{
	@Override   
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String Account_No=req.getParameter("Account_No");
		String Pin=req.getParameter("Pin");
		
		
		Long Account_No1 = Long.parseLong(Account_No);
		int Pin1=Integer.parseInt(Pin);
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = Genral.getConnect();
			PreparedStatement ps=con.prepareStatement("select * from account where Account_No= ? and Pin= ?");
			ps.setLong(1, Account_No1);
			ps.setInt(2, Pin1);
			ResultSet rs = ps.executeQuery();
			if(rs.next())
			{
				PrintWriter pout= resp.getWriter();
				pout.println("<h1 align=\"center\"style=\"color: green\">Login Succefully!!!!</h1>");
				RequestDispatcher rd=req.getRequestDispatcher("Costemer.html");
				rd.include(req, resp);
				
			}
			else
			{
				PrintWriter pout =resp.getWriter();
				pout.println("<h1 align=\"center\"style=\"color: red\">Invalid Credentials !!!!</h1>");;
				RequestDispatcher rd=req.getRequestDispatcher("login.html");
				rd.include(req, resp);
				
			}
			
			
		}
		catch(ClassNotFoundException e)
		
		{
			e.printStackTrace();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
	}
	

}

