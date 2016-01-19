#include <stdio.h>
#include <string.h>

void reverseWords(char *s) {
  int len = 0;
  char *r;
  char *l;
  int spaceCnt = 0;
  int i, j;

  if (s==NULL)
    return;

  len = strlen(s);
  
  if (len==0)
    return; 

  for (i=0; i<len; i++) {
    if (s[i] == ' ')
      spaceCnt++;
  }

  /* contains only one word? */
  if (spaceCnt==0)
    return;

  /* reverse the whole string first */
  l = s;
  r = s+len-1;

  while (r > l) {
    char tmp = *r;
    *r = *l;
    *l = tmp;
    r--;
    l++;
  }

  i = 0;
  j = i+1;

  /* reverse each word */
  while (i < len) {
    if (s[j] == ' ' || s[j] == '\0') {
      l = s+i;
      r = s+j-1;

      while (r > l) {
        char tmp = *r;
        *r = *l;
        *l = tmp;
        r--;
        l++;
      }

      i = j + 1;
      j = i + 1;
    }
    else {
      j++;
    }
  }

}

int main() {
  char a[16] = "the sky is blue";
  reverseWords(a);

  printf("%s\n", a); 

  return 0;
}
