package com.test.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class PlayersMapper implements RowMapper<Player>{


	@Override
	public Player mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		Player p = new Player();
		p.setId(rs.getInt("id"));
		p.setName(rs.getString("p_name"));
		p.setTeam(rs.getString("p_team"));
		p.setPrice(rs.getInt("p_price"));
		return p;
	}
}
