
package controllers;

import play.mvc.Before;
import play.mvc.Controller;

public class Seguranca extends Controller {
	
	@Before(unless="Login.form")
	static void interceptar() {
		if(session.get("Usuario.matricula") == null) {
			Login.form();								
		}
	}
}