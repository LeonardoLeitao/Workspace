package net.anothergame.MODEL;

import java.util.Arrays;
import java.util.List;

import net.anothergame.CONTROLLER.Conexao;

public class JogadorDAOImpl implements JogadorDAOIF {
	private Conexao conexao;
	
	@Override
	public boolean create(Jogador jogador) {
		return false;
	}

	@Override
	public List<Jogador> retrieve() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean update(Jogador jogador) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Jogador jogador) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Jogador findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Jogador findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Jogador> encontreJogadoresNoIntervaloDeScore(int i, int f) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Jogador> encontreJogadoresNoIntervaloDeScoreMax(int i, int f) {
		// TODO Auto-generated method stub
		return null;
	}

}