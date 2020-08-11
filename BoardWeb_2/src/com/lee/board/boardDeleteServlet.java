package com.lee.board;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lee.board.common.Utils;
import com.lee.board.db.BoardDAO;
import com.lee.board.vo.BoardVO;

import sun.rmi.server.Dispatcher;

@WebServlet("/boardDel")
public class boardDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String strI_board = request.getParameter("i_board");
		int i_board = Utils.parseStringToInt(strI_board, 0);		
		
		BoardVO vo = new BoardVO();
		vo.setI_board(i_board);
		
		BoardDAO.delBoard(vo);
		
		response.sendRedirect("/boardList");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
