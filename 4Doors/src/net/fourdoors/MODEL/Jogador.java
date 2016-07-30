package net.fourdoors.MODEL;

import org.newdawn.slick.Image;
import org.newdawn.slick.geom.Vector2f;

public class Jogador {
	private String nome;
	private int pontuacao;
	private int pontuacaoRecorde;
	private Image imagemDoPersonagem;
	private Vector2f posicaoDoPersonagem;
	private boolean colidiu;
	private int velocidade = 1;
	private Upgrade upgrades;
	
	public Jogador(String nome, Image imagem) {
		this.nome = nome;
		this.imagemDoPersonagem = imagem;
		this.pontuacao = 0;
		this.pontuacaoRecorde = 0;
		this.posicaoDoPersonagem = new Vector2f(0,0);
		this.colidiu = false;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getPontuacao() {
		return pontuacao;
	}

	public void setPontuacao(int pontuacao) {
		this.pontuacao = pontuacao;
	}

	public int getPontuacaoRecorde() {
		return pontuacaoRecorde;
	}

	public void setPontuacaoRecorde(int pontuacaoRecorde) {
		this.pontuacaoRecorde = pontuacaoRecorde;
	}

	public Image getImagemDoPersonagem() {
		return imagemDoPersonagem;
	}

	public void setImagemDoPersonagem(Image imagemDoPersonagem) {
		this.imagemDoPersonagem = imagemDoPersonagem;
	}

	public Vector2f getPosicaoDoPersonagem() {
		return posicaoDoPersonagem;
	}

	public void setPosicaoDoPersonagem(Vector2f posicaoDoPersonagem) {
		this.posicaoDoPersonagem = posicaoDoPersonagem;
	}

	public boolean isColidiu() {
		return colidiu;
	}

	public void setColidiu(boolean colidiu) {
		this.colidiu = colidiu;
	}

	public int getVelocidade() {
		return velocidade;
	}

	public void setVelocidade(int velocidade) {
		this.velocidade = velocidade;
	}

	public Upgrade getUpgrades() {
		return upgrades;
	}

	public void setUpgrades(Upgrade upgrades) {
		this.upgrades = upgrades;
	}
}