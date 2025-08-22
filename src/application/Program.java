package application;

import java.util.Scanner;

import exceptions.DomainException;
import exceptions.ValidationUtils;
import sistema.ControleArquivos;

public class Program {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

    	int num = 0;
        int op;
        do {
            System.out.println("========== MENU PRINCIPAL ==========");
            System.out.println("1. Gerar e Gravar Arquivo com Números Aleatórios");
            System.out.println("2. Ler e Exibir Conteúdo de um Arquivo");
            System.out.println("3. Ordenar Arquivo");
            System.out.println("4. Sair");
            System.out.println("==================================");
            System.out.print("Escolha uma opção: ");
            op = sc.nextInt();
            sc.nextLine(); 

            switch (op) {
                case 1:
                	gerarGravar(num);
                    break;

                case 2:
                	lerEimprimir(num);
                    break;

                case 3:
                    ordenarArquivo(num);
                    break;

                case 4:
                    System.out.println("Programa encerrado.");
                    break;

                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }

        } while (op != 4);
    }

    public static void gerarGravar(int num) {
		System.out.println("Digite quantos numeros deseja gerar aleatoriamente");
		num = sc.nextInt();
		sc.nextLine();
		System.out.println("Digite o caminho do arquivo que voce deseja salvar os arquivos: |ex: dados_teste.txt|");
		String caminho = sc.nextLine();
		ControleArquivos.escreverArquivo(caminho, num);
	}

	public static void lerEimprimir(int num) {
		System.out.println("Digite o nome do arquivo que dejesa ler: ");
		String nome = sc.nextLine();
		try {
			ValidationUtils.validarArquivo(nome);
			ControleArquivos.lerAquivo(nome, num);
		} catch(DomainException e) {
			System.out.println("Erro: "+  e.getMessage());
		}
		
	}


    public static void ordenarArquivo(int num) {
        System.out.print("Digite o nome do arquivo que deseja ordenar: ");
        String nome = sc.nextLine();
        //int[] vetor = ControleArquivos.lerAquivo(nome, num);

        System.out.println("==========Escolha o algoritmo de ordenação:==========");
        System.out.println("1. Seleção Direta");
        System.out.println("2. HeapSort");
        System.out.println("3. Inserção Direta");
        System.out.println("4. ShellSort");
        System.out.println("5. Bubblesort");
        System.out.println("6. Shakesort");
        System.out.println("7. QuickSort");
        System.out.println("======================================================");
        System.out.print("Opção: ");
        int alg = sc.nextInt();
        sc.nextLine();

     
        switch (alg) {
            case 1:
              
                break;
            case 2:
               
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
                System.out.println("invalido");
        }
    }
}
