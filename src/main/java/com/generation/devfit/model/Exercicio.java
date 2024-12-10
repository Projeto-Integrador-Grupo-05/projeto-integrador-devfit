package com.generation.devfit.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "tb_exercicio")
public class Exercicio {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank
	private String nome;

	@NotBlank
	private String grupoMuscular;

	@NotBlank
	private String nivelDificuldade;

	@NotNull
	private Double tempoEstimado;

	@NotBlank(message = "A descrição é obrigatoria")
	@Size(min = 5, max = 100, message = "A descrição deve conter no mínimo 05 e no máximo 100 caracteres")
	private String descricao;

	@ManyToOne
	@JsonIgnoreProperties("exercicios")
	private Treino treino;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getGrupoMuscular() {
		return grupoMuscular;
	}

	public void setGrupoMuscular(String grupo_Muscular) {
		this.grupoMuscular = grupo_Muscular;
	}

	public String getNivelDificuldade() {
		return nivelDificuldade;
	}

	public void setNivelDificuldade(String nivel_Dificuldade) {
		this.nivelDificuldade = nivel_Dificuldade;
	}

	public Double getTempoEstimado() {
		return tempoEstimado;
	}

	public void setTempoEstimado(Double tempo_Estimado) {
		this.tempoEstimado = tempo_Estimado;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Treino getTreino() {
		return treino;
	}

	public void setTreino(Treino treino) {
		this.treino = treino;
	}

}
