package br.com.springdemo.testdb;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;

/**
 * Servlet implementation class TestDbServlet
 */
@WebServlet("/TestDatabaseServlet")
public class TestDatabaseServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String user = "root";
		String pass = "";
		String jdbcUrl = "jdbc:mysql://localhost:3306/spring_demo_tomus?useSSL=false";

		try {
			PrintWriter out = response.getWriter();
			out.println("Conectando ao banco de dados: " + jdbcUrl);
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = DriverManager.getConnection(jdbcUrl, user, pass);
			
			out.println("Conexão realizada com sucesso!");
			
			out.close();
			connection.close();
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServletException(e);
		}

	}

}
