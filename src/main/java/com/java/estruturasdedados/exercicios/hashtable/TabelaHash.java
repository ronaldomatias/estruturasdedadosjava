package com.java.estruturasdedados.exercicios.hashtable;

import com.java.estruturasdedados.exercicios.modelos.Aluno;

public class TabelaHash {

	private Aluno[] tabela;

	public TabelaHash() {
		this.tabela = new Aluno[20];
	}

	public int hash(int chave) {
		return chave % this.tabela.length;
	}

	public Aluno get(int chave) {
		int hash = hash(chave);
		return this.tabela[hash];
	}

	public void put(int chave, Aluno valor) {
		int hash = hash(chave);
		this.tabela[hash] = valor;
	}

	public Aluno remove(int chave) {
		int hash = hash(chave);
		Aluno aluno = this.tabela[hash];
		this.tabela[hash(chave)] = null;
		return aluno;
	}

}
