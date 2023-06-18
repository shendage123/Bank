package Bank;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/Rust")
public class BankApplication extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id=req.getParameter("id");
		String age=req.getParameter("age");
		String Pin=req.getParameter("Pin");
		String name=req.getParameter("name");
		String Address=req.getParameter("Address");
		int id1 = Integer.parseInt(id);
		int age1 = Integer.parseInt(age);
		int pin1 = Integer.parseInt(Pin);
		Random r = new Random();
		long Account_No = r.nextLong(1000000000000000l);
		double Balanace = 5000;
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = Genral.getConnect();
			PreparedStatement ps=con.prepareStatement("insert into account(Id,Name,Age,Account_No,Pin,Balanace,Address)"
					+ " values(?,?,?,?,?,?,?)");
			ps.setInt(1,id1);
			ps.setString(2, name);
			ps.setInt(3, age1);
			ps.setLong(4, Account_No);
			ps.setInt(5,pin1);
			ps.setDouble(6, Balanace);
			ps.setString(7, Address);
			ps.execute();
		}
		catch(ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		PrintWriter pout = resp.getWriter();
		pout.print("<h1 align=\"center\" style=\"color: green\" >WelCome To ABC Bank</h1>");
		RequestDispatcher rd = req.getRequestDispatcher("Account.html");
		rd.include(req, resp);
	}

}
