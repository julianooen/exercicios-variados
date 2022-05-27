package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Pessoa;
import entities.PessoaFisica;
import entities.PessoaJuridica;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		List<Pessoa> listPessoas = new ArrayList<>();
		Scanner sc = new Scanner(System.in);

		System.out.print("Enter the number of tax payers: ");
		int numOfPayers = sc.nextInt();

		for (int i = 1; i <= numOfPayers; i++) {
			System.out.println("Tax payer #" + i + " data:");

			System.out.print("Individual or company (i/c)? ");
			String area = sc.next();

			System.out.print("Name: ");
			String nome = sc.next();

			System.out.print("Anual income: ");
			Double rendaAnual = sc.nextDouble();

			if (area.equals("i")) {

				System.out.print("Health expenditures: ");
				Double gastosSaude = sc.nextDouble();

				listPessoas.add(new PessoaFisica(nome, rendaAnual, gastosSaude));
			} else if (area.equals("c")) {

				System.out.print("Number of employees: ");
				Integer numFuncionarios = sc.nextInt();

				listPessoas.add(new PessoaJuridica(nome, rendaAnual, numFuncionarios));
			}
		}
		
		System.out.println("");
		System.out.println("TAXES PAID:");
		
		for(Pessoa elemento:listPessoas) {
			System.out.println(elemento.getNome()+": $ "+elemento.impostoRenda());
		}
	}

}
