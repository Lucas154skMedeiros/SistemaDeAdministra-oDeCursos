package controllers;


import enums.TipoUsuario;
import models.Aluno;
import models.Professor;
import models.Usuario;
import play.libs.Crypto;
import play.mvc.Controller;

public class Login extends Controller {
	
	public static void form() {
		render();
	}
	
	public static void logar(String matricula, String senha) {
		System.out.println("Entrei");
		Usuario usu = Usuario.find("matricula = ?1 and senha =?2" , matricula, senha).first();
		System.out.println(usu);
		if (usu == null) {
			flash.error("Dados incorretos!");
			form();
		} else {
			session.put("Usuario.id", usu.id);
			session.put("Usuario.matricula", usu.matricula);
			session.put("Usuario.nome", usu.nome);
			
			if(usu.tipoUsuario.equals(TipoUsuario.ADMIN)) {
				Application.index();
			}else if(usu.tipoUsuario.equals(TipoUsuario.PROF)) {
				Application.index3();
			}else {
				Application.index2();
			}
		}
	}	

	public static void sair() {
		session.clear();
		Login.form();
		
		
		
		
	}
	
}
