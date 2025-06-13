package org.example.linecounter;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class LineCounterApplication {
    public static void main(String[] args) throws IOException {
        if (args.length != 2) {
            System.out.println("Uso: java -jar lineCounter.jar [phy|loc] [archivo|directorio]");
            return;
        }

        String mode = args[0];
        Path path = Paths.get(args[1]);

        List<Path> javaFiles = LineCounter.collectJavaFiles(path);

        int total = 0;
        for (Path file : javaFiles) {
            if ("phy".equals(mode)) {
                total += LineCounter.countPhysicalLines(file);
            } else if ("loc".equals(mode)) {
                total += LineCounter.countLogicalLines(file);
            } else {
                System.out.println("Modo desconocido: " + mode);
                return;
            }
        }

        System.out.println("Total de líneas (" + mode + "): " + total);
    }
}
