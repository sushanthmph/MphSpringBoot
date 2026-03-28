package com.test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.test.DAO.PlayerDao2;
import com.test.config.DbConfig;
import com.test.model.Player;

public class TestDemo1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext ctx =new AnnotationConfigApplicationContext(DbConfig.class);
		PlayerDao2 dao= ctx.getBean(PlayerDao2.class);
		Player obj =new Player();
		obj.setId(444);
		obj.setName("Axar");
		obj.setTeam("Delhi");
		obj.setPrice(123);
		dao.createPlayers(obj);
		System.out.println("Done");
		List<Player> list =dao.listAllPlayers();
		list.forEach(System.out::println);

	}

}
