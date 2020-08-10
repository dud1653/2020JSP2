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

@WebServlet("/boardWrite")
public class boardRegmodServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/boardRegmod.jsp");
		rd.forward(request, response);	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String title = request.getParameter("title");
		String ctnt = request.getParameter("ctnt");
		String strI_student  = request.getParameter("i_student");
		
		// 하나하나 로그 뽑아보기
		
		BoardVO vo = new BoardVO();
		vo.setTitle(title);
		vo.setCtnt(ctnt);
		vo.setI_student(Utils.parseStringToInt(strI_student, 0));
		
		BoardDAO.insBoard(vo);
		response.sendRedirect("/boardList");
	}

}
