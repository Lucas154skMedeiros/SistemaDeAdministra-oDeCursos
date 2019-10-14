package models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import enums.TipoUsuario;
import play.db.jpa.Model;
import play.libs.Crypto;

@Entity
public class Professor extends Usuario {
	

	
	@ManyToMany(mappedBy="professores")
	public List<Turma> turmas;
	
	@OneToMany(mappedBy="professor")
	public List <Frequencia> frequencias;
}
	

