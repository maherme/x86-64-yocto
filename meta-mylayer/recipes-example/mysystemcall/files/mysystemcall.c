#include <stdio.h>
#include <stdlib.h>

int main(int argc, char* argv[])
{
    printf("%s: call to lspci:\n", argv[0]);
    system("lspci");
    exit(EXIT_SUCCESS);
}
