package com.example.calculator;

public class ExpressionEvaluator {

    private final static String sinS = "s";
    private final static String cosS = "c";
    private final static String tanS = "t";
    private final static String sinInverseS = "q";
    private final static String cosInverseS = "w";
    private final static String coTanS = "e";
    private final static String remainderS = "r";


    private static boolean isDigit(int character) {
        return ((character >= '0' && character <= '9') || character == '.');
    }

    private static boolean isFunction(int character) {
        return character >= 'a' && character <= 'z';
    }

    public static double evaluate(final String expression) throws Exception {
        return new Object() {
            int character, position = -1;
            double resolveFactor() {
                if (readerC('+')) return resolveFactor();
                if (readerC('-')) return -resolveFactor();

                double valueF;
                int startPosition = this.position;
                if (readerC('(')) { // parentheses
                    valueF = resolveExpression();
                    readerC(')');
                } else if (isDigit(character)) { // numbers
                    while (isDigit(character)) nextCharacter();
                    valueF = Double.parseDouble(expression.substring(startPosition, this.position));
                } else if (isFunction(character)) { // functions
                    while (isFunction(character)) nextCharacter();
                    String func = expression.substring(startPosition, this.position);
                    valueF = resolveFactor();
                    if (func.equals("sqrt")) valueF = Math.sqrt(valueF);
                    else if (func.equals(sinS)) valueF = Math.sin(Math.toRadians(valueF));

                    else {
                        //return 0 if the user enters 90 degrees for cosine
                        double cosVal = valueF == 90 ? 0 : Math.cos(Math.toRadians(valueF));
                        if (func.equals(cosS)) valueF = cosVal;
                            //return infinity if user enters 90 degrees for tan value
                        else if (func.equals(tanS))
                            valueF = valueF == 90 ? Double.POSITIVE_INFINITY : Math.tan(Math.toRadians(valueF));
                        else if (func.equals(sinInverseS)) valueF = Math.toDegrees(Math.asin(valueF));
                        else if (func.equals(cosInverseS)) valueF = Math.toDegrees(Math.acos(valueF));
                        else if (func.equals(coTanS)) valueF = cosVal / Math.sin(Math.toRadians(valueF));
                        else throw new RuntimeException("Unknown function");
                    }
                } else {
                    throw new RuntimeException("Unexpected character");
                }
                return valueF;
            }

            void nextCharacter() {
                character = (++position < expression.length()) ? expression.charAt(position) : -1;
            }

            double resolve() {
                nextCharacter();
                double x = resolveExpression();
                if (position < expression.length()) throw new RuntimeException("Unexpected character");
                return x;
            }

            double resolveExpression() {
                double x = resolveTerm();
                for (; ; ) {
                    if (readerC('+')) x += resolveTerm();
                    else if (readerC('-')) x -= resolveTerm();
                    else return x;
                }
            }

            double resolveTerm() {
                double x = resolveFactor();
                for (; ; ) {
                    if (readerC('*')) x *= resolveFactor();
                    else if (readerC('/')) x /= resolveFactor();
                    else if (readerC('r')) x %= resolveFactor();
                    else return x;
                }
            }

            boolean readerC(int charToRead) {
                while (character == ' ') nextCharacter();
                if (character == charToRead) {
                    nextCharacter();
                    return true;
                }
                return false;
            }
        }.resolve();
    }


}
