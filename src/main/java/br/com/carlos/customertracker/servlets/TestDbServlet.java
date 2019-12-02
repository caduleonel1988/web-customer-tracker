package br.com.carlos.customertracker.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// Servlet para testar a conexão com o banco de dados

@WebServlet(urlPatterns = "/TestDbServlet")
public class TestDbServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// configura as variaveis de conexão

		String user = "springstudent";
		String pass = "springstudent";

		String jdbcUrl = "jdbc:mysql://localhost:3306/web_customer_tracker?useSSl=false";
		String driver = "com.mysql.jdbc.Driver";

		try {
			// tenta receber a conexão com o banco
			PrintWriter out = resp.getWriter();
			out.println("Connecting to database: " + jdbcUrl);

			// tenta recuperar a classe do Driver para fazer a conexão com o banco
			Class.forName(driver);
			
			Connection connection = DriverManager.getConnection(jdbcUrl,user, pass);
			
			out.println("Connection Sucessfull");
			
			// fecha a conexão
			connection.close();
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServletException(e);
		}
	}

}
