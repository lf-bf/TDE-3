public class AlgoritmosOrdenacao {
    
    static class Estatisticas {
        int trocas;
        int iteracoes;
        
        public Estatisticas() {
            this.trocas = 0;
            this.iteracoes = 0;
        }
        
        public void reset() {
            this.trocas = 0;
            this.iteracoes = 0;
        }
    }
    
    public static int[] copiarVetor(int[] original) {
        int[] copia = new int[original.length];
        for (int i = 0; i < original.length; i++) {
            copia[i] = original[i];
        }
        return copia;
    }
    
    public static void imprimirVetor(int[] vetor, String nome) {
        System.out.print(nome + ": ");
        for (int i = 0; i < vetor.length; i++) {
            System.out.print(vetor[i]);
            if (i < vetor.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println();
    }
    
    public static void bubbleSort(int[] vetor, Estatisticas stats) {
        stats.reset();
        int n = vetor.length;
        boolean trocou;
        
        for (int i = 0; i < n - 1; i++) {
            trocou = false;
            stats.iteracoes++;
            
            for (int j = 0; j < n - i - 1; j++) {
                if (vetor[j] > vetor[j + 1]) {
                    int temp = vetor[j];
                    vetor[j] = vetor[j + 1];
                    vetor[j + 1] = temp;
                    stats.trocas++;
                    trocou = true;
                }
            }
            
            if (!trocou) {
                break;
            }
        }
    }
    
    public static void selectionSort(int[] vetor, Estatisticas stats) {
        stats.reset();
        int n = vetor.length;
        
        for (int i = 0; i < n - 1; i++) {
            stats.iteracoes++;
            int minIndex = i;
            
            for (int j = i + 1; j < n; j++) {
                if (vetor[j] < vetor[minIndex]) {
                    minIndex = j;
                }
            }
            
            if (minIndex != i) {
                int temp = vetor[i];
                vetor[i] = vetor[minIndex];
                vetor[minIndex] = temp;
                stats.trocas++;
            }
        }
    }
    
    public static void cocktailSort(int[] vetor, Estatisticas stats) {
        stats.reset();
        int n = vetor.length;
        boolean trocou = true;
        int inicio = 0;
        int fim = n - 1;
        
        while (trocou) {
            stats.iteracoes++;
            trocou = false;
            
            for (int i = inicio; i < fim; i++) {
                if (vetor[i] > vetor[i + 1]) {
                    int temp = vetor[i];
                    vetor[i] = vetor[i + 1];
                    vetor[i + 1] = temp;
                    stats.trocas++;
                    trocou = true;
                }
            }
            
            if (!trocou) break;
            
            fim--;
            trocou = false;
            
            for (int i = fim; i > inicio; i--) {
                if (vetor[i] < vetor[i - 1]) {
                    int temp = vetor[i];
                    vetor[i] = vetor[i - 1];
                    vetor[i - 1] = temp;
                    stats.trocas++;
                    trocou = true;
                }
            }
            
            inicio++;
        }
    }
    
    public static void gnomeSort(int[] vetor, Estatisticas stats) {
        stats.reset();
        int n = vetor.length;
        int index = 0;
        
        while (index < n) {
            stats.iteracoes++;
            
            if (index == 0) {
                index++;
            } else if (vetor[index] >= vetor[index - 1]) {
                index++;
            } else {
                int temp = vetor[index];
                vetor[index] = vetor[index - 1];
                vetor[index - 1] = temp;
                stats.trocas++;
                index--;
            }
        }
    }
    
    public static void combSort(int[] vetor, Estatisticas stats) {
        stats.reset();
        int n = vetor.length;
        int gap = n;
        boolean trocou = true;
        
        while (gap != 1 || trocou) {
            stats.iteracoes++;
            
            gap = (gap * 10) / 13;
            if (gap < 1) {
                gap = 1;
            }
            
            trocou = false;
            
            for (int i = 0; i < n - gap; i++) {
                if (vetor[i] > vetor[i + gap]) {
                    int temp = vetor[i];
                    vetor[i] = vetor[i + gap];
                    vetor[i + gap] = temp;
                    stats.trocas++;
                    trocou = true;
                }
            }
        }
    }
    
    public static void bucketSort(int[] vetor, Estatisticas stats) {
        stats.reset();
        int n = vetor.length;
        
        if (n <= 1) return;
        
        int min = vetor[0];
        int max = vetor[0];
        for (int i = 1; i < n; i++) {
            if (vetor[i] < min) min = vetor[i];
            if (vetor[i] > max) max = vetor[i];
        }
        
        if (min == max) return;
        
        int numBuckets = n;
        int range = max - min + 1;
        
        int[][] buckets = new int[numBuckets][n];
        int[] bucketSizes = new int[numBuckets];
        
        for (int i = 0; i < numBuckets; i++) {
            bucketSizes[i] = 0;
        }
        
        for (int i = 0; i < n; i++) {
            stats.iteracoes++;
            int bucketIndex = ((vetor[i] - min) * (numBuckets - 1)) / range;
            if (bucketIndex >= numBuckets) bucketIndex = numBuckets - 1;
            
            buckets[bucketIndex][bucketSizes[bucketIndex]] = vetor[i];
            bucketSizes[bucketIndex]++;
        }
        
        for (int i = 0; i < numBuckets; i++) {
            if (bucketSizes[i] > 1) {
                for (int j = 1; j < bucketSizes[i]; j++) {
                    int key = buckets[i][j];
                    int k = j - 1;
                    
                    while (k >= 0 && buckets[i][k] > key) {
                        buckets[i][k + 1] = buckets[i][k];
                        stats.trocas++;
                        k--;
                    }
                    buckets[i][k + 1] = key;
                    if (k + 1 != j) stats.trocas++;
                }
            }
        }
        
        int index = 0;
        for (int i = 0; i < numBuckets; i++) {
            for (int j = 0; j < bucketSizes[i]; j++) {
                vetor[index] = buckets[i][j];
                index++;
            }
        }
    }
    
    public static void main(String[] args) {
        int[] vetor1 = {12, 18, 9, 25, 17, 31, 22, 27, 16, 13, 19, 23, 20, 30, 14, 11, 15, 24, 26, 28};
        int[] vetor2 = {5, 7, 9, 10, 12, 14, 15, 17, 19, 21, 22, 23, 24, 25, 27, 28, 29, 30, 31, 32};
        int[] vetor3 = {99, 85, 73, 60, 50, 40, 35, 30, 25, 20, 15, 14, 13, 12, 11, 10, 9, 8, 7, 6};
        
        int[][] vetores = {vetor1, vetor2, vetor3};
        String[] nomeVetores = {"Vetor 1 (Aleatório)", "Vetor 2 (Já Ordenado)", "Vetor 3 (Decrescente)"};
        String[] algoritmos = {"Bubble Sort", "Selection Sort", "Cocktail Sort", "Gnome Sort", "Comb Sort", "Bucket Sort"};
        
        Estatisticas stats = new Estatisticas();
        
        for (int v = 0; v < vetores.length; v++) {
            System.out.println("\n" + "=".repeat(60));
            System.out.println(nomeVetores[v]);
            System.out.println("=".repeat(60));
            
            imprimirVetor(vetores[v], "Vetor Original");
            System.out.println();
            
            int[] copia = copiarVetor(vetores[v]);
            bubbleSort(copia, stats);
            System.out.println(algoritmos[0] + ":");
            System.out.println("  Trocas: " + stats.trocas + " | Iterações: " + stats.iteracoes);
            imprimirVetor(copia, "  Resultado");
            System.out.println();
            
            copia = copiarVetor(vetores[v]);
            selectionSort(copia, stats);
            System.out.println(algoritmos[1] + ":");
            System.out.println("  Trocas: " + stats.trocas + " | Iterações: " + stats.iteracoes);
            imprimirVetor(copia, "  Resultado");
            System.out.println();
            
            copia = copiarVetor(vetores[v]);
            cocktailSort(copia, stats);
            System.out.println(algoritmos[2] + ":");
            System.out.println("  Trocas: " + stats.trocas + " | Iterações: " + stats.iteracoes);
            imprimirVetor(copia, "  Resultado");
            System.out.println();
            
            copia = copiarVetor(vetores[v]);
            gnomeSort(copia, stats);
            System.out.println(algoritmos[3] + ":");
            System.out.println("  Trocas: " + stats.trocas + " | Iterações: " + stats.iteracoes);
            imprimirVetor(copia, "  Resultado");
            System.out.println();
            
            copia = copiarVetor(vetores[v]);
            combSort(copia, stats);
            System.out.println(algoritmos[4] + ":");
            System.out.println("  Trocas: " + stats.trocas + " | Iterações: " + stats.iteracoes);
            imprimirVetor(copia, "  Resultado");
            System.out.println();
            
            copia = copiarVetor(vetores[v]);
            bucketSort(copia, stats);
            System.out.println(algoritmos[5] + ":");
            System.out.println("  Trocas: " + stats.trocas + " | Iterações: " + stats.iteracoes);
            imprimirVetor(copia, "  Resultado");
            System.out.println();
        }
    }
}