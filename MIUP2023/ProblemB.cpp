#include <iostream>
#include <unordered_map>
#include <unordered_set>
#include <queue>
#include <cstdint>


int dijkstra(std::unordered_map<int, int>* graph, int n, int start, int end)
{
    std::priority_queue<std::pair<int, int>, std::vector<std::pair<int, int>>, std::greater<std::pair<int, int>>> queue;
    int dist[n];
    for (int i = 0; i < n; i++)
    {
        dist[i] = INT32_MAX;
    }
    bool verified[n];
    std::unordered_set<int> visited;
    dist[start] = 0;
    queue.push({0, start});
    visited.insert(start);
    while (!queue.empty())
    {
        int cost = queue.top().first;
        int node = queue.top().second;
        queue.pop();
        for (auto e : graph[node])
        {
            int nextNode = e.first;
            int nextCost = e.second;
            if (cost + nextCost < dist[nextNode])
            {
                visited.insert(nextNode);
                dist[nextNode] = cost + nextCost;
                queue.push({dist[nextNode], nextNode});
            }
        }
    }
    return dist[end];
}

int main()
{
    int q, s, t;
    std::cin >> q;
    std::cin >> s;
    std::cin >> t;
    std::unordered_map<int, int> graph[q];
    for (int i = 0; i < s; i++)
    {
        int start, end, cost;
        std::cin >> start;
        std::cin >> end;
        std::cin >> cost;
        graph[start][end] = 0;
        graph[end][start] = cost;
    }
    for (int i = 0; i < t; i++)
    {
        int start, end;
        std::cin >> start;
        std::cin >> end;
        int pathCost = dijkstra(graph, q, start, end);
        std::cout << pathCost << std::endl;
    }
    return 0;
}