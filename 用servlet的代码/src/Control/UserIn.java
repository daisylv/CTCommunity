package Control;

import java.io.Console;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;

/**
 * Servlet implementation class UserIn
 */
@WebServlet(
		urlPatterns = { "/UserIn" }, 
		initParams = { 
				@WebInitParam(name = "sinaId", value = ""), 
				@WebInitParam(name = "username", value = "")
		})
public class UserIn extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public UserIn() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name = request.getParameter("username");
		byte[]b;
		try{
			b = name.getBytes("iso8859-1");
			String userId = new String(b,"UTF-8");
			int userid = Integer.parseInt(userId);
			String sinaId = request.getParameter("password");
			int sinaid = Integer.parseInt(sinaId);
			UserDao userdao = new UserDao(userid,sinaid);
			userdao.getCon();
			System.out.println("Success");
		}catch(UnsupportedEncodingException e){
			e.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
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
