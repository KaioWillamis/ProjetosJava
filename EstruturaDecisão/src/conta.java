import java.util.Locale;
import java.util.Scanner;

public class conta {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);

        // Entrada do saldo inicial
        System.out.println("Informe o saldo inicial");
        double saldoInicial = scanner.nextDouble();
        // TODO: Na linha abaixo, implemente a entrada das três transações:
        double [] transacao = new double[3];
      
        // TODO: Na linha abaixo, realize o cálculo do saldo final:
        for(int i = 0; i < 3; i++){
            System.out.println("Informe uma número para saque ou deposito");
            transacao [i] = scanner.nextDouble();
        }

        double saldoFinal = calcular(saldoInicial, transacao);
        
        // Saldo final
        System.out.printf("%.2f\n", saldoFinal);

        scanner.close();
    }

    public static double calcular(double saldoInicial, double[] transacao){
        for(int i = 0; i < 3; i++){
            saldoInicial += transacao[i];
        }

        return saldoInicial;
    }
}
