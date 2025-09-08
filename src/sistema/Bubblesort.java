package sistema;

import dados.Item;

public class Bubblesort {
public static int movimentacao = 0;
public static int comparacao = 0;

    public Item[] vetor;
    public int nElem = 0;

    public void bubblesort(Item[] vetor) {
        this.vetor = vetor;
        this.nElem = vetor.length;
        bubblesort();
    }

    private void bubblesort() {
        int n, i, j;
        Item temp;
        n = this.nElem - 1;
        do {
            i = 0;
            for (j = 0; j < n; j++)
                if (this.vetor[j].getChave() > this.vetor[j + 1].getChave()) {
                    temp = this.vetor[j];
                    this.vetor[j] = this.vetor[j + 1];
                    this.vetor[j + 1] = temp;
                    i = j;
                    movimentacao ++;
                    comparacao ++;
                }
            n = i;
        } while (n >= 1);
    }
}
