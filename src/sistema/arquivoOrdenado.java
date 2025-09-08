package sistema;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.io.IOException;

import sistema.ControleArquivos;


public class arquivoOrdenado{

    public static void criarArqOrdDecres(){
        int num = 10, valor;
        ArrayList<Integer> vetor = new ArrayList<Integer>(num);

        Random aleatorio = new Random();
        ControleArquivos controle = new ControleArquivos();

        controle.criar("arquivoOrdenadoDecres.txt");

    
		for (int i = 0; i < num; i++) {
			valor = aleatorio.nextInt(1000);
            vetor.add(valor);
        }

        Collections.sort(vetor);

    try (BufferedWriter escritor = new BufferedWriter(new FileWriter("arquivoOrdenadoDecres.txt"))){
        for (int i = vetor.size() - 1; i >= 0; i--){
            escritor.write(vetor.get(i) + "\n");
        }  
	} catch (IOException e) {
			System.out.println("erro ao salvar numeros " + e.getMessage());
	}

    }




}