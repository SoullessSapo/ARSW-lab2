package org.example.linecounter;

import java.io.IOException;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;

public class LineCounter {

    public static List<Path> collectJavaFiles(Path path) throws IOException {
        List<Path> javaFiles = new ArrayList<>();
        if (Files.isDirectory(path)) {
            Files.walk(path)
                    .filter(p -> p.toString().endsWith(".java"))
                    .forEach(javaFiles::add);
        } else {
            if (path.toString().endsWith(".java")) {
                javaFiles.add(path);
            }
        }
        return javaFiles;
    }

    public static int countPhysicalLines(Path path) throws IOException {
        return (int) Files.lines(path).count();
    }

    public static int countLogicalLines(Path path) throws IOException {
        return (int) Files.lines(path)
                .map(String::trim)
                .filter(line -> !line.isEmpty())
                .filter(line -> !line.startsWith("//"))
                .filter(line -> !line.startsWith("/*") && !line.startsWith("*") && !line.startsWith("*/"))
                .count();
    }
}
