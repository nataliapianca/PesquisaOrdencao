package sistema;

import dados.Item;

public class InsercaoDireta {

    int comparacao = 0;
	int movimentacao = 0;

    public void insercaoDireta(Item[] vetor) {
        int nElem = vetor.length;

        for (int i = 1; i < nElem; i++) {
            Item temp = vetor[i];
            int j = i - 1;

            while (j >= 0 && vetor[j].getChave() > temp.getChave()) {
                comparacao++;
                vetor[j + 1] = vetor[j];
                 movimentacao++;
                j--;
            }
            vetor[j + 1] = temp;
             movimentacao++;
        }
    }
}
