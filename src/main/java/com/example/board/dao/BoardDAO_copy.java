package com.example.board.dao;

import com.example.board.bean.BoardVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class BoardDAO_copy {

//	Connection conn = null;
//	PreparedStatement stmt = null;
//	ResultSet rs = null;

	private final String BOARD_INSERT = "insert into BOARD (title, writer, content) values (?,?,?)";
	private final String BOARD_UPDATE = "update BOARD set title=?, writer=?, content=? where seq=?";
	private final String BOARD_DELETE = "delete from BOARD  where seq=?";
	private final String BOARD_GET = "select * from BOARD  where seq=?";
	private final String BOARD_LIST = "select * from BOARD order by seq";

	@Autowired
	JdbcTemplate jdbcTemplate ;

	public void setJdbcTemplate(JdbcTemplate template) {
		this.jdbcTemplate = template;
	}

	public int insertBoard(BoardVO vo) {
		String sql = "insert into BOARD (title, writer, content) values ("
				+ "'" + vo.getTitle() + "',"
				+ "'" + vo.getWriter() + "',"
				+ "'" + vo.getContent() + "')";
		return jdbcTemplate.update(sql);
	}

	public int deleteBoard(int seq) {
		String sql = "delete from BOARD where seq=" + seq;
		return jdbcTemplate.update(sql);
	}

	public int updateBoard(BoardVO vo) {
		String sql = "update BOARD set "
				+ "title='"  + vo.getTitle() + "',"
				+ "writer='"  + vo.getWriter() + "',"
				+ "content='"  +  vo.getContent() + "' where seq=" + vo.getSeq();
		return jdbcTemplate.update(sql);
	}

	public BoardVO getBoard(int seq) {
		return jdbcTemplate.queryForObject(BOARD_GET,
				new Object[] {seq},
				new BeanPropertyRowMapper<BoardVO>(BoardVO.class));
//		String sql = "select * from BOARD where seq=" + seq;
//		return jdbcTemplate.queryForObject(sql, new BoardRowMapper());
	}

	public List<BoardVO> getBoardList() {
		System.out.println("In getBoardList()");
		return jdbcTemplate.query(BOARD_LIST, new RowMapper<BoardVO>() {
			@Override
			public BoardVO mapRow(ResultSet rs, int rowNum) throws SQLException {
				BoardVO data = new BoardVO();
				data.setSeq(rs.getInt("seq"));
				data.setTitle(rs.getString("title"));
				data.setWriter(rs.getString("writer"));
				data.setContent(rs.getString("content"));
				data.setRegdate(rs.getDate("regdate"));
				System.out.print(data);
				return data;
			}
		});

//		String sql = "select * from BOARD order by seq desc";
//		return jdbcTemplate.query(sql, new BoardRowMapper());
	}
}
