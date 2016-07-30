package net.anothergame.MODEL;

import org.newdawn.slick.Image;
import org.newdawn.slick.geom.Vector2f;

public class Upgrade {
	private Image image;
	private Vector2f posicao;
	private ComportamentoUpgrade comportamentoUpgrade;
	
	public Upgrade(Image image, int x, int y, ComportamentoUpgrade upgrade) {
		this.image = image;
		this.posicao = new Vector2f(x,y);
		this.comportamentoUpgrade = upgrade;
	}

	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
	}

	public Vector2f getPosicao() {
		return posicao;
	}

	public void setPosicao(Vector2f posicao) {
		this.posicao = posicao;
	}

	public ComportamentoUpgrade getComportamentoUpgrade() {
		return comportamentoUpgrade;
	}

	public void setComportamentoUpgrade(ComportamentoUpgrade comportamentoUpgrade) {
		this.comportamentoUpgrade = comportamentoUpgrade;
	}
	

}
