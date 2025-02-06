def split_bags(weights):
    total_weight = sum(weights)
    
    # Se a soma total for ímpar, não pode ser dividida igualmente
    if total_weight % 2 != 0:
        return "NO"
    
    target = total_weight // 2
    
    # Programação dinâmica para verificar se é possível formar a soma target
    dp = [False] * (target + 1)
    dp[0] = True  # Soma 0 sempre é possível
    
    for weight in weights:
        for j in range(target, weight - 1, -1):
            dp[j] |= dp[j - weight]
    
    return "YES" if dp[target] else "NO"

# Leitura da entrada
m = int(input())  # Número de casos de teste
for _ in range(m):
    weights = list(map(int, input().split()))
    print(split_bags(weights))
