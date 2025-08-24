package sistema;

import dados.Item;

public class HeapSort {
	private int TAMANHO;
	private Item[] vetor;
	public  int nElem;
	/*
	public Ordenacao(int tAMANHO, int[] vetor) {
		super();
		TAMANHO = tAMANHO;
		this.vetor =  new Item[tAMANHO];
		this.nElem = 0;
	}
	*/
	
	
	public int getnElem() {
		return nElem;
	}

	public void setnElem(int nElem) {
		this.nElem = nElem;
	}

	public int getTAMANHO() {
		return TAMANHO;
	}
	
	public Item[] getVetor() {
		return vetor;
	}


	
	
/*
	public void heapSort (){
		int dir = getTAMANHO()-1;
		int esq = (dir-1)/2;
		int temp;
		while (esq >= 0)
			refazHeap (esq--, getTAMANHO()-1);
		while (dir > 0){
			temp = this.vetor[0];
			this.vetor [0] = this.vetor [dir];
			this.vetor [dir--] = temp;
			refazHeap(0, dir);
		}
	}
	private void refazHeap (int esq, int dir){
		int i = esq;
		int MaiorFolha = 2*i+1;
		Item raiz = this.vetor[i];
		boolean heap = false;
		while ((MaiorFolha <= dir) && (!heap)){
			if (MaiorFolha < dir)
				if (this.vetor[MaiorFolha]<
						this.vetor[MaiorFolha+1])
					MaiorFolha++;
			if (raiz.getChave() < this.vetor[MaiorFolha]) {
				this.vetor[i] = this.vetor[MaiorFolha];
				i = MaiorFolha;
				MaiorFolha = 2*i+1;
			}
			else
				heap = true;
		}
		this.vetor[i] = raiz;
	}*/
		
	public void heapSort (Item[] vetor){
		int dir = nElem-1;
		int esq = (dir-1)/2;
		Item temp;
		while (esq >= 0)
			refazHeap (esq--, this.nElem-1);
		while (dir > 0){
			temp = this.vetor[0];
			this.vetor [0] = this.vetor [dir];
			this.vetor [dir--] = temp;
			refazHeap(0, dir);
		}
	}
	private void refazHeap (int esq, int dir){
		int i = esq;
		int MaiorFolha = 2*i+1;
		Item raiz = this.vetor[i];
		boolean heap = false;
		while ((MaiorFolha <= dir) && (!heap)){
			if (MaiorFolha < dir)
				if (this.vetor[MaiorFolha].getChave()<
						this.vetor[MaiorFolha+1].getChave())
					MaiorFolha++;
			if (raiz.getChave() < this.vetor[MaiorFolha].getChave()) {
				this.vetor[i] = this.vetor[MaiorFolha];
				i = MaiorFolha;
				MaiorFolha = 2*i+1;
			}
			else
				heap = true;
		}
		this.vetor[i] = raiz;
	}
}
