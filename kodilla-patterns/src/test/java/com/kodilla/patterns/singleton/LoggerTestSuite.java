package com.kodilla.patterns.singleton;

import org.junit.*;

public class LoggerTestSuite {

    @Test
    public void testGetLastLog() {
        //Given
        String logOne = "Start my first log";
        String logSecond = "Start my second log";
        Logger.getInstance().log(logOne);
        Logger.getInstance().log(logSecond);

        //When
        String lastLog = Logger.getInstance().getLastLog();
        System.out.println("Last log: " + lastLog);

        //Then
        Assert.assertEquals(logSecond, lastLog);
    }
}
