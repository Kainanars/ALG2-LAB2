MOD = 998244353

def counter(N, M):
    # If N=1, there are M ways to assign the number.
    if N == 1:
        return M % MOD
    # If N=2, there are M×(M−1) ways, since the second person cannot have the same number as the first.
    if N == 2:
        return (M * (M - 1)) % MOD
    # For N >= 3
    # This is because for each person there are M−1 possible choices, except for the last person, who cannot have the same number as the first.
    result = pow(M - 1, N, MOD)
    if N % 2 == 0:
        result = (result + (M - 1)) % MOD
    else:
        result = (result - (M - 1)) % MOD
    return result

# Input
N, M = map(int, input().split())

# Calculation of the result
result = counter(N, M)

# Output
print(result)