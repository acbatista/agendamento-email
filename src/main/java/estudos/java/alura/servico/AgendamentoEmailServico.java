package estudos.java.alura.servico;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import estudos.java.alura.dao.AgendamentoEmailDao;
import estudos.java.alura.entidade.AgendamentoEmail;

@Stateless
public class AgendamentoEmailServico {

	@Inject
	private AgendamentoEmailDao dao;
	
	public List<AgendamentoEmail> listar(){
		return dao.listar();
	}

}
