package com.generation.devfit.model;
 
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
 
@Entity
@Table(name = "tb_exercicio")
public class Exercicio {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	@Size(min = 5, max = 100, message = "O atributo título deve conter no mínimo 05 e no máximo 100 caracteres")
	private String nome_Exercicio;
	
	@NotBlank
	@Size(min = 5, max = 100, message = "O atributo título deve conter no mínimo 05 e no máximo 100 caracteres")
	private String grupo_Muscular;
	
	@NotBlank
	@Size(min = 5, max = 100, message = "O atributo título deve conter no mínimo 05 e no máximo 100 caracteres")
	private String nivel_Dificuldade;
	
	@NotBlank
	@Size(min = 5, max = 100, message = "O atributo título deve conter no mínimo 05 e no máximo 100 caracteres")
	private Integer tempo_Estimado;
	
	@NotBlank(message = "A descrição é obrigatoria")
	@Size(min = 5, max = 100, message = "O atributo título deve conter no mínimo 05 e no máximo 100 caracteres")
	private String descricao;
	
	
		
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome_Exercicio() {
		return nome_Exercicio;
	}
	public void setNome_Exercicio(String nome_Exercicio) {
		this.nome_Exercicio = nome_Exercicio;
	}
	public String getGrupo_Muscular() {
		return grupo_Muscular;
	}
	public void setGrupo_Muscular(String grupo_Muscular) {
		this.grupo_Muscular = grupo_Muscular;
	}
	public String getNivel_Dificuldade() {
		return nivel_Dificuldade;
	}
	public void setNivel_Dificuldade(String nivel_Dificuldade) {
		this.nivel_Dificuldade = nivel_Dificuldade;
	}
	public Integer getTempo_Estimado() {
		return tempo_Estimado;
	}
	public void setTempo_Estimado(Integer tempo_Estimado) {
		this.tempo_Estimado = tempo_Estimado;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	
 
}
 
 