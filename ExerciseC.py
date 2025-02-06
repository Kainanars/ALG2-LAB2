def find_second_min_cow(n, records):
    cows = {"Bessie": 0, "Elsie": 0, "Daisy": 0, "Gertie": 0, "Annabelle": 0, "Maggie": 0, "Henrietta": 0}
    
    for name, amount in records:
        cows[name] += amount
    
    unique_milk = sorted(set(cows.values()))
    if len(unique_milk) < 2:
        return "Tie"
    
    second_min_milk = unique_milk[1]
    result = [cow for cow, milk in cows.items() if milk == second_min_milk]
    
    return result[0] if len(result) == 1 else "Tie"

n = int(input())
records = [input().split() for _ in range(n)]
records = [(name, int(amount)) for name, amount in records]
print(find_second_min_cow(n, records))
