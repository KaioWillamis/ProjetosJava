package dio.dio_spring_security_jwt.dtos;

public class Sessao {
    private String login;
    private String token;

    public String getLogin(){
        return login;
    }

    public void setLogin(String login){
        this.login = login;
    }

    public String getToken(){
        return token;
    }

    public void setToken(String Token){
        this.token = token;
    }
}
