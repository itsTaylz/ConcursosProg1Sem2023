#include <iostream>
#include <unordered_map>

int main()
{
    int n;
    std::cin >> n;
    std::unordered_map<int, int> map;
    for (int i = 0; i < n; i++)
    {
        int num;
        std::cin >> num;
        map[num]++;
    }
    int m;
    std::cin >> m;
    int sum = 0;
    for (int i = 0; i < m; i++)
    {
        int num;
        std::cin >> num;
        sum += map[num];
    }
    std::cout << sum << std::endl;
    return 0;
}