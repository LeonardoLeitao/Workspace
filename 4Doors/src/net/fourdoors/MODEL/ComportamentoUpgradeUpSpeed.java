package net.fourdoors.MODEL;

public class ComportamentoUpgradeUpSpeed implements ComportamentoUpgrade {

	@Override
	public void upgrade(Jogador jogador) {
		jogador.setVelocidade(1); 
	}
	
}