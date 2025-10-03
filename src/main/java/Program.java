import entities.TaxPayer;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.print("Quantos contribuintes você vai digitar? ");
        int n = sc.nextInt();

        List<TaxPayer> taxpayers = new ArrayList<>();

        System.out.println();
        for (int i = 0; i < n; i++) {
            System.out.printf("Digite os dados do %do contribuinte:\n", i+1);
            System.out.print("Renda anual com salário: ");
            double salaryIncome = sc.nextDouble();
            System.out.print("Renda anual com prestação de serviço: ");
            double servicesIncome = sc.nextDouble();
            System.out.print("Renda anual com ganho de capital: ");
            double capitalIncome = sc.nextDouble();
            System.out.print("Gastos médicos: ");
            double healthSpending = sc.nextDouble();
            System.out.print("Gastos educacionais: ");
            double educationSpending = sc.nextDouble();
            System.out.println();

            taxpayers.add(new TaxPayer(salaryIncome, servicesIncome, capitalIncome, healthSpending, educationSpending));
        }

        for (TaxPayer taxPayer: taxpayers) {
            System.out.printf("Resumo do %do contribuinte: \n", taxpayers.indexOf(taxPayer)+1);
            System.out.printf("Imposto bruto total: %.2f%n", taxPayer.grossTax());
            System.out.printf("Abatimento: %.2f%n", taxPayer.taxRebate());
            System.out.printf("Imposto devido: %.2f%n", taxPayer.netTax());
            System.out.println();
        }

        sc.close();
    }
}
