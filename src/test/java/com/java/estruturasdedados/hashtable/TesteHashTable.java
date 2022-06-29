package com.java.estruturasdedados.hashtable;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.java.estruturasdedados.exercicios.hashtable.TabelaHash;
import com.java.estruturasdedados.exercicios.modelos.Aluno;

public class TesteHashTable {

	TabelaHash tabelaHash;
	Aluno aluno1;
	Aluno aluno2;

	@Before
	public void configuracoes() {
		// CONFIGURANDO MATRICULAS PARA RETORNAR UM VALOR DE HASH IGUAL COM O OBJETIVO
		aluno1 = new Aluno(44, "Ronaldo");
		aluno2 = new Aluno(24, "Matias");
		tabelaHash = new TabelaHash();
	}

	// TESTANDO SE O HASH REALMENTE É IGUAL
	@Test
	public void chavesIguais() {
		assertEquals(4, tabelaHash.hash(aluno1.getMatricula()));
		assertEquals(4, tabelaHash.hash(aluno2.getMatricula()));
	}
	
	// TESTANDO SOBREPOSICÃO DENTRO DA TABELA HASH
	@Test
	public void put() {
		
		tabelaHash.put(aluno1.getMatricula(), aluno1);
		assertEquals(44, tabelaHash.get(4).getMatricula());
		
		tabelaHash.put(aluno2.getMatricula(), aluno2);
		assertEquals(24, tabelaHash.get(4).getMatricula());
	}
}
