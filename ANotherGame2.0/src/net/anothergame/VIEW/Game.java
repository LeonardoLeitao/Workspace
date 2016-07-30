package net.anothergame.VIEW;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.Random;

import org.newdawn.slick.Animation;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.Music;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Sound;
import org.newdawn.slick.SpriteSheet;
import org.newdawn.slick.geom.Vector2f;

import net.anothergame.MODEL.ComportamentoUpSpeed;
import net.anothergame.MODEL.Jogador;
import net.anothergame.MODEL.Upgrade;

public class Game extends BasicGame {
	private enum Cardinal {
		NORTH,
		SOUTH,
		WEST,
		EAST
	}
	private Cardinal currentCardinal = Cardinal.NORTH;
	private String currentCardinalString = "North";
	private boolean isTouchN, isTouchS, isTouchW, isTouchE;
	private boolean alive = true;
	private int anterior;
	private int lives = 3;
	private int proxVida;
	private int score;
	private Random rand;
	private Vector2f vector;
	private Image image;
	private Sound sound;
	private int DELAY = 1500000000;
	private int tempoDecorrido;
	private final int screenMinimum = 0;
	private final int screenMaximum = 507;
	private SpriteSheet spriteSheet;
	private Jogador jogador;
	private boolean printUpgrade = false;
	private boolean andandoParaLado = false;
	private int x, y;
	private Animation animacao;
	
	public Game(String title) {
		super(title);
	}

	@Override
	public void render(GameContainer gc, Graphics g) throws SlickException {
		g.setAntiAlias(true);
		this.image.draw();
		
		//g.setColor(new Color(255,192,203));
		if(this.alive) {
			if(this.printUpgrade) {
				
				Upgrade upgrade = new Upgrade(new Image("res/upSpeed.png")
						,y,x, new ComportamentoUpSpeed());
				upgrade.getImage().getScaledCopy(100, 100).draw(upgrade.getPosicao().getX(), upgrade.getPosicao().getY());
			}
			if(this.currentCardinalString.equals("North")) {
				g.setColor(Color.green);
				g.fillRect(0, 0, 512, 10);
			} else if(this.currentCardinalString.equals("South")) {
				g.setColor(Color.pink);
				g.fillRect(0, 500, 515, 20);
			} else if(this.currentCardinalString.equals("West")) {
				g.setColor(Color.red);
				g.fillRect(0, 0, 20, 512);
			} else if(this.currentCardinalString.equals("East")) {
				g.setColor(Color.blue);
				g.fillRect(500, 0, 20, 512);
			}
			g.setColor(Color.red);
			BigDecimal tempo = new BigDecimal((this.DELAY-this.tempoDecorrido)*0.001);
			g.drawString("Goto: "+this.currentCardinalString, 256, 256);
			g.drawString("TimeLeft: "+tempo.round(MathContext.DECIMAL32)+"s\nPoints: "+this.score+" Lives: " +this.lives, 100, 300);
			if(this.andandoParaLado) {
				this.animacao.draw(this.vector.getX(), this.vector.getY());
			} else {
				Image image1 = this.spriteSheet.getSubImage(1, 0);
				image1.draw(this.vector.getX(), this.vector.getY());
			}
		} else {
			//g.setColor(Color.white);
			g.drawString("You Lose | Total Points: "+ this.score, 256, 256);
		}
	}

	@Override
	public void init(GameContainer gc) throws SlickException {
		this.rand = new Random();
		this.vector = new Vector2f(256,256);
		this.image = new Image("res/cp.png");
		this.spriteSheet = new 	SpriteSheet("res/spritesheet.png",64,64);
		this.image = this.image.getScaledCopy(512, 512);
		Music musica = new Music("res/dp.ogg");
		musica.loop();
		this.sound = new Sound("res/sound/click.wav");
		this.proxVida = this.score+10;
		this.jogador = new Jogador(0,"Leonardo");
		this.animacao = new Animation();
		this.animacao.addFrame(this.spriteSheet.getSubImage(0, 3), 300);
		this.animacao.addFrame(this.spriteSheet.getSubImage(1, 3), 300);
	}

	@Override
	public void update(GameContainer gc, int delta) throws SlickException {
		Cardinal currentLocation = null;
		if(this.isTouchN) {
			currentLocation = Cardinal.NORTH;
		} else if(this.isTouchS) {
			currentLocation = Cardinal.SOUTH;
		} else if(this.isTouchE) {
			currentLocation = Cardinal.EAST;
		} else if(this.isTouchW) {
			currentLocation = Cardinal.WEST;
		}
		
		if(this.tempoDecorrido >= this.DELAY 
				|| this.currentCardinal == currentLocation) {
			
			if(currentLocation == this.currentCardinal 
					&& this.alive) {
				this.score++;
				if(score == this.proxVida) {
					this.lives++;
					this.proxVida+=10;
					this.DELAY-=10;
					Random random = new Random();
					this.printUpgrade = random.nextBoolean();
					x = random.nextInt(400);
					y = random.nextInt(400);
				}
				this.sound.play();
			} else {
				this.lives--;
				if(this.score > 0 && this.alive) {
					this.score--;
				}
			}
			
			if(this.lives < 0) {
				this.alive = false;
			}
			int switcher = this.rand.nextInt(4);
			while(switcher == anterior) {
				switcher = this.rand.nextInt(4);
			}
			switch(switcher) {
			case(0):
				this.currentCardinal = Cardinal.NORTH;
				this.currentCardinalString = "North";
				this.anterior = 0;
			break;
			case(1):
				this.currentCardinal = Cardinal.SOUTH;
				this.currentCardinalString = "South";
				this.anterior = 1;
			break;
			case(2):
				this.currentCardinal = Cardinal.WEST;
				this.currentCardinalString = "West";
				this.anterior = 2;
			break;
			case(3):
				this.currentCardinal = Cardinal.EAST;
				this.currentCardinalString = "East";
				this.anterior = 3;
			break;
			}
		
			this.tempoDecorrido = 0;
		} else {
			this.tempoDecorrido += delta;
		}
		
		Input input = gc.getInput();
		this.isTouchN = this.isTouchS = this.isTouchW = this.isTouchE = false;
		
		if(this.vector.getY() >= 508) {
			this.vector.set(this.vector.getX(), 507);
		}else if(this.vector.getY() <= -1) {
			this.vector.set(this.vector.getX(), 0);
		} else if (this.vector.getX() <= -1) {
			this.vector.set(0, this.vector.getY());
		} else if(this.vector.getX() >= 508) {
			this.vector.set(507, this.vector.getY());
		}
		
		if(this.vector.getX() > this.screenMinimum) {
			if(input.isKeyDown(Input.KEY_LEFT)) {
				this.vector.x-=1 * delta;
			}
		} else {
			this.isTouchW = true;
		} 
		
		if(this.vector.getX() < this.screenMaximum) {
			if(input.isKeyDown(Input.KEY_RIGHT)) {
				this.vector.x+=1;
				this.andandoParaLado = true;
			} else {
				this.andandoParaLado = false;
			}
		} else {
			this.isTouchE = true;
		}
		
		if(this.vector.getY() > this.screenMinimum) {
			if(input.isKeyDown(Input.KEY_UP)) {
				this.vector.y-=1 * delta;
			}
		} else {
			this.isTouchN = true;
		}
		
		if(this.vector.getY() < this.screenMaximum) {
			if(input.isKeyDown(Input.KEY_DOWN)) {
				this.vector.y+=1 * delta;
			}
		} else {
			this.isTouchS = true;
		}	
	}
}
