package aplication;

import dados.Item;
import exceptions.DomainException;
import exceptions.ValidationUtils;
import java.util.Scanner;
import sistema.Bubblesort;
import sistema.ControleArquivos;
import sistema.HeapSort;
import sistema.InsercaoDireta;
import sistema.SelecaoDireta;
import sistema.Shellsort;


public class Program {

	static Scanner sc = new Scanner(System.in);
	static String[][] dados;

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
		int num;

		num = lerInt("Digite quantos números deseja gerar aleatoriamente:");
		sc.nextLine();

		String nome = lerString("Digite o nome do arquivo que deseja salvar: ");
		controleArq.criar(nome);


		System.out.println("\033[38;2;255;181;192m----------------------------- Tipos de Arquivo ----------------------------");
		System.out.println("Digite qual arquivo você quer criar: \n" +
							"1. Arquivo com números aleatórios desordenados\n" +
							"2. Arquivo com números ordenados crescente\n" +
							"3. Arquivo com números ordenados decrescente\033[0m");

		int opcao = lerInt("Opção: ");
	
		switch (opcao) {
			case 1:
				controleArq.escreverArquivo(nome, controleArq.gerarNumerosAleatorios(nome, num));
				break;
			case 2:
				controleArq.escreverArquivo(nome, controleArq.gerarNumerosCrescentes(nome, num));
				break;
			case 3:
				controleArq.escreverArquivo(nome, controleArq.gerarNumerosDecrescentes(nome, num));
				break;
			default:
				System.out.println("Invadido");
		}
	}

	public static void lerEimprimir(ControleArquivos controleArq) {
		String nome = lerString("Digite o nome do arquivo que deseja ler: ");
		Item[] vetor;

		try {
			ValidationUtils.validarArquivo(nome);
		} catch (DomainException e) {
			System.out.println("Erro: " + e.getMessage());
			return;
		}

		vetor = controleArq.lerArquivo(nome);

		for (Item n : vetor) {
			System.out.print(n.getChave() + "  ");
		}
		System.out.println();
	}

	public static void ordenarArquivo(ControleArquivos controleArq) {
		menuOrdenacao();
		int alg = lerInt("Opção: ");
		String nome = lerString("Digite o nome do arquivo que deseja ordenar: ");

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
				AlgoritimoShellsort(controleArq, nome);
				break;

			case 5:
				AlgoritimoBubblesort(controleArq, nome);
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
		String amarelo = "\u001B[33m";
		String reset = "\u001B[0m";
		System.out.println("\n" + amarelo + "========== Escolha o algoritmo de Ordenação =========="
				+ "\n1. Seleção Direta"
				+ "\n2. HeapSort"
				+ "\n3. Inserção Direta"
				+ "\n4. ShellSort"
				+ "\n5. BubbleSort"
				+ "\n6. ShakeSort"
				+ "\n7. QuickSort");
		System.out.println("======================================================" + reset);
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

	public static void algoritimoSelecao(ControleArquivos controleArq, String nome) {
		try { // metodo para verificar se o nome do arquivo está correto
			ValidationUtils.validarArquivo(nome);
		} catch (DomainException e) {
			System.out.println("Erro: " + e.getMessage());
			return;// se o nome estiver errado o algoritmo não continua, pq irá dar erro por n ter
					// encontrado o arquivo
		}
		SelecaoDireta sd = new SelecaoDireta();
		Item[] numeros = controleArq.lerArquivo(nome);
		
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

	public static void algoritimoHeapSort(ControleArquivos controleArq, String nome) {
		try { // metodo para verificar se o nome do arquivo está correto
			ValidationUtils.validarArquivo(nome);
		} catch (DomainException e) {
			System.out.println("Erro: " + e.getMessage());
			return;// se o nome estiver errado o algoritmo não continua, pq irá dar erro por n ter
					// encontrado o arquivo
		}

		Item[] numeros = controleArq.lerArquivo(nome);
		HeapSort hp = new HeapSort();

		long inicio = System.nanoTime();
		hp.heapSort(numeros);
		long fim = System.nanoTime();

		System.out.println("Numero de movimentações: " + hp.getMovimentacao());
		System.out.println("Numero de comparações: " + hp.getComparacao());

		System.out.println("\nVetor ordenado: ");
		for (Item n : numeros) {
			System.out.println(n.getChave());
		}

		double duracao = (fim - inicio) / 1_000_000.0;
		System.out.println("Tempo de execução do HeapSort: " + duracao + " ms");
	}

	public static void algoritimoInsercaoDireta(ControleArquivos controleArq, String nome) {
		try { // metodo para verificar se o nome do arquivo está correto
			ValidationUtils.validarArquivo(nome);
		} catch (DomainException e) {
			System.out.println("Erro: " + e.getMessage());
			return;// se o nome estiver errado o algoritmo não continua, pq irá dar erro por n ter
					// encontrado o arquivo
		}
		InsercaoDireta id = new InsercaoDireta();
		Item[] nums = controleArq.lerArquivo(nome);

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

	public static void algoritimoShellsort(ControleArquivos controleArq, String nome) {
		try { // metodo para verificar se o nome do arquivo está correto
			ValidationUtils.validarArquivo(nome);
		} catch (DomainException e) {
			System.out.println("Erro: " + e.getMessage());
			return;// se o nome estiver errado o algoritmo não continua, pq irá dar erro por n ter
					// encontrado o arquivo
		}
		Shellsort shell = new Shellsort();
		Item[] nums = controleArq.lerArquivo(nome);

		//Shellsort.comparacao = 0;
		//Shellsort.movimentacao = 0;

		long start = System.nanoTime();
		shell.shellSort(nums);
		long end = System.nanoTime();

		// adicionar numero de movimentações e comparativos
		System.out.println("Vetor ordenado (Shellsort):");
		for (Item n : nums) {
			System.out.println(n.getChave());
		}

		double duration = (end - start) / 1_000_000.0;
		System.out.println("Tempo de execução do Shellsort: " + duration + " ms");
	}

	public static void algoritimoBubblesort(ControleArquivos controleArq, String nome) {
		try { // metodo para verificar se o nome do arquivo está correto
			ValidationUtils.validarArquivo(nome);
		} catch (DomainException e) {
			System.out.println("Erro: " + e.getMessage());
			return;// se o nome estiver errado o algoritmo não continua, pq irá dar erro por n ter
					// encontrado o arquivo
		}
		Bubblesort bubb = new Bubblesort();
		Item[] nums = controleArq.lerArquivo(nome);


		long start = System.nanoTime();
		bubb.bubblesort(nums);
		long end = System.nanoTime();

		System.out.println("Vetor ordenado (Bubblesort):");
		for (Item n : nums) {
			System.out.println(n.getChave());
		}

		double duration = (end - start) / 1_000_000.0;
		System.out.println("Tempo de execução do Bubblesort: " + duration + " ms");
	}

public static void imprimirTabela(ControleArquivos controleArq, String nomeArquivo){
//
	
}
	//------------------------------- TABELA TESTE ------------------------------------------------------------------------
	
public static void adicionarNaTabela(int comp, int mov, double duration){
}
}
