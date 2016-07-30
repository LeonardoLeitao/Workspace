package net.fourdoors.VIEW;

import java.util.Random;

import org.newdawn.slick.BasicGame;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Vector2f;

import net.fourdoors.MODEL.ComportamentoUpgradeUpSpeed;
import net.fourdoors.MODEL.Jogador;
import net.fourdoors.MODEL.Upgrade;

public class TelaPrincipal4Doors extends BasicGame {
	private Jogador jogador;
	private Vector2f posicao;
	private Random random;
	private int tempoDecorrido = 0;
	private final int DELAY = 5000;
	Upgrade upgrade;
	private int x = 0,y = 0;
	
	public TelaPrincipal4Doors(String title) {
		super(title);
	}

	@Override
	public void init(GameContainer gc) throws SlickException {
		this.jogador = new Jogador("Leonardo", new Image("data/personagem.png"));
		this.posicao = new Vector2f(0,0);
		this.random = new Random();
		this.upgrade = new Upgrade("UpSpeed", new Image("data/upspeed.png"), new ComportamentoUpgradeUpSpeed());
	}
	
	@Override
	public void render(GameContainer gc, Graphics g) throws SlickException {
		g.setColor(Color.red);
		if(this.upgrade.isColidiu()) {
			this.upgrade.getImagemDoUpgrade().getScaledCopy(5, 5).draw(0, 0);
		}
		this.jogador.getImagemDoPersonagem().getScaledCopy(100, 100).draw(x,y);
		
		g.drawString("X,Y: "+this.posicao.x+","+this.posicao.y, 300, 380);
		g.drawString("VELOCIADE: "+this.jogador.getVelocidade(), 300, 400);
		g.drawString("TEMPO UPGRADE: "+(this.DELAY-this.tempoDecorrido)*0.001, 300, 420);
	}

	@Override
	public void update(GameContainer gc, int delta) throws SlickException {
		Input input = gc.getInput();
		
		if((this.jogador.getPosicaoDoPersonagem().getX() >= this.upgrade.getPosicao().getX() &&
				this.jogador.getPosicaoDoPersonagem().getX() <= this.upgrade.getPosicao().getX()+50) ||
 				(this.jogador.getPosicaoDoPersonagem().getY() >= this.upgrade.getPosicao().getY() &&
 				this.jogador.getPosicaoDoPersonagem().getY() <= this.upgrade.getPosicao().getY()+50)) {
			this.upgrade.setColidiu(true);
			this.jogador.setUpgrades(this.upgrade);
			this.jogador.getUpgrades().getComportamentoUpgrade().upgrade(this.jogador);
		}
		
		if(this.jogador.getUpgrades() != null) {
			if(this.tempoDecorrido >= DELAY) {
				this.tempoDecorrido = 0;
				this.jogador.setVelocidade(1);
				this.jogador.setUpgrades(null);
				this.upgrade.setColidiu(false);
			} else {
				this.tempoDecorrido += delta;
			}
		}
		movimentar(input);
		
	}
	
	public void movimentar(Input input) {
		if(input.isKeyDown(Input.KEY_UP)) {
			this.posicao.y-=1;
			this.jogador.setPosicaoDoPersonagem(this.posicao);
		}
		
		if(input.isKeyDown(Input.KEY_DOWN)) {
			this.posicao.y+=1;
			this.jogador.setPosicaoDoPersonagem(this.posicao);
		}
		
		if(input.isKeyDown(Input.KEY_RIGHT)) {
			this.posicao.x+=1;
			this.jogador.setPosicaoDoPersonagem(this.posicao);
		}
		
		if(input.isKeyDown(Input.KEY_LEFT)) {
			this.posicao.x-=1;
			this.jogador.setPosicaoDoPersonagem(this.posicao);
		}
	}

}
