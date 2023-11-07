package co.yedam.board.serviceImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.yedam.board.service.BoardVO;
import co.yedam.board.service.MemberVO;
import co.yedam.common.DataSource;

public class BoardDAO {
	// 목록, 단건조회, 등록, 수정, 삭제

	DataSource dao = DataSource.getInstance();
	Connection conn;
	PreparedStatement psmt;
	ResultSet rs;
	String sql;

	public void close() {
		try {
			if (rs != null)
				rs.close();
			if (conn != null)
				conn.close();
			if (psmt != null)
				psmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<BoardVO> selectList() {
		sql = "SELECT * FROM BOARD ORDER BY BOARD_NO";
		conn = dao.getConnection();
		List<BoardVO> list = new ArrayList<BoardVO>();
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while (rs.next()) {
				BoardVO vo = new BoardVO();
				vo.setBoardNo(rs.getInt("board_no"));
				vo.setContent(rs.getString("content"));
				vo.setWriter(rs.getString("writer"));
				vo.setImage(rs.getString("image"));
				vo.setLastUpdate(rs.getDate("last_update"));
				vo.setWriteDate(rs.getDate("write_date"));
				vo.setTitle(rs.getString("title"));
				vo.setViewCnt(rs.getInt("view_cnt"));
				list.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return list;
	}
	
	public BoardVO select(int boardNo) {
		sql = "SELECT * FROM BOARD WHERE BOARD_NO = ?";
		conn = dao.getConnection();
		BoardVO vo = new BoardVO();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1,boardNo);
			rs = psmt.executeQuery();
			if(rs.next()) {
				vo.setBoardNo(rs.getInt("board_no"));
				vo.setContent(rs.getString("content"));
				vo.setWriter(rs.getString("writer"));
				vo.setImage(rs.getString("image"));
				vo.setLastUpdate(rs.getDate("last_update"));
				vo.setWriteDate(rs.getDate("write_date"));
				vo.setTitle(rs.getString("title"));
				vo.setViewCnt(rs.getInt("view_cnt"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return vo;
	}
	
	public int insert(BoardVO vo) {
		int n = 0;
		sql = "INSERT INTO BOARD(BOARD_NO, TITLE, CONTENT, WRITER, IMAGE) VALUES(SEQ_BOARD.NEXTVAL,?,?,?,?)";
		conn = dao.getConnection();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getTitle());
			psmt.setString(2, vo.getContent());
			psmt.setString(3, vo.getWriter());
			psmt.setString(4, vo.getImage());
			n = psmt.executeUpdate();
			return n;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return 0;
	}
	
	public int update(BoardVO vo) {
		int n = 0;
		sql = "UPDATE BOARD SET TITLE = ?, CONTENT = ?, WRITER = ?, IMAGE=?, LAST_UPDATE = SYSDATE WHERE BOARD_NO = ?";
		conn = dao.getConnection();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getTitle());
			psmt.setString(2, vo.getContent());
			psmt.setString(3, vo.getWriter());
			psmt.setString(4, vo.getImage());
			psmt.setInt(5, vo.getBoardNo());
			n = psmt.executeUpdate();
			return n;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return 0;
	}
	
	public int delete(int boardNo) {
		int n = 0;
		sql = "DELETE FROM BOARD WHERE BOARD_NO = ?";
		conn = dao.getConnection();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1,boardNo);
			n = psmt.executeUpdate();
			return n;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return 0;
	}
	
	public int updateCnt(int boardNo) {
		int n = 0;
		sql = "UPDATE BOARD SET VIEW_CNT=VIEW_CNT+1 WHERE BOARD_NO = ?";
		conn = dao.getConnection();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1,boardNo);
			n = psmt.executeUpdate();
			return n;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return 0;
	}
	
	public MemberVO getUser(String id, String pw) {
		sql = "SELECT * FROM MEMBER WHERE MID=? and PASS=?";
		conn = dao.getConnection();
		MemberVO vo = new MemberVO();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			psmt.setString(2, pw);
			rs = psmt.executeQuery();
			if(rs.next()) {
				vo.setMid(rs.getString("mid"));
				vo.setPass(rs.getString("pass"));
				vo.setResponsibility(rs.getString("responsibility"));
				return vo;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return null;
	}
	
	
	public List<MemberVO> member() {
		sql = "SELECT * FROM MEMBER ORDER BY 1";
		conn = dao.getConnection();
		List<MemberVO> list = new ArrayList<MemberVO>();
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while (rs.next()) {
				MemberVO vo = new MemberVO();
				vo.setMid(rs.getString("mid"));
				vo.setPass(rs.getString("pass"));
				vo.setName(rs.getString("name"));
				vo.setPhone(rs.getString("phone"));
				vo.setResponsibility(rs.getString("responsibility"));
				list.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return list;
	}

}
