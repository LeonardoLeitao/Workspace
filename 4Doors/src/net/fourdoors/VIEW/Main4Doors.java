package net.fourdoors.VIEW;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.SlickException;

public class Main4Doors {

	public static void main(String[] args) {
		try {
			AppGameContainer agc = new AppGameContainer(new TelaPrincipal4Doors("4Doors"));
			agc.setDisplayMode(800, 600, false);
			agc.setVSync(true);
			agc.setTargetFrameRate(59);
			agc.start();
		} catch(SlickException e) {
			e.printStackTrace();
		}
	}
}
