package facade;

import Sistema1.CrmService;
import Sistema2.CepApi;

public class Facade {
    public void migrarCLiente(String nome, String cep){
        String cidade = CepApi.getInstacia().recuperarCidade(cep);
        String estado = CepApi.getInstacia().recuperarEstado(cep);

        CrmService.gravarCliente(nome,cep,cidade,estado);
    }
}
