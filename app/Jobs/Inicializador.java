package Jobs;


import enums.TipoUsuario;
import models.Aluno;
import models.Professor;
import models.Turma;
import models.Usuario;
import play.jobs.Job;
import play.jobs.OnApplicationStart;

@OnApplicationStart
public class Inicializador extends Job{
		
	public void doJob() throws Exception {
		
		if(Usuario.count() == 0) {
			
			Usuario usu1 = new Usuario();
			usu1.nome = "Administrador";
			usu1.matricula = "admin";
			usu1.senha = "admin";
			usu1.tipoUsuario = TipoUsuario.ADMIN;
			usu1.save();
			
			Usuario usu2 = new Usuario();
			usu2.nome = "Lucas";
			usu2.matricula = "4598";
			usu2.senha = "123";
			usu2.tipoUsuario = TipoUsuario.ALUNO;
			usu2.save();
			
			Aluno a1 = new Aluno();
			a1.nome = "João";
			a1.matricula = "1111";
			a1.senha = "123";
			a1.tipoUsuario = TipoUsuario.ALUNO;
			a1.save();
			
			Aluno a2 = new Aluno();
			a2.nome = "Felipe";
			a2.matricula = "2222";
			a2.senha = "123";
			a2.tipoUsuario = TipoUsuario.ALUNO;
			a2.save();
			
			Professor prof1 = new Professor();
			prof1.nome = "João Helis";
			prof1.matricula = "2019";
			prof1.senha = "123";
			prof1.tipoUsuario = TipoUsuario.PROF;
			prof1.save();
			
			Professor prof2 = new Professor();
			prof2.nome = "Danilo";
			prof2.matricula = "2018";
			prof2.senha = "123";
			prof2.tipoUsuario = TipoUsuario.PROF;
			prof2.save();
			
			Turma turma = new Turma();
			turma.nome = "4 inf 1v";
			turma.codigo = Turma.gerarCodigoTurma();
			turma.alunos.add(a1);
			turma.save();
		}		
	}
}
