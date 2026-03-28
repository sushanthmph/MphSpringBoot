package com.test.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.test.model.Player;

public class PlayerDao {
	private JdbcTemplate jdbctemplate;


	public void setJdbctemplate(JdbcTemplate jdbctemplate) {
		this.jdbctemplate = jdbctemplate;
	}
	public int createPlayers(Player p)
	{
		String sql="Insert into player values("+p.getId()+",'"+p.getName()+"','"+p.getTeam()+"','"+p.getPrice()+"')";
		return jdbctemplate.update(sql);
	}
	public int updatePlayer(Player p)
	{
		String sql = "update players set p_name='"+p.getName()+"',p_team='"+p.getTeam()+"',p_price= '"+p.getPrice()+")";
		return jdbctemplate.update(sql);

	}
	public int deletePlayer(Player p)
	{
		String sql = "delete from player where id="+p.getId();
		return jdbctemplate.update(sql);

	}
	public List<Player> getAllPlayer(){
		return jdbctemplate.query("select * from player",
				new ResultSetExtractor<List<Player>>() {
				public List<Player> extractData(ResultSet rs) throws SQLException,DataAccessException{
			List<Player> list=new ArrayList<>();
			while(rs.next()) {
				Player pobj=new Player();
				pobj.setId(rs.getInt(1));
				pobj.setName(rs.getString(2));
				pobj.setTeam(rs.getString(3));
				pobj.setPrice(rs.getInt(4));
				list.add(pobj);
			}
			return list;
		}
				
});
	}
}

