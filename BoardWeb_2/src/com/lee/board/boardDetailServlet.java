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


@WebServlet("/boardDetail")
public class boardDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	//get방식은 화면 띄우기 용
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
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/boardDetail.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
