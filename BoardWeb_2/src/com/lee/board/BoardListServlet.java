package com.lee.board;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
// Servelt은 로직 담당, JSP는 view 담당
@WebServlet("/")
public class BoardListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BoardListServlet() {
        super();
    }
    
    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String strI_board = request.getParameter("i_board");
		System.out.println("Servlet i_board : " + strI_board);
    	
    	RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/boardList.jsp");
		rd.forward(request, response);
	}
	
    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
