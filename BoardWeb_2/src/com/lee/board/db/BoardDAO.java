package com.lee.board.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.lee.board.vo.BoardVO;

public class BoardDAO {
	public static List<BoardVO> selBoardList() {
		List<BoardVO> list = new ArrayList();
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = " SELECT i_board, title, ctnt, i_student FROM t_board ORDER BY i_board ";
		
		try {
			con = DbCon.getCon();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				BoardVO vo = new BoardVO();
				int i_board = rs.getInt("i_board");
				String title = rs.getNString("title");
				String ctnt = rs.getNString("ctnt");
				int i_student = rs.getInt("i_student");
				
				vo.setI_board(i_board);
				vo.setTitle(title);
				vo.setCtnt(ctnt);
				vo.setI_student(i_student);
				
				list.add(vo);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DbCon.close(con, ps, rs);
		}
		return list;
	}
}
