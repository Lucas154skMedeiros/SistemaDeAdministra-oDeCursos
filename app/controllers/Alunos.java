package controllers;

import java.util.List;

import enums.TipoUsuario;
import models.Aluno;
import models.Turma;
import play.mvc.Controller;
import play.mvc.With;

@With(Seguranca.class)
public class Alunos extends Controller {

	public static void form() {
		render();
	}

	public static void salvar(Aluno aluno, String senha) {

		if (senha.equals("") == false) {
			aluno.senha = senha;
		}
		aluno.tipoUsuario = TipoUsuario.ALUNO;
		aluno.save();
		flash.success("Aluno Cadastrado com Sucesso!");
		listar();

	}

	public static void listar() {
		String buscar = params.get("buscar");
		List<Aluno> alunos;
		if (buscar == null) {
			alunos = Aluno.findAll();
		} else {
			alunos = Aluno.find("nome like ?1 or matricula like ?1 order by nome", "%" + buscar + "%").fetch();
		}

		render(alunos);
	}

	public static void editar(Long id) {
		Aluno aluno = Aluno.findById(id);
		render("Alunos/form.html", aluno);
	}

	public static void deletar(Long id) {

		Aluno aluno = Aluno.findById(id);
		aluno.delete();
		flash.success("Aluno removido com Sucesso!");
		listar();
	}
	
	public static void entrarTurmaForm() {
		render("Alunos/entrarTurma.html");
	}

	public static void entrarTurma(String matricula, String codigoTurma) {
		Aluno aluno = Aluno.find("matricula = ?", matricula).first();
		Turma turma = Turma.find("codigo = ?", codigoTurma).first();
		if (turma != null) {
			turma.alunos.add(aluno);
			turma.save();
			renderText("O aluno foi adicionado na turma " + turma.nome);
		} else {
			flash.error("Nenhuma turma foi encontrada com o código informado!");
			entrarTurmaForm();
		}
	}
}
