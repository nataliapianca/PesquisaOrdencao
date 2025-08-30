package sistema;

import dados.Item;

public class Shellsort {

    public void shellSort(Item[] vetor) {
        int i, j, h;
        Item temp;
        h = 1;
        do {
            h = 3 * h + 1;
        } while (h < vetor.length);
        do {
            h = h / 3;
            for (i = h; i < vetor.length; i++) {
                temp = vetor[i];
                j = i;
                while (vetor[j - h].getChave() > temp.getChave()) {
                    vetor[j] = vetor[j - h];
                    j -= h;
                    if (j < h)
                        break;
                }
                vetor[j] = temp;
            }
        } while (h != 1);
    }
}
