package com.java.estruturasdedados.hashtable;

import com.java.estruturasdedados.exercicios.hashtable.TabelaHashEncadeada;
import com.java.estruturasdedados.exercicios.modelos.Aluno;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class TesteHashTableEncadeada {

	TabelaHashEncadeada tabelaHashEncadeada;
	Aluno aluno1;
	Aluno aluno2;

	@Before
	public void configuracoes() {

		// CONFIGURANDO DIFERENTES MATRICULAS - QUE RETORNAM VALORES DE HASH IGUAIS
		aluno1 = new Aluno(44, "Ronaldo");
		aluno2 = new Aluno(24, "Matias");
		tabelaHashEncadeada = new TabelaHashEncadeada();
	}

	// TESTANDO SE O HASH GERADO REALMENTE É IGUAL
	@Test
	public void chavesIguais() {

		assertEquals(4, tabelaHashEncadeada.hash(aluno1.getMatricula()));
		assertEquals(4, tabelaHashEncadeada.hash(aluno2.getMatricula()));
	}

	// NESTE CASO, NÃO HÁ SOBREPOSIÇÃO NA POSIÇÃO DE HASH 4, POIS PARA CADA POSIÇÃO
	// HASH, HÁ UMA LISTA DE ALUNOS ASSOCIADA
	@Test
	public void putTabelaHashEncadeada() {

		tabelaHashEncadeada.put(aluno1.getMatricula(), aluno1);
		tabelaHashEncadeada.put(aluno2.getMatricula(), aluno2);

		assertEquals("Ronaldo", tabelaHashEncadeada.get(44).getNome());
		assertEquals("Matias", tabelaHashEncadeada.get(24).getNome());
	}

}
