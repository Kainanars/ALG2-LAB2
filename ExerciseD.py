from collections import defaultdict, deque

def can_get_drunk(m, dependencies):
    graph = defaultdict(list)
    in_degree = defaultdict(int)
    
    for a, b in dependencies:
        graph[a].append(b)
        in_degree[b] += 1
        if a not in in_degree:
            in_degree[a] = 0
    
    queue = deque([node for node in in_degree if in_degree[node] == 0])
    
    visited_count = 0
    while queue:
        node = queue.popleft()
        visited_count += 1
        
        for neighbor in graph[node]:
            in_degree[neighbor] -= 1
            if in_degree[neighbor] == 0:
                queue.append(neighbor)
    
    return visited_count == len(in_degree)


T = int(input().strip())
for case_num in range(1, T + 1):
    m = int(input().strip())
    dependencies = [input().strip().split() for _ in range(m)]
    result = "Yes" if can_get_drunk(m, dependencies) else "No"
    print(f"Case {case_num}: {result}")