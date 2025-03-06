package set.OperacacoesBasicas;

import java.util.Objects;

public class Convidado {
    private String nome;
    private int codigoConvite;

    public Convidado(String nome, int condigoConvite){
        this.nome = nome;
        this.codigoConvite = condigoConvite;
    }

    public String getNome(){
        return nome;
    }

    public boolean equals(Object o){
        if(this == o) return true;
        if(!(o instanceof Convidado convidado)) return false;
        return getCodigoConvite() == convidado.getCodigoConvite();
    }

    public int HashCode(){
        return Objects.hash(getCodigoConvite());
    }

    public int getCodigoConvite(){
        return codigoConvite;
    }

    public String toString(){
        return "Convidado{" +
           "nome='" + nome + '\'' +
           ", codigoConvite=" + codigoConvite +
           '}';
    }
}
