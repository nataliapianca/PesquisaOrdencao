# Pirmeira parte do projeto de Pesquisa e Ordenação  

## 📌 Descrição  
Este projeto tem como objetivo implementar e analisar algoritmos clássicos de **pesquisa** e **ordenação**, avaliando o comportamento de cada um em diferentes cenários (melhor caso, pior caso e caso médio).  

O sistema gera números aleatórios (ou em ordem crescente/decrescente), salva em arquivos, realiza buscas, aplica diferentes algoritmos de ordenação e, por fim, gera uma **tabela comparativa** com:  
- Número de comparações  
- Número de movimentações  
- Tempo de execução  

---

## 🔍 Algoritmos de Pesquisa  

### 1. Pesquisa Sequencial (Linear Search)  
Percorre todos os elementos de forma sequencial até encontrar o item desejado ou até o final da lista.  
- **Melhor caso**: O elemento está logo na primeira posição → **O(1)**  
- **Pior caso**: O elemento está na última posição ou não existe → **O(n)**  

### 2. Pesquisa Binária (Binary Search)  
Funciona apenas em vetores previamente **ordenados**. Divide repetidamente a lista ao meio, descartando metade dos elementos a cada comparação.  
- **Melhor caso**: O elemento é encontrado na primeira comparação (no meio) → **O(1)**  
- **Pior caso**: O elemento está em uma das extremidades ou não existe → **O(log n)**  

---

## 🔄 Algoritmos de Ordenação  

### 1. Seleção Direta (Selection Sort)  
Escolhe repetidamente o menor elemento e o coloca na posição correta.  
- **Melhor caso**: `O(n²)`  
- **Pior caso**: `O(n²)`  

### 2. HeapSort  
Transforma o vetor em uma árvore binária heap e remove o maior elemento repetidamente.  
- **Melhor caso**: `O(n log n)`  
- **Pior caso**: `O(n log n)`  

### 3. Inserção Direta (Insertion Sort)  
Insere cada elemento na posição correta dentro da sublista crescente.  
- **Melhor caso**: `O(n)` (vetor já ordenado)  
- **Pior caso**: `O(n²)` (vetor em ordem inversa)  

### 4. ShellSort  
Extensão do Insertion Sort que utiliza espaçamentos para reduzir movimentações.  
- **Melhor caso**: próximo de `O(n log n)` (depende da sequência de incrementos)  
- **Pior caso**: entre `O(n log² n)` e `O(n²)`  

### 5. BubbleSort  
Compara pares adjacentes e os troca até que o vetor esteja ordenado.  
- **Melhor caso**: `O(n)` (com vetor já ordenado e otimização)  
- **Pior caso**: `O(n²)`  

### 6. ShakeSort (Cocktail Shaker Sort)  
Variação do BubbleSort que percorre o vetor em duas direções (ida e volta).  
- **Melhor caso**: `O(n)`  
- **Pior caso**: `O(n²)`  

### 7. QuickSort  
Divide o vetor em partições menores com base em um pivô.  
- **Melhor caso**: `O(n log n)`  
- **Pior caso**: `O(n²)` (quando o pivô sempre gera divisões desbalanceadas)  

---

## 📊 Comparativo de Complexidades  

### Pesquisa  
| Algoritmo            | Melhor Caso | Pior Caso   |
|-----------------------|-------------|-------------|
| Pesquisa Sequencial   | O(1)        | O(n)        |
| Pesquisa Binária      | O(1)        | O(log n)    |

### Ordenação  
| Algoritmo         | Melhor Caso | Pior Caso   |
|-------------------|-------------|-------------|
| Seleção Direta    | O(n²)       | O(n²)       |
| HeapSort          | O(n log n)  | O(n log n)  |
| Inserção Direta   | O(n)        | O(n²)       |
| ShellSort         | O(n log n)  | O(n²)       |
| BubbleSort        | O(n)        | O(n²)       |
| ShakeSort         | O(n)        | O(n²)       |
| QuickSort         | O(n log n)  | O(n²)       |

---

## 🚀 Funcionalidades do Programa  

1. **Gerar e gravar arquivos** com números aleatórios, ordenados ou inversamente ordenados.  
2. **Ler e exibir arquivos** gravados.  
3. **Ordenar arquivos** utilizando os algoritmos disponíveis.  
4. **Imprimir tabela comparativa** de desempenho.  

---

## 📂 Estrutura do Projeto  

- `aplication/Program.java` → Menu principal e controle da aplicação  
- `sistema/` → Implementação dos algoritmos de ordenação e utilitários  
- `dados/Item.java` → Representação dos elementos a serem ordenados  
- `exceptions/` → Classes de validação e tratamento de erros  

---
