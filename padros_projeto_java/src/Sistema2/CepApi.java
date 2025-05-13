package Sistema2;

public class CepApi {
    private static CepApi instacia = new CepApi();

    private CepApi(){
        super();
    }

    public static CepApi getInstacia(){
        return instacia;
    }

    public void recuperarCidade(String cep){
         return "araraquara";
    }

    public String recuperarEstado(String cep){
        return "sp";
    }
}
