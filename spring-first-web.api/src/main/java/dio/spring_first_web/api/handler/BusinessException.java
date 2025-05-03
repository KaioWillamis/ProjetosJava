package dio.spring_first_web.api.handler;

public class BusinessException {
    public BusinessException(String mensagem){
        super(mensagem);
    }

    public public BusinessException(String mensagem, Object ... params){
        super(String.format(mensagem,params));
    }
}
