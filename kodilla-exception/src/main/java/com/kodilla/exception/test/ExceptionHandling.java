package com.kodilla.exception.test;

public class ExceptionHandling {

    public void catchSecondChallengeException() {

        String noException = "";
        SecondChallenge secondChallenge = new SecondChallenge();

        try {
            noException = secondChallenge.probablyIWillThrowException(1.5, 1);
        } catch (Exception ex) {
            System.out.println("Catch new exception from method 'probablyIWillThrowException()'");
        } finally {
            if (noException.equals("Done!")) {
                System.out.println("Everything is ok.");
            } else {
                System.out.println("Something is wrong with arguments ...");
            }
        }
    }
}
