package models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import play.db.jpa.Model;


@Entity
public class Frequencia extends Model {
	
	
	public String turma;
	public int presenca;
	public Date data;
	
	@ManyToOne
	@JoinColumn(name = "aluno_id")
	public Aluno aluno;
	
	@ManyToOne
	@JoinColumn(name = "professor_id")
	public Professor professor;
	
	
	
	
	
	
}
