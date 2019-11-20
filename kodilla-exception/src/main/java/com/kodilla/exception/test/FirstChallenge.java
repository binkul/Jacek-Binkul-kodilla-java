package com.kodilla.exception.test;

public class FirstChallenge {

    public double divide(double a, double b) throws ArithmeticException {
        if(b == 0){
            throw new ArithmeticException();
        }
        return a / b;
    }

    /**
     * This main can throw an ArithmeticException!!!
     * @param args
     */
    public static void main(String[] args) {

        boolean errorOccur = false;
        FirstChallenge firstChallenge = new FirstChallenge();

        try {
            double result = firstChallenge.divide(3, 0);
            System.out.println(result);
        } catch (ArithmeticException ex) {
            System.out.println("Divide by zero detected. You have to change parameters.");
            System.out.println("Exception description: " + ex);
            errorOccur = true;
        } finally {
            if (errorOccur) {
                System.out.println("The result is unspecified.");
            } else {
                System.out.println("The result is correct.");
            }
        }


    }
}
