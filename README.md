## Desafios de Algoritmos

Os problemas a seguir foram resolvidos utilizando técnicas de estruturas de dados eficientes, como heaps e mapas. Você pode acessar os enunciados diretamente nos seguintes links:

- [Problema A - VJudge](https://vjudge.net/contest/687746#problem/A)
- [Problema B - VJudge](https://vjudge.net/contest/687746#problem/B)

## Desafio 1: K Menores Elementos

### Descrição

O objetivo deste desafio é gerenciar uma sequência de operações sobre uma lista de números utilizando uma fila de prioridade (min-heap). O código permite inserir um número e consultar o menor número entre os `K` menores números inseridos.

### Funcionalidade

- O código recebe dois inteiros, `N` e `K`, onde `N` é o número de operações e `K` é o tamanho da heap.
- Para cada operação:
  - **"I"**: Insere um número na heap. Se o tamanho da heap exceder `K`, o maior número é removido.
  - **"Q"**: Consulta o menor número atual na heap.
- A heap é mantida para garantir que sempre os `K` menores números estejam armazenados.

### Complexidade de Tempo

- **Inserção (I):** A operação de inserção na heap tem complexidade `O(log K)` porque a heap pode ter no máximo `K` elementos.
- **Consulta (Q):** A consulta ao menor número na heap é uma operação de tempo constante, ou seja, `O(1)`.
- **Complexidade Total:** A complexidade total do código é `O(N log K)`, onde `N` é o número de operações e `K` é o tamanho da heap.

---

## Desafio 2: Gerenciamento de Clientes com Prioridade

### Descrição

Neste desafio, o objetivo é gerenciar uma fila de clientes com base em sua prioridade. O código utiliza duas heaps (max-heap e min-heap) para armazenar os clientes com maior e menor prioridade, respectivamente. Além disso, um mapa é utilizado para garantir que os clientes removidos sejam válidos.

### Funcionalidade

- **Comando 1:** Adiciona um cliente com um identificador único (`id`) e uma prioridade.
- **Comando 2:** Remove o cliente com a maior prioridade (max-heap), se ele ainda estiver presente no mapa.
- **Comando 3:** Remove o cliente com a menor prioridade (min-heap), se ele ainda estiver presente no mapa.
- O mapa garante que apenas clientes válidos sejam removidos das heaps.

### Complexidade de Tempo

- **Inserção (Comando 1):** A operação de inserção em ambas as heaps tem complexidade `O(log M)`, onde `M` é o número de clientes inseridos.
- **Remoção (Comando 2 e Comando 3):** A remoção do cliente com maior ou menor prioridade tem complexidade `O(log M)` devido ao uso da heap.
- **Complexidade Total:** A complexidade total do código é `O(N log N)`, onde `N` é o número de comandos. A operação mais cara é a inserção e remoção dos clientes das heaps, o que resulta em `O(N log N)`.

---
