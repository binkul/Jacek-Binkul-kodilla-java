package com.kodilla.exception.main;

import com.kodilla.exception.io.FileReader;
import com.kodilla.exception.io.FileReaderException;
import com.kodilla.exception.io.FileReaderWithoutHandling;
import com.kodilla.exception.test.ExceptionHandling;

import java.io.IOException;

public class ExceptionModuleRunner {
    public static void main(String[] args) {

        FileReader fileReader = new FileReader();
        try {
            fileReader.readFile();
        } catch (FileReaderException ex) {
            System.out.println("Problem with reading file ...");
        }
/*
        // In FileReaderWithoutHandling we move (via throws IOException) Exception to class, which is using FileReaderWithoutHandling.readFile()
        FileReaderWithoutHandling fileReaderWithoutHandling = new FileReaderWithoutHandling();
        try {
            fileReaderWithoutHandling.readFile();
        } catch (IOException ex) {
            System.out.println("File Error");
        }
*/
/*
        FileReader fileReader = new FileReader();
        fileReader.readFile();
*/
    }

}
