## Desafios

Os problemas do laboratório de Algoritmos 2 foram resolvidos conforme os requisitos. Você pode acessar os enunciados diretamente nos seguintes links:

- [Problema A - VJudge](https://vjudge.net/contest/685579#problem/A)
- [Problema B - VJudge](https://vjudge.net/contest/685579#problem/B)


## Desafio 1: Pedido com Programação Dinâmica

### Descrição
O objetivo deste desafio é determinar se é possível realizar um pedido com um custo específico, utilizando uma lista de itens do menu e seus respectivos custos. O algoritmo preenche uma tabela de custos e, para cada pedido, verifica se o custo é possível, impossível ou ambíguo.

### Funcionalidade
- A função principal resolve o problema de forma eficiente utilizando programação dinâmica para preencher a tabela de custos.
- Para cada pedido, o código verifica se o custo total é possível, impossível ou ambíguo e imprime o resultado.

### Complexidade de Tempo
- **Inserção na Tabela de Custos:** A complexidade é O(n * C), onde:
  - `n` é o número de itens no menu (até 110).
  - `C` é o custo máximo (30010).
- **Verificação dos Pedidos:** A complexidade para cada pedido é O(P), onde `P` é o número de pedidos.
- **Complexidade Total:** A complexidade do algoritmo é O(n * C) para o preenchimento da tabela e O(P) para a verificação dos pedidos.

## Desafio 2: Verificação de Árvore Binária Balanceada

### Descrição
Neste desafio, o objetivo é verificar se uma árvore binária de busca (BST) é balanceada. A árvore é considerada balanceada se, para cada nó, a diferença de altura entre suas subárvores esquerda e direita for no máximo 1.

### Funcionalidade
- A árvore binária de busca é implementada com inserção de elementos de acordo com as propriedades de uma BST.
- A função `isBalanced()` verifica se a árvore é balanceada utilizando recursão para calcular a altura das subárvores e comparar as diferenças de altura.

### Complexidade de Tempo
- **Inserção de Elementos:** A complexidade de tempo para inserir cada valor é O(log n) no melhor caso (árvore balanceada) e O(n) no pior caso (árvore degenerada).
- **Verificação de Balanceamento:** A complexidade é O(n), pois o algoritmo percorre todos os nós da árvore para calcular a altura e verificar o balanceamento.
- **Complexidade Total:** No melhor caso (árvore balanceada), a complexidade total é O(n log n), e no pior caso (árvore degenerada), é O(n²).
