package sistema;

import dados.Item;

public class HeapSort {
	public static int movimentacao = 0;
    public static int comparacao = 0;
	
	public Item[] vetor;
	public int nElem = 0;


	public void heapSort(Item[] vet) {
		
		this.vetor = vet;
		this.nElem = vet.length;

		int dir = nElem - 1;
		int esq = (dir - 1) / 2;
		Item temp;
		while (esq >= 0)
			refazHeap(esq--, this.nElem - 1);
		while (dir > 0) {
			temp = this.vetor[0];
			this.vetor[0] = this.vetor[dir];
			this.vetor[dir--] = temp;
			movimentacao++;
			refazHeap(0, dir);
		}
	}

	private void refazHeap(int esq, int dir) {
		int i = esq;
		int MaiorFolha = 2 * i + 1;
		Item raiz = this.vetor[i];
		boolean heap = false;
		while ((MaiorFolha <= dir) && (!heap)) {
			if (MaiorFolha < dir){
				comparacao++;
				if (this.vetor[MaiorFolha].getChave() < this.vetor[MaiorFolha + 1].getChave())
					MaiorFolha++;
			}
			comparacao++;
			if (raiz.getChave() < this.vetor[MaiorFolha].getChave()) {
				this.vetor[i] = this.vetor[MaiorFolha];
				i = MaiorFolha;
				MaiorFolha = 2 * i + 1;
				movimentacao++;
			} else
				heap = true;
		}
		this.vetor[i] = raiz;
	}
}
