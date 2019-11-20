package com.kodilla.exception.io;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class FileReader {

    public void readFile() throws FileReaderException {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("file/names.txt").getFile());
        try (Stream<String> fileLines = Files.lines(Paths.get(file.getPath().replaceAll("%20", " ")))) {
            fileLines.forEach(System.out::println);
        } catch (IOException ex) {
            throw new FileReaderException();
        } finally {
            System.out.println("I will do it always ...");
        }
    }
}
