package models;

import javax.persistence.Entity;

import enums.TipoUsuario;
import play.db.jpa.Model;
import play.libs.Crypto;


@Entity
public class Usuario extends Model {
	
	public String nome;
	public String senha;
	public String matricula;
	
	//public void setSenha (String senha) {
		//senha = Crypto.passwordHash(senha);
	//}
	
	public TipoUsuario tipoUsuario;
	
	public Usuario() {
		tipoUsuario = TipoUsuario.ADMIN;
	}
}
