package com.example.board;

import com.example.board.bean.BoardVO;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class BoardRowMapper implements RowMapper<BoardVO> {
    @Override
    public BoardVO mapRow(ResultSet rs, int rowNum) throws SQLException {
        System.out.println("In BoardRowMapper class.");
        BoardVO vo = new BoardVO();
        vo.setSeq(rs.getInt("seq"));
        vo.setTitle(rs.getString("title"));
        vo.setWriter(rs.getString("writer"));
        vo.setContent(rs.getString("content"));
        vo.setRegdate(rs.getDate("regdate"));
        System.out.println(vo);
        return vo;
    }
}
