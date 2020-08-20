package estudos.java.alura.servico;

import java.util.List;

import javax.ejb.Stateless;

@Stateless
public class AgendamentoEmailServico {
	
	public List<String> listar(){
		return List.of("ac_contatos@icloud.com");
	}

}
