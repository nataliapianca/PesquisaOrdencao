package sistema;

public class SelecaoDireta {

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