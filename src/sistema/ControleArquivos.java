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

	static public void lerAquivo(String nome, int num) {
		try (BufferedReader br = new BufferedReader(new FileReader(nome))){
			String linha;
			while((linha = br.readLine()) != null) {
				int valor = Integer.parseInt(linha);
				System.out.println(valor);
			}


		}catch(IOException e) {
			System.out.println("erro ao carregar numeros " + e.getMessage());
		}
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
	
	public void selecaoDireta() {
		int min, temp;
		
	}
	

}
