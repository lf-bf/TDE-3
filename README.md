# TDE 3 - Algoritmos de Ordenação

## Descrição
Este projeto implementa 6 algoritmos de ordenação em Java, seguindo as restrições específicas do trabalho:

### Algoritmos implementados:
1. **Bubble Sort** (com flag de parada)
2. **Selection Sort**
3. **Cocktail Sort** (Shaker Sort)
4. **Gnome Sort**
5. **Comb Sort**
6. **Bucket Sort**


## Vetores de Teste
O programa testa todos os algoritmos com 3 vetores específicos:

1. **Vetor 1 (Aleatório)**: `{12, 18, 9, 25, 17, 31, 22, 27, 16, 13, 19, 23, 20, 30, 14, 11, 15, 24, 26, 28}`
2. **Vetor 2 (Já Ordenado)**: `{5, 7, 9, 10, 12, 14, 15, 17, 19, 21, 22, 23, 24, 25, 27, 28, 29, 30, 31, 32}`
3. **Vetor 3 (Decrescente)**: `{99, 85, 73, 60, 50, 40, 35, 30, 25, 20, 15, 14, 13, 12, 11, 10, 9, 8, 7, 6}`

## Métricas Coletadas
Para cada algoritmo e cada vetor, o programa coleta:
- **Número de trocas** realizadas
- **Número de iterações** executadas

## Como Executar

```bash
# Compilar
javac AlgoritmosOrdenacao.java

# Executar
java AlgoritmosOrdenacao
```

## Estrutura do Programa

### Classes e Métodos:
- `Estatisticas`: Classe para armazenar trocas e iterações
- `copiarVetor()`: Função para duplicar vetores (sem usar clone)
- `imprimirVetor()`: Exibe o conteúdo dos vetores
- `bubbleSort()`: Implementa Bubble Sort com flag de parada
- `selectionSort()`: Implementa Selection Sort
- `cocktailSort()`: Implementa Cocktail Sort 
- `gnomeSort()`: Implementa Gnome Sort
- `combSort()`: Implementa Comb Sort
- `bucketSort()`: Implementa Bucket Sort 

### Saída do Programa:
1. **Detalhada por vetor**: Mostra o resultado de cada algoritmo para cada vetor

## Resultados dos Testes

### Tabela Completa de Resultados

| Algoritmo     | Vetor 1 (Aleatório) |           | Vetor 2 (Ordenado) |           | Vetor 3 (Decrescente) |           |
|---------------|---------------------|-----------|---------------------|-----------|------------------------|-----------|
|               | Trocas | Iterações | Trocas | Iterações | Trocas | Iterações |
| Bubble Sort   | 78     | 15        | 0      | 1         | 190    | 19        |
| Selection Sort| 18     | 19        | 0      | 19        | 10     | 19        |
| Cocktail Sort | 78     | 6         | 0      | 1         | 190    | 10        |
| Gnome Sort    | 78     | 176       | 0      | 20        | 190    | 400       |
| Comb Sort     | 22     | 9         | 0      | 8         | 18     | 9         |
| Bucket Sort   | 2      | 20        | 0      | 20        | 28     | 20        |

### Rankings por Número de Trocas

#### Vetor 1 (Aleatório)
| Posição | Algoritmo      | Trocas |
|---------|----------------|--------|
| 1º      | Bucket Sort    | 2      |
| 2º      | Selection Sort | 18     |
| 3º      | Comb Sort      | 22     |
| 4º      | Bubble Sort    | 78     |
| 4º      | Cocktail Sort  | 78     |
| 4º      | Gnome Sort     | 78     |

#### Vetor 2 (Já Ordenado)
| Posição | Algoritmo      | Trocas |
|---------|----------------|--------|
| 1º      | Todos          | 0      |

#### Vetor 3 (Decrescente)
| Posição | Algoritmo      | Trocas |
|---------|----------------|--------|
| 1º      | Selection Sort | 10     |
| 2º      | Comb Sort      | 18     |
| 3º      | Bucket Sort    | 28     |
| 4º      | Bubble Sort    | 190    |
| 4º      | Cocktail Sort  | 190    |
| 4º      | Gnome Sort     | 190    |

### Rankings por Número de Iterações

#### Vetor 1 (Aleatório)
| Posição | Algoritmo      | Iterações |
|---------|----------------|-----------|
| 1º      | Cocktail Sort  | 6         |
| 2º      | Comb Sort      | 9         |
| 3º      | Bubble Sort    | 15        |
| 4º      | Selection Sort | 19        |
| 5º      | Bucket Sort    | 20        |
| 6º      | Gnome Sort     | 176       |

#### Vetor 2 (Já Ordenado)
| Posição | Algoritmo      | Iterações |
|---------|----------------|-----------|
| 1º      | Bubble Sort    | 1         |
| 1º      | Cocktail Sort  | 1         |
| 3º      | Comb Sort      | 8         |
| 4º      | Selection Sort | 19        |
| 5º      | Gnome Sort     | 20        |
| 5º      | Bucket Sort    | 20        |

#### Vetor 3 (Decrescente)
| Posição | Algoritmo      | Iterações |
|---------|----------------|-----------|
| 1º      | Comb Sort      | 9         |
| 2º      | Cocktail Sort  | 10        |
| 3º      | Selection Sort | 19        |
| 3º      | Bubble Sort    | 19        |
| 5º      | Bucket Sort    | 20        |
| 6º      | Gnome Sort     | 400       |

### Análise dos Resultados

#### Melhor Performance Geral (Menos Trocas):
1. **Bucket Sort** - Excelente para vetor aleatório (2 trocas)
2. **Selection Sort** - Consistente em todos os cenários
3. **Comb Sort** - Bom equilíbrio em diferentes situações

#### Melhor Performance Geral (Menos Iterações):
1. **Cocktail Sort** - Muito eficiente em detecção de ordem
2. **Comb Sort** - Consistentemente rápido
3. **Bubble Sort** - Excelente com flag de parada para vetores ordenados

#### Observações:
- **Vetor Ordenado**: Bubble Sort e Cocktail Sort são os mais eficientes (1 iteração, 0 trocas)
- **Vetor Aleatório**: Bucket Sort se destaca com apenas 2 trocas
- **Vetor Decrescente**: Selection Sort faz menos trocas (10), enquanto Comb Sort é mais rápido (9 iterações)
- **Gnome Sort**: Consistentemente o pior em iterações, especialmente para vetores decrescentes

## Características dos Algoritmos

- **Bubble Sort**: O(n²) com otimização de flag de parada
- **Selection Sort**: O(n²) sempre
- **Cocktail Sort**: O(n²) mas mais eficiente que bubble sort comum
- **Gnome Sort**: O(n²) similar ao insertion sort
- **Comb Sort**: Melhora do bubble sort com gap decrescente
- **Bucket Sort**: O(n + k) no melhor caso, implementado sem estruturas auxiliares complexas