package com.generation.devfit.model;

import java.time.LocalDateTime;

import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
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

	@NotBlank
	private int frequencia_semanal;

	@NotBlank
	private String descricao;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getnomeTreino() {
		return nomeTreino;
	}

	public void setnomeTreino(String nomeTreino) {
		this.nomeTreino = nomeTreino;
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

	// @ManyToOne
	// @JsonIgnoreProperties("treino")
	// private Exercicio exercicio;
}