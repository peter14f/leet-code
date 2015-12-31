#include <stdlib.h>
#include <string.h>
#include <stdio.h>

void reverseWords(char *s);
void reverseString(char *s);
void reverseEachWordInString(char *s);

int main() {
  char a[] = "the      is  a   bbb";

  reverseWords(a);
  printf("%s\n", a);

  return 0;
}

void reverseWords(char *s) {
  char *p;
  int spaces = 0;
  int length = 0;
  int i = 0;
  int j = 0;

  if (s==NULL || *s=='\0') {
    return;
  }

  p = s + strlen(s) - 1;

  while (*p == ' ') {
    *p = '\0';
    p--;
  }

  length = strlen(s);
  p = s;

  while (*p == ' ') {
    spaces++;
    p++;
  }
  
  for (i=0; i<length; i++) {
    s[i] = s[i+spaces];
  }
  
  length = length - spaces;

  reverseString(s);
  reverseEachWordInString(s);
  
  for (i=0; i<length; i++) {
    if (s[i] == ' ') {
      int m = 0;
      
      for (j=i+1; j<length; j++) {
        if (s[j] == ' ' ) {
          m++;
        }
        else {
          break;
        }
      }

      printf("m=%d\n", m);
      
      if (m > 0) {
        int z = i+1;
        for (; j<=length; j++) {
          s[z] = s[j];
          z++;
        }
        length = length - m;
      }
    }
  }
}

void reverseEachWordInString(char *s) {
  int i, j, k;
  int length = strlen(s);

  i=0;
  j=0;
  k=0;

  while (s[j] != '\0') {
    if (s[j] != ' ') {
      j++;
    }
    else {
      k=j-1;

      while (k > i) {
        char temp = s[k];
        s[k] = s[i];
        s[i] = temp;
        k--;
        i++;
      }
      j = j + 1;
      i = j;
      k = j;
    }
  }

  if (s[j] == '\0') {
    k=j-1;

    while (k > i) {
      char temp = s[k];
      s[k] = s[i];
      s[i] = temp;
      k--;
      i++;
    }
  }
}

void reverseString(char * s) {
  char *f = s;
  char *b = s + strlen(s) - 1;

  while (b >= f) {
    char temp = *f;
    *f = *b;
    *b = temp;
    f++;
    b--;
  }
}

