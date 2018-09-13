package com.sisescola.models;
import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Professor implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Long id;
	
	@Column(length=50)
	private String nome;
	
	@Column(length=15)
	private String celular;
	
	@Column(length=100)
	private String blog;
	
	@Column(length=100)
	private String email;
	
	@ManyToMany(cascade= CascadeType.MERGE)
	private Set<Disciplina> disciplinas;
	
	@OneToMany(mappedBy="professor")
	private Set<Reserva> reservas;
	
	@OneToMany(mappedBy="professor")
	private Set<Horario> horarios;
	
	
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
	public String getCelular() {
		return celular;
	}
	public void setCelular(String celular) {
		this.celular = celular;
	}
	public String getBlog() {
		return blog;
	}
	public void setBlog(String blog) {
		this.blog = blog;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
			
	public Set<Disciplina> getDisciplinas() {
		return disciplinas;
	}
	public void setDisciplinas(Set<Disciplina> disciplinas) {
		this.disciplinas = disciplinas;
	}	
	
	public Set<Reserva> getReservas() {
		return reservas;
	}
	public void setReservas(Set<Reserva> reservas) {
		this.reservas = reservas;
	}
	
		
	public Set<Horario> getHorarios() {
		return horarios;
	}
	public void setHorarios(Set<Horario> horarios) {
		this.horarios = horarios;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Professor other = (Professor) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	

}
