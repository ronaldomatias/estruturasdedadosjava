package com.java.estruturasdedados.exercicios.modelos;

public class Aluno {

	private Integer matricula;
	private String nome;

	public Aluno(Integer matricula, String nome) {
		this.matricula = matricula;
		this.nome = nome;
	}

	
	@Override
    public int hashCode() {
        return this.matricula;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Aluno))
            return false;
        
        Aluno test = (Aluno) obj;
        return test.getMatricula().equals(this.matricula);
    }
	
	public Integer getMatricula() {
		return matricula;
	}

	public void setMatricula(Integer matricula) {
		this.matricula = matricula;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}
