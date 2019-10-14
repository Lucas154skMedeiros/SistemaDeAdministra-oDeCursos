package models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import enums.TipoUsuario;
import play.db.jpa.Model;
import play.libs.Crypto;

@Entity
public class Aluno extends Usuario{
	
	
	@OneToMany(mappedBy="aluno")
	public List <Frequencia> frequencias;
	
	@ManyToMany(mappedBy="alunos")
	public List<Turma>turmas;
		
	}
