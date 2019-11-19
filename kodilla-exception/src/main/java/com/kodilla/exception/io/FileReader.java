package com.kodilla.exception.io;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class FileReader {

    public void readFile() {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("file/names.txt").getFile());
 //        Path path = Paths.get("D:/Jacek/Programy Intellij/Jacek-Binkul-kodilla-java/kodilla-exception/build/resources/main/file/names.txt");
//        String path1 = file.getPath().replaceAll("%20", " ");
//        Path path = Paths.get(file.getPath().replaceAll("%20", " "));
        try (Stream<String> fileLines = Files.lines(Paths.get(file.getPath().replaceAll("%20", " ")))) {
//            Stream<String> fileLines = Files.lines(path);
            fileLines.forEach(System.out::println);
        } catch (IOException ex) {
            System.out.println("Oh no. Something is wrong !!!" + ex);
        } finally {
            System.out.println("I will do it always ...");
        }
    }
}
