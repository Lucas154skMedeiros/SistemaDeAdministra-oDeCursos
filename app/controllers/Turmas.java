package controllers;

import java.util.List;

import models.Aluno;
import models.Professor;
import models.Turma;
import play.mvc.Controller;
import play.mvc.With;

@With(Seguranca.class)
public class Turmas extends Controller{
	
	public static void form() {
		render();
	}
	
	public static void salvar(Turma turma) {
		if(turma.id == null) {
			turma.codigo = Turma.gerarCodigoTurma();
		}
		turma.save();
		flash.success("Turma Cadastrada com Sucesso!");
		listar();
	}
	
	public static void listar() {
		String buscar = params.get("buscar");
		List<Turma> turmas;
		if (buscar == null) {
			turmas = Turma.findAll();
		} else {
			turmas = Turma.find("nome like ?1 order by nome", "%"+buscar+"%").fetch();
		}
		
		
		render(turmas);
	}
	
	public static void adicionarAluno(Long alunoID, Long turmaID) {
		Aluno aluno = Aluno.findById(alunoID);
		Turma turma = Turma.findById(turmaID);
		turma.alunos.add(aluno);
		turma.save();
		flash.success("Aluno adicionado com sucesso!");
		detalhes(turma.id);
	}
	
	public static void adicionarProfessor(Long professorID, Long turmaID) {
		Professor professor = Professor.findById(professorID);
		Turma turma = Turma.findById(turmaID);
		turma.professores.add(professor);
		turma.save();
		flash.success("Professor adicionado com sucesso!");
		detalhes(turma.id);
	}
	
	public static void detalhes(Long id) {
		Turma turma = Turma.findById(id);
		List<Aluno> alunos = Aluno.findAll();
		List<Professor> professores = Professor.findAll();
		render(turma, alunos, professores);
	}
	
	public static void editar(Long id) {
		Turma turma = Turma.findById(id);
		render("Turmas/form.html", turma);
	}
	public static void deletar(Long id) {
		
		Turma turma = Turma.findById(id);
		turma.delete();
		flash.success("Turma removida com Sucesso!");
		listar();		
	}
}	