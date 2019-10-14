package controllers;

import java.util.List;

import enums.TipoUsuario;
import models.Professor;
import play.mvc.Controller;
import play.mvc.With;

@With(Seguranca.class)
public class Professores extends Controller{
	
	public static void form() {
		render();
	}
	
	public static void salvar(Professor professor, String senha) {
		
		if (senha.equals("") == false) {
			professor.senha = senha;
		}
		professor.tipoUsuario = TipoUsuario.PROF;
		professor.save();
		flash.success("Professor Cadastrado com Sucesso!");
		listar();
	}
	
	public static void listar() {
		String buscar = params.get("buscar");
		List<Professor> professores;
		if (buscar == null) {
			professores = Professor.findAll();
		} else {
			professores = Professor.find("nome like ?1 or matricula like ?1 order by nome", "%"+buscar+"%").fetch();
		}
		
		
		render(professores);
	}
	
	public static void editar(Long id) {
		Professor professor = Professor.findById(id);
		render("Professores/form.html", professor);
	}
		
	
	public static void deletar(Long id) {
		
		Professor professor = Professor.findById(id);
		professor.delete();
		flash.success("Professor removido com Sucesso!");
		listar();		
	}
}