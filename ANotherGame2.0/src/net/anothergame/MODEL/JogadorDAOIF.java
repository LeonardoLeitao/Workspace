package net.anothergame.MODEL;

import java.util.List;

public interface JogadorDAOIF {
	public boolean 			create(Jogador jogador);
	public List<Jogador> 	retrieve();
	public boolean 			update(Jogador jogador);
	public boolean 			delete(Jogador jogador);
	public Jogador			findById(int id);
	public Jogador			findByName(String name);
	public List<Jogador>	encontreJogadoresNoIntervaloDeScore(int i, int f);
	public List<Jogador>	encontreJogadoresNoIntervaloDeScoreMax(int i, int f);
}
