package sistema;

import dados.Item;

public class InsercaoDireta {

    public void insercaoDireta(Item[] vetor) {
        int nElem = vetor.length;

        for (int i = 1; i < nElem; i++) {
            Item temp = vetor[i];
            int j = i - 1;

            while (j >= 0 && vetor[j].getChave() > temp.getChave()) {
                vetor[j + 1] = vetor[j];
                j--;
            }
            vetor[j + 1] = temp;
        }
    }
}
