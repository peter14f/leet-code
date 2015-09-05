#include <stdlib.h>
#include <stdio.h>
#include <string.h>

#define boolean unsigned char
#define TRUE 1
#define FALSE 0 

/* TC154 "" 0
 *
 *
 */


int myAtoi(char *str);
boolean is_blank_char(char c);
char is_number(char c);

int myAtoi(char *str) {

  int ans = 0;
  boolean check_blank = TRUE;
  boolean check_sign = TRUE;
  boolean negative = FALSE;
  boolean overflow = FALSE;

  int i = 0;

  while (*str != '\0') {
    if (check_blank) {
      if (!is_blank_char(*str)) {
        check_blank = FALSE;
        continue;
      }
    }
    else if (check_sign) {
      if (*str == '+') {
        check_sign = FALSE;
        str++;
        i++;
      }
      else if (*str == '-') {
        negative = TRUE;
        check_sign = FALSE;
        str++;
        i++;
      }
      else {
        check_sign = FALSE;
      }
      continue;
    }
    else {
      char num = is_number(*str);

      printf("  num %d\n", num);

      if (num == -1) {
        break;
      }
      else {
        int new_ans_multiply = ans * 10;
        if (new_ans_multiply / 10 != ans) {
          overflow = TRUE;
        }
        int new_ans_sum = new_ans_multiply + num;
        if (new_ans_sum < new_ans_multiply) {
          overflow = TRUE;
        }
        ans = new_ans_sum;
      }
    }
    str++; 
    i++;
  }

  if (negative) {
    ans = -ans;
    if (overflow) {
      ans = 0x80000000;
    }
  }
  else {
    if (overflow) {
      ans = 0x7FFFFFFF;
    }
  }

  return ans;
}

boolean is_blank_char(char c) {
  switch (c) {
    case 9:
    case 10:
    case 11:
    case 12:
    case 13:
    case 32:
      return TRUE;

    default:
      return FALSE;
  }
}

char is_number(char c) {
  switch (c) {
    case '0':
      return 0;
    case '1':
      return 1;
    case '2':
      return 2;
    case '3':
      return 3;
    case '4':
      return 4;
    case '5':
      return 5;
    case '6':
      return 6;
    case '7':
      return 7;
    case '8':
      return 8;
    case '9':
      return 9;
    default:
      return -1;
  }
}

int main() {
  char a[100] = "G +9";

  int max_int = 0x7FFFFFFF;
  printf("max int = %d\n", max_int);

  unsigned char i = 1;
  for (i=1; i<128; i++) {
    a[0] = i;
    if (atoi(a) == 9) {
      printf("ans=%d\n", i);
    }
  }
  int x = atoi(a);

  /* strcpy(a, "2147483648");*/
  a[0] = '\0';
  x = atoi(a);
  printf("atoi: %d\n", x);
  x = myAtoi(a);
  printf("myAtoi: %d\n", x);
  return 0;
}
