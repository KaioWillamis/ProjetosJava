public abstract class Conta implements IConta{
    protected  static final int AGENCIA_PADRAO = 1;
    public static int SEQUENCIAL = 1;
    protected  int agencia;
    protected  int numero;
    protected  double saldo;
    protected Cliente cliente;

    public Conta(Cliente cliente){
        this.agencia = AGENCIA_PADRAO;
        this.numero = SEQUENCIAL++;
        this.cliente = cliente;
    }

    @Override
    public void sacar(double valor){
        if(valor > this.saldo){
            System.out.println("Você não pode sacar esse valor");
        }
        else{
            this.saldo -= valor;
        }
    }

    @Override
    public void depositar(double valor){
        this.saldo += valor;
    }

    @Override
    public void transferir(double valor, Conta contaDestiino){
        this.sacar(valor);
        contaDestiino.depositar(valor);
    }

    public int getAgencia(){
        return agencia;
    }

    public int getNumero(){
        return agencia;
    }

    public double getSaldo(){
        return saldo;
    }

    protected void imprimirInformacaoes(){
        System.out.println(String.format("Titular: %s", this.cliente.getNome()));
        System.out.println(String.format("Agencia: %d", this.agencia));
        System.out.println(String.format("Numero: %d", this.numero));
        System.out.println(String.format("Saldo: %2f", this.saldo));
    }
}
