package sistema;

import dados.Item;

public class SelecaoDireta {

	int comparacao = 0;
	int movimentacao = 0;

	public void selecaoDireta(Item[] vetor) {
		int min;
		Item temp;
		for (int i = 0; i < vetor.length; i++) {
			min = i;
			for (int j = i + 1; j < vetor.length; j++) {
				//comparação
				comparacao++;
				if (vetor[j].getChave() < vetor[min].getChave()) {
					min = j;
				}
			}
			temp = vetor[i];
			movimentacao++;
			vetor[i] = vetor[min];
			vetor[min] = temp;
		}
	}
}