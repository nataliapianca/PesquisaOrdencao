package aplication;

import java.util.Scanner;

import dados.Item;
import exceptions.DomainException;
import exceptions.ValidationUtils;
import sistema.ControleArquivos;
import sistema.HeapSort;
import sistema.SelecaoDireta;

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
		String nome = lerString("Digite o nome do arquivo que dejesa ler: ");
		int[] vetor = null;
		
		try {
			ValidationUtils.validarArquivo(nome);
			
			vetor = controleArq.lerArquivo(nome, num);
		} catch(DomainException e) {
			System.out.println("Erro: "+  e.getMessage());
		}
		
		for (int n : vetor) {
			System.out.print(n + "  ");
		}
	}

	public static void ordenarArquivo(ControleArquivos controleArq) {
		menuOrdenacao();
		String nome = lerString("Digite o nome do arquivo que deseja ordenar: ");
		
		int alg = lerInt("Opção: ");
		sc.nextLine();


		switch (alg) {
		case 1:
				SelecaoDireta sd = new SelecaoDireta();
			   int[] numeros = controleArq.lerArquivo(nome, num);
			   
			    long inicio = System.nanoTime();
			    sd.selecaoDireta(numeros);
			    long fim = System.nanoTime();

			    System.out.println("vetor ordenado:");
			    for (int i=0; i<numeros.length; i++) {
			    	System.out.println(numeros[i]);
			    } //nao ta imprimindo essa merda ent nao sei se ta certo o tempo q ta dando!!

			    double duracao = (fim - inicio) / 1_000_000.0;
			    System.out.println("tempo de execução da Seleção Direta: " + duracao);
			    break;
		case 2:
			AlgoritHeapSort(controleArq, nome);
			break;
		case 3:

			break;
		case 4:

			break;
		case 5:

			break;
		case 6:

			break;
		case 7:

			break;
		default:
			System.out.println("inválido");
		}
	}
	
	public static void menuOrdenacao() {
		System.out.println("\n==========Escolha o algoritmo de ordenação:==========" + 	
						"\n1. Seleção Direta" + 
						"\n2. HeapSort" + 
						"\n3. Inserção Direta" + 
						"\n4. ShellSort" +
						"\n5. Bubblesort" + 
						"\n6. Shakesort" +
						"\n7. QuickSort");
		System.out.println("======================================================");
	}
	
 	public static void menu() {
		System.out.println("\n========== MENU PRINCIPAL ==========" + 
						"\n1. Gerar e Gravar Arquivo com Números Aleatórios" + 	
						"\n2. Ler e Exibir Conteúdo de um Arquivo" + 
						"\n3. Ordenar Arquivo" + 
						"\n4. Sair");
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
		HeapSort hp = new HeapSort();
		   Item[] numeros = controleArq.lerArquivo(nome, num);
		   
		    long inicio = System.nanoTime();
		    hp.heapSort(numeros);
		    long fim = System.nanoTime();

		    System.out.println("vetor ordenado:");
		    for (int i=0; i<numeros.length; i++) {
		    	System.out.println(numeros[i]);
		    } //nao ta imprimindo essa merda ent nao sei se ta certo o tempo q ta dando!!

		    double duracao = (fim - inicio) / 1_000_000.0;
		    System.out.println("tempo de execução da Seleção Direta: " + duracao);
	}





}