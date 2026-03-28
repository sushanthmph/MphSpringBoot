package com.test.DAO;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import com.test.model.Player;

public class PlayerDao1 {
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
	}
	public void createPlayer(Player p)
	{
		String sql ="insert into player (id,p_name,p_team,p_price) values(:p_id, :p_name, :p_team, :p_price)";
		MapSqlParameterSource mapsql = new MapSqlParameterSource();
		mapsql.addValue("p_id",p.getId());
		mapsql.addValue("p_name",p.getName());
		mapsql.addValue("p_team",p.getTeam());
		mapsql.addValue("p_price",p.getPrice());
		
		namedParameterJdbcTemplate.update(sql,mapsql);
	
	}
	

}
