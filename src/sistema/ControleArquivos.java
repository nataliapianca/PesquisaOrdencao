package sistema;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;


public class ControleArquivos {
	
	
	//---------------------------- escrita e leitura do arquivo ----------------------------
	static public void escreverArquivo(String caminho, int num) {
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(caminho))){
			Random aleatorio = new Random();
			int valor;
			for (int i=0; i<num; i++) {
				valor = aleatorio.nextInt(1000); 
				bw.write(valor + "\n");
			}

		}catch (IOException e) {
			System.out.println("erro ao salvar numeros " + e.getMessage());
		}

	}

	public static int[] lerArquivo(String nome, int num) { //passando os valores como vetor
	    int[] vetor = new int[num];
	    int contador = 0;

	    try (BufferedReader br = new BufferedReader(new FileReader(nome))) {
	        String linha;
	        while ((linha = br.readLine()) != null && contador < num) {
	            vetor[contador] = Integer.parseInt(linha.trim());
	            contador++;
	        }
	    } catch (IOException e) {
	        System.out.println("erro ao carregar números: " + e.getMessage());
	    }

	    return vetor; 
	}
	
 //---------------------------- Aplicação dos algoritimos ----------------------------
	
	//Exemplo seleção direta
	/*
	 * public void seleçãoDireta ( ){
       int i, j, minimo;
	   Item temp;
	   for (i=0; i<this.nElem-1;i++){
	      minimo = i;
	      for (j = i+1; j < this.nElem; j++)
	         if (this.vetor[j].getChave<this.vetor[minimo].getChave)
	         minimo = j;
	      temp = this.vetor[minimo];
	      this.vetor[minimo] = this.vetor[i];
	      this.vetor[i] = temp;
}
}
	 * 
	 */
	
	public void selecaoDireta(int[] vetor) { //aplicando o da renata com o vetor que foi criado em cima
		int min, temp;
		for(int i=0; i<vetor.length; i++) {
			min = i;
			for (int j=i+1; j<vetor.length; j++) {
				if (vetor[j] < vetor[min]) {
					min = j;
				}
			}
			temp = vetor[i];
			vetor[i] = vetor[min];
			vetor[min] = temp;	
		}
	}
	

}