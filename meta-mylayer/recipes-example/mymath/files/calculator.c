#include "mymath.h"
#include <mymath2.h>
#include <stdlib.h>
#include <stdio.h>

#define LENGTH_INPUT    3

static void flush_input_buffer(void)
{
    for(int c; (c = getchar()) != EOF && c != '\n';);
}

static int get_input(char* input, int length)
{
    int i = 0;
    char c;

    do
    {
        c = fgetc(stdin);
        if('\n' == c)
        {
            input[i] = '\0';
            break;
        }
        if((length - 1) <= i)
        {
            input[i] = '\0';
            flush_input_buffer();
            break;
        }
        input[i] = c;
        i++;
    }while(1);

    return i;
}

static int convert_str_to_int(char* s)
{
    int output;
    int ret;

    ret = sscanf(s, "%d", &output);
    if(1 != ret)
    {
        printf("Error in sscanf, returned: %d\n", ret);
        exit(EXIT_FAILURE);
    }

    return output;
}

int main(int argc, char* argv[])
{
    char str[LENGTH_INPUT];
    int a, b;

    printf("Introduce first operand, a =\n");
    get_input(str, LENGTH_INPUT);
    a = convert_str_to_int(str);
    printf("Introduced a = %d\n", a);


    printf("Introduce second operand, b =\n");
    get_input(str, LENGTH_INPUT);
    b = convert_str_to_int(str);
    printf("Introduced b = %d\n", b);

    printf("%d + %d = %d\n", a, b, my_sum(a, b));
    printf("%d - %d = %d\n", a, b, my_sub(a, b));
    printf("%d x %d = %d\n", a, b, my_mult(a, b));
    printf("%d / %d = %.2f\n", a, b, my_div(a, b));
    printf("square of %d = %d\n", a, square(a));
    printf("cube of %d = %d\n", a, cube(a));
    printf("factorial of %d = %d\n", a, factorial(a));

    exit(EXIT_SUCCESS);
}
