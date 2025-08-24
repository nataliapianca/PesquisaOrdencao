package sistema;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

import dados.Item;

public class ControleArquivos {
	
	
	
	//---------------------------- criação do arquivo para a mesma pasta que está nosso código ----------------------------
	
	public boolean criar(String nome) {
		try {
				File arquivo = new File(nome);
		
				if(arquivo.createNewFile()) {
					System.out.println("Arquivo criado com sucesso.\nCaminho: " + arquivo.getAbsolutePath());
					return true;
				} else {
					System.out.println("Arquivo já existe.");
					return true;
				}
		
	    } catch (IOException e) {
	    	System.out.println("Ocorreu um erro: " + e.getMessage());
	    	return false;
	    }
	}
	
	//---------------------------- escrita e leitura do arquivo ----------------------------
	 public void escreverArquivo(String nome, int num) {
		 
		try (BufferedWriter escritor = new BufferedWriter(new FileWriter(nome))){
			Random aleatorio = new Random();
			int valor;
			
			for (int i=0; i<num; i++) {
				valor = aleatorio.nextInt(1000); 
				escritor.write(valor + "\n");
			}
		} catch (IOException e) {
			System.out.println("erro ao salvar numeros " + e.getMessage());
		}

	}

	public Item[] lerArquivo(String nome, int n) { 
	    String linha; // o proprio codigo pode imprimir um de cada vez
	    int cont = 0;
	    Item[] vetor = new Item[n];
	    Item num;
	    
	    try (BufferedReader leitor = new BufferedReader(new FileReader(nome))) {
	    	
	        while ((linha = leitor.readLine()) != null) {
	            num = new Item(Integer.parseInt(linha.trim()));
	            vetor[cont] = num;
	            cont++;
	        }
	        
	        leitor.close();
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
	
	
}