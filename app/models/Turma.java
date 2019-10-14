package models;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import play.db.jpa.Model;

@Entity
public class Turma extends Model {
	
	public String nome;
	public String codigo;
	
	public Turma() {
		this.alunos = new ArrayList<Aluno>();
		this.professores = new ArrayList<Professor>();
	}
	
	public static String gerarCodigoTurma() {
		String codigoString = null;
		boolean continuar = true;
		while(continuar) {
			UUID codigo = UUID.randomUUID();
			codigoString = codigo.toString().split("-")[0];
			Turma turma = Turma.find("codigo = ?", codigoString).first();
			if(turma == null) {
				continuar = false;
			}
		}
		return codigoString;
	}
	
	@ManyToMany
	@JoinTable(name="alunos_turmas")
	public List<Aluno> alunos;
	
	@ManyToMany
	@JoinTable(name="professores_turmas")
	public List<Professor> professores;
	
	
}
