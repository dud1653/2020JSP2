package com.lee.board;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lee.board.db.BoardDAO;
import com.lee.board.db.DbCon;
import com.lee.board.vo.BoardVO;
// Servelt은 로직 담당, JSP는 view 담당
@WebServlet("/boardList")
public class BoardListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<BoardVO> list = BoardDAO.selBoardList();
		request.setAttribute("data", list); // (String, Object)
    	
    	RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/boardList.jsp");
    	// forward 방식
    	// url 정보가 없다, request객체와 response객체를 공유
    	// 이동할 url로 요청 정보를 그대로 전달
    	
    	// redirect 방식
    	// url이 바뀐다, request객체와 response 객체가 새롭게 생성
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
