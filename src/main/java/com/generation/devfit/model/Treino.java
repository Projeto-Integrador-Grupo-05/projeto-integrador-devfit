package com.generation.devfit.model;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "tb_treino")

public class Treino {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank
	private String nomeTreino;
	
	private int frequencia_semanal;

	@NotBlank
	private String descricao;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "treino", cascade = CascadeType.REMOVE)
	@JsonIgnoreProperties("treino")
	private List<Usuario> usuarios;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "treino", cascade = CascadeType.REMOVE)
	@JsonIgnoreProperties("treino")
	private List<Exercicio> exercicios;
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getFrequencia_semanal() {
		return frequencia_semanal;
	}

	public void setFrequencia_semanal(int frequencia_semanal) {
		this.frequencia_semanal = frequencia_semanal;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getNomeTreino() {
		return nomeTreino;
	}

	public void setNomeTreino(String nomeTreino) {
		this.nomeTreino = nomeTreino;
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public List<Exercicio> getExercicios() {
		return exercicios;
	}

	public void setExercicios(List<Exercicio> exercicios) {
		this.exercicios = exercicios;
	}
	
}
