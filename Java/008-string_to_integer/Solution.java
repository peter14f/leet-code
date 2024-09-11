
public class Solution {

public int myAtoi(String s) {
        
        int result = 0;
        boolean negateResult = false;
        boolean whiteSpaceOkay = true;
        boolean leadingSignOkay = true;
        boolean overflowed = false;


        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (isWhiteSpace(c)) {
                if (!whiteSpaceOkay) {
                    break;
                }
            } else {
                whiteSpaceOkay = false;

                if (isSign(c)) {
                    if (!leadingSignOkay) {
                        break;
                    }

                    leadingSignOkay = false;

                    if (c == '-') {
                        negateResult = true;
                    }
                } else {
                    leadingSignOkay = false;

                    if (isDigit(c)) {
                        int digit = parseDigit(c);
                        int multiplied = result * 10;

                        if (multiplied / 10 != result) {
                            overflowed = true;
                        }

                        int newResult = multiplied + digit;

                        if (newResult < result) {
                            overflowed = true;
                        }

                        result = newResult;
                    } else {
                        // not a digit, not a space, not a sign
                        break;
                    }
                }
            }
        }

        return getResult(result, negateResult, overflowed);
    }

    private int parseDigit(char c) {
        switch (c) {
            case '0': return 0;
            case '1': return 1;
            case '2': return 2;
            case '3': return 3;
            case '4': return 4;
            case '5': return 5;
            case '6': return 6;
            case '7': return 7;
            case '8': return 8;
            case '9': return 9;
            default: return 0;
        }
    }

    private boolean isWhiteSpace(char c) {
        return c == ' ';
    }

    private boolean isSign(char c) {
        return c == '+' || c == '-';
    }

    private boolean isDigit(char c) {
        return c >= '0' && c <= '9';
    }

    private int getResult(int result, boolean negate, boolean overflowed) {
        if (negate) {
            if (overflowed) return Integer.MIN_VALUE;
            return -result;
        } else {
            if (overflowed) return Integer.MAX_VALUE;
            return result;
        }
    }

}
