#include <stdio.h>
#include <string.h>

#define boolean unsigned char
#define TRUE 1
#define FALSE 0

int strStr(char *haystack, char *needle) {

    char *h = haystack;
    int index = -1;
    int haystack_len = strlen(haystack);
    int needle_len = strlen(needle);

    if (*needle == '\0')
        return 0;

    if (needle_len > haystack_len) {
        return index;
    }
    else if (needle_len == haystack_len) {
        if (!strcmp(haystack, needle))
            return 0;
        else
            return index;
    }
        

    while (*h != '\0') {
        if (*h == *needle) {
            char *h_ptr = h + 1;
            char *n_ptr = needle + 1;

            boolean found = TRUE;

            while (*n_ptr != '\0') {
                if (*h_ptr == '\0' || *h_ptr != *n_ptr) {
                    found = FALSE;
                    break;
                }
                n_ptr++;
                h_ptr++;
            }

            if (found) {
                index = h - haystack;
                break;
            }
        }
        h++;
    }
    
    return index;
}

int main() {
    char a[] = "aaa";
    char b[] = "a";
    char *p;

    int index = strStr(a, b);    
    
    printf("a len=%lu b len=%lu\n", strlen(a), strlen(b));
    printf("index %d\n", index);

    p = strstr(a, b);
    printf("a=%p p=%p\n", a, p);

    return 0;
}
