package aplication;

import dados.Item;
import exceptions.DomainException;
import exceptions.ValidationUtils;
import java.util.Scanner;
import sistema.ControleArquivos;
import sistema.HeapSort;
import sistema.SelecaoDireta;
import sistema.InsercaoDireta;

public class Program {

	static Scanner sc = new Scanner(System.in);
	private static int num = 0;

	public static void main(String[] args) {
		int op;
		ControleArquivos controleArq = new ControleArquivos();

		do {
			menu();
			op = lerInt("Escolha uma opção: ");
			sc.nextLine();

			switch (op) {
				case 1:
					gerarGravar(controleArq);
					break;

				case 2:
					lerEimprimir(controleArq);
					break;

				case 3:
					ordenarArquivo(controleArq);
					break;

				case 4:
					break;

				default:
					System.out.println("Opção inválida! Tente novamente.");
					break;
			}

		} while (op != 4);

		System.out.println("Programa encerrado.");
	}

	public static void gerarGravar(ControleArquivos controleArq) {
		num = lerInt("Digite quantos números deseja gerar aleatoriamente:");
		sc.nextLine();

		String nome = lerString("Digite o nome do arquivo que deseja salvar: ");
		controleArq.criar(nome);
		controleArq.escreverArquivo(nome, num);
	}

	public static void lerEimprimir(ControleArquivos controleArq) {
		String nome = lerString("Digite o nome do arquivo que deseja ler: ");
		Item[] vetor = controleArq.lerArquivo(nome, num);
		num = vetor.length;

		try {
			ValidationUtils.validarArquivo(nome);
		} catch (DomainException e) {
			System.out.println("Erro: " + e.getMessage());
		}

		for (Item n : vetor) {
			System.out.print(n.getChave() + "  ");
		}
		System.out.println();
	}

	public static void ordenarArquivo(ControleArquivos controleArq) {
		menuOrdenacao();

		String nome = lerString("Digite o nome do arquivo que deseja ordenar: ");
		int alg = lerInt("Opção: ");
		sc.nextLine();

		switch (alg) {
			case 1:
				AlgoritimoSelecao(controleArq, nome);
				break;

			case 2:
				AlgoritHeapSort(controleArq, nome);
				break;

			case 3:
				AlgoritimoInsercaoDireta(controleArq, nome);
				break;

			case 4:
				System.out.println("ShellSort ainda não implementado.");
				break;

			case 5:
				System.out.println("BubbleSort ainda não implementado.");
				break;

			case 6:
				System.out.println("ShakeSort ainda não implementado.");
				break;

			case 7:
				System.out.println("QuickSort ainda não implementado.");
				break;

			default:
				System.out.println("Opção inválida!");
		}
	}

	public static void menuOrdenacao() {
		System.out.println("\n========== Escolha o algoritmo de ordenação =========="
				+ "\n1. Seleção Direta"
				+ "\n2. HeapSort"
				+ "\n3. Inserção Direta"
				+ "\n4. ShellSort"
				+ "\n5. BubbleSort"
				+ "\n6. ShakeSort"
				+ "\n7. QuickSort");
		System.out.println("======================================================");
	}

	public static void menu() {
		System.out.println("\n========== MENU PRINCIPAL =========="
				+ "\n1. Gerar e Gravar Arquivo com Números Aleatórios"
				+ "\n2. Ler e Exibir Conteúdo de um Arquivo"
				+ "\n3. Ordenar Arquivo"
				+ "\n4. Sair");
		System.out.println("==================================");
	}

	public static String lerString(String mensagem) {
		System.out.println(mensagem);
		return sc.next();
	}

	public static int lerInt(String mensagem) {
		System.out.println(mensagem);
		return sc.nextInt();
	}

	public static void AlgoritHeapSort(ControleArquivos controleArq, String nome) {
		Item[] numeros = controleArq.lerArquivo(nome, num);
		HeapSort hp = new HeapSort(numeros.length, numeros);

		long inicio = System.nanoTime();
		hp.heapSort(numeros);
		long fim = System.nanoTime();

		System.out.println("\nVetor ordenado: ");
		for (Item n : numeros) {
			System.out.println(n.getChave());
		}

		double duracao = (fim - inicio) / 1_000_000.0;
		System.out.println("Tempo de execução do HeapSort: " + duracao + " ms");
	}

	public static void AlgoritimoSelecao(ControleArquivos controleArq, String nome) {
		SelecaoDireta sd = new SelecaoDireta();
		Item[] numeros = controleArq.lerArquivo(nome, num);

		long inicio = System.nanoTime();
		sd.selecaoDireta(numeros);
		long fim = System.nanoTime();

		System.out.println("Vetor ordenado:");
		for (Item numero : numeros) {
			System.out.println(numero.getChave());
		}

		double duracao = (fim - inicio) / 1_000_000.0;
		System.out.println("Tempo de execução da Seleção Direta: " + duracao + " ms");
	}

	public static void AlgoritimoInsercaoDireta(ControleArquivos controleArq, String nome) {
		InsercaoDireta id = new InsercaoDireta();
		Item[] nums = controleArq.lerArquivo(nome, num);

		long start = System.nanoTime();
		id.insercaoDireta(nums);
		long end = System.nanoTime();

		System.out.println("Vetor ordenado (Inserção Direta):");
		for (Item n : nums) {
			System.out.println(n.getChave());
		}

		double duration = (end - start) / 1_000_000.0;
		System.out.println("Tempo de execução da Inserção Direta: " + duration + " ms");
	}
}
