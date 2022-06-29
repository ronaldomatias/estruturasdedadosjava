package com.java.estruturasdedados.exercicios.hashtable;

import java.util.ArrayList;
import java.util.Iterator;

import com.java.estruturasdedados.exercicios.modelos.Aluno;

public class TabelaHashEncadeada {


    private ArrayList<Aluno>[] tabela;

    // Cria uma nova tabela com a capacidade default 20.
    public TabelaHashEncadeada() {
        this.tabela = new ArrayList[20];
    }
    
    /**
     * Cria uma nova tabela com a capacidade passada como par�metro.
     * @param capacidade O n�mero de posi��es da tabela.
     */
    public TabelaHashEncadeada(int capacidade) {
        this.tabela = new ArrayList[capacidade];
    }
    
    /**
     * Calcula o hash de uma determinada chave. A fun��o de hash � simples
     * e usa o m�todo da divis�o.
     * @param chave A chave para a qual se deseja calcular o hash.
     * @return O hash calculado tendo como base a chave e o tamanho da tabela.
     */
    public int hash(Integer chave) {
        return chave % this.tabela.length;
    }
    
    /**
     * Calcula o hash utilizando o m�todo da multiplica��o.
     * @param chave A chave para a qual o hash deve ser calculado.
     * @return O hash calculado.
     */
    private int hashMultiplicacao(Integer chave) {
        double a = 0.617648934;
        double hash = chave*a;
        hash = (hash % 1) * this.tabela.length;
        return (int)hash;        
    }
    
    /**
     * Adiciona o par chave, valor na tabela.
     * @param chave a matr�cula do aluno a ser adicionado.
     * @param valor o objeto Aluno a ser adicionado na tabela.
     */
    public void put(Integer chave, Aluno valor) {
        int hash = hash(chave);
        ArrayList<Aluno> alunos = this.tabela[hash];
        
        if (alunos == null) {
            alunos = new ArrayList<Aluno>();
            alunos.add(valor);
            this.tabela[hash] = alunos;

        } else {
            for (int i = 0; i < alunos.size(); i++) {
                if (alunos.get(i).getMatricula() == chave) {
                    alunos.set(i, valor);
                    return;
                }
            }
            alunos.add(valor);
        }    
    }

    /**
     * Recupera o aluno cuja chave � igual a passada como par�metro.
     * @param chave a matr�cula do aluno.
     * @return o aluno com a matr�cula passada como par�metro. null caso
     * nenhum aluno presente na tabela tenha a matr�cula igual a passada como
     * par�metro.
     */
    public Aluno get(Integer chave) {
        int hash = hash(chave);
        ArrayList<Aluno> alunos = this.tabela[hash];
        
        if (alunos == null || alunos.isEmpty()) 
                return null;
        
        for (Aluno aluno : alunos) {
                if (aluno.getMatricula().equals(chave))
                    return aluno;
        }
        
        return null;
    }  

    /**
     * Remove o aluno cuja matr�cula � igual a chave passada como par�metro.
     * @param chave A matr�cula do aluno a ser removido.
     * @return O aluno a ser removido. null caso n�o haja aluno com a matr�cula
     * passada como par�metro. 
     */
    public Aluno remove(int chave) {
        int hash = hash(chave);
        ArrayList<Aluno> alunos = this.tabela[hash];
        
        Iterator<Aluno> it = alunos.iterator();
        Aluno atual = null;
        
        while (it.hasNext()) {
                atual = it.next();
                if (atual.getMatricula().equals(chave)) {
                    it.remove();
                    return atual;
                }
        }
        
        return atual;
    }  

}
