def count_unique_substrings(n, text):
    return len({text[i:i+n] for i in range(len(text) - n + 1)})


num_cases = int(input().strip())  # Número de casos de teste
results = []

for _ in range(num_cases):
    input()
    n, nc = map(int, input().split())  # Ler N e NC (NC não é utilizado)
    text = input().strip()  # Ler o texto

    results.append(str(count_unique_substrings(n, text)))

print("\n\n".join(results))  # Imprimir os resultados separados por linha em branco

# Crazy Search