package com.java.estruturasdedados.hashtable;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.java.estruturasdedados.exercicios.hashtable.TabelaHash;
import com.java.estruturasdedados.exercicios.hashtable.TabelaHashEncadeada;
import com.java.estruturasdedados.exercicios.modelos.Aluno;

public class TesteHashTable {

	TabelaHash tabelaHash;
	TabelaHashEncadeada tabelaHashEncadeada;
	Aluno aluno1;
	Aluno aluno2;

	@Before
	public void configuracoes() {
		// CONFIGURANDO MATRICULAS PARA RETORNAR VALORES DE HASH IGUAL PARA CADA MATRICULA
		aluno1 = new Aluno(44, "Ronaldo");
		aluno2 = new Aluno(24, "Matias");
		tabelaHash = new TabelaHash();
		tabelaHashEncadeada = new TabelaHashEncadeada();
	}

	// TESTANDO SE O HASH GERADO REALMENTE É IGUAL
	@Test
	public void chavesIguais() {
		assertEquals(4, tabelaHash.hash(aluno1.getMatricula()));
		assertEquals(4, tabelaHash.hash(aluno2.getMatricula()));
	}
	
	// NESTE CASO, HÁ SOBREPOSIÇÃO NA POSIÇÃO DE HASH 4, POIS PARA CADA POSIÇÃO HASH, EXISTE SOMENTE UM ALUNO
	@Test
	public void put() {
		
		tabelaHash.put(aluno1.getMatricula(), aluno1);
		assertEquals(Integer.valueOf(44), tabelaHash.get(4).getMatricula());
		
		tabelaHash.put(aluno2.getMatricula(), aluno2);
		assertEquals(Integer.valueOf(24), tabelaHash.get(4).getMatricula());
	}
	
}
