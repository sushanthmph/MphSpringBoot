package com.test.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class BookMapper implements RowMapper<Book>{
	@Override
	public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		Book p = new Book();
		p.setB_id(rs.getInt("b_id"));
		p.setB_name(rs.getString("b_name"));
		p.setB_author(rs.getString("B_author"));
		p.setB_price(rs.getInt("b_price"));
		return p;

}
}
