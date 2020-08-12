package com.lee.board;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lee.board.common.Utils;
import com.lee.board.db.BoardDAO;
import com.lee.board.vo.BoardVO;

@WebServlet("/boardMod")
public class boardModServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String strI_board = request.getParameter("i_board");
		int i_board = Utils.parseStringToInt(strI_board, 0);
		
		if(i_board == 0) {
			response.sendRedirect("/boardList");
			return;
		}
		
		BoardVO param = new BoardVO();
		param.setI_board(i_board);
		
		request.setAttribute("data", BoardDAO.selBoard(param));
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/boardRegmod.jsp");
		rd.forward(request, response);	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String strI_board = request.getParameter("i_board");
		String title = request.getParameter("title");
		String ctnt = request.getParameter("ctnt");
		String strI_student = request.getParameter("i_student");
		
		int i_board = Integer.parseInt(strI_board);
		int i_student = Integer.parseInt(strI_student);
		
		BoardVO vo = new BoardVO();
		vo.setI_board(i_board);
		vo.setTitle(title);
		vo.setCtnt(ctnt);
		vo.setI_student(i_student);
		
		BoardDAO.updBoard(vo);
		
		response.sendRedirect("/boardDetail?i_board="+i_board);
	}

}
