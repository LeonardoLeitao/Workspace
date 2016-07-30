package net.anothergame.MODEL;

import org.newdawn.slick.Graphics;

public class Jogador {
	private final int id;
	private String nome;
	private int score;
	private int socreMax;
	private Upgrade[] upgrades;
	
	public Jogador(int id, String nome) {
		this.id = id;
		this.nome = nome;
		this.score = 0;
		this.socreMax = 0;
		
	}
	
	public int getID() {
		return this.id;
	}
	
	public String getNome() {
		return this.nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public int getScore() {
		return this.score;
	}
	
	public void setScore(int score) {
		this.score = score;
		if(this.score > this.socreMax) {
			this.setScoreMax(score);
		}
	}
	
	public int getScoreMax() {
		return this.socreMax;
	}
	
	private void setScoreMax(int score) {
		this.socreMax = score;
	}
	
	public void draw(int x, int y, Graphics g) {
		g.fillRect(x, y, 5, 5);
	}
}
