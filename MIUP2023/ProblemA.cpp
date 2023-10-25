#include <iostream>
#include <string>

int main()
{
    int numTests;
    std::cin >> numTests;
    for (int i = 0; i < numTests; i++)
    {
        int dim;
        std::cin >> dim;
        std::string line;
        std::cin >> line;
        int numGrenades = 0;
        for (int j = 0; j < line.length(); j++)
        {
            if (line[j] == 'F')
            {
                j += dim - 1;
                numGrenades++;
            }
        }
        std::cout << numGrenades << std::endl;
    }
    return 0;
}