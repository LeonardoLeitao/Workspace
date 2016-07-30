package net.anothergame;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.SlickException;

import net.anothergame.VIEW.Game;

public class GameMain {
	public static void main(String[] args) {
		try{
			AppGameContainer agc = new AppGameContainer(new Game("ANotherGame"));
			agc.setDisplayMode(512, 512, false);
			agc.setTargetFrameRate(59);
			agc.setIcon("res/starIcon.png");
			agc.start();
		} catch(SlickException e) {
			e.printStackTrace();
		}
	}
}
