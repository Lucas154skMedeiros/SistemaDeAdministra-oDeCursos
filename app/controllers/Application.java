package controllers;

import play.*;
import play.mvc.*;

import java.util.*;

import models.*;

@With(Seguranca.class)
public class Application extends Controller {
    
	public static void index() {
        render();
    }
	
	public static void index2() {
		Long idAluno = Long.parseLong(session.get("Usuario.id"));
		Aluno aluno = Aluno.findById(idAluno);
		List<Turma> turmas = aluno.turmas;
		render(turmas);
    }
	
	public static void index3() {
        render();
    }
}