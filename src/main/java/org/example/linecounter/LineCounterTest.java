package org.example.linecounter;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

class LineCounterTest {

    private Path createTempFile(String content) throws IOException {
        Path tempFile = Files.createTempFile("TempTest", ".java");
        Files.writeString(tempFile, content);
        return tempFile;
    }

    @Test
    void testCountPhysicalLines() throws IOException {
        String code = """
                // Comentario
                public class Hola {
                    public static void main(String[] args) {
                        System.out.println("Hola");
                    }
                }
                """;
        Path file = createTempFile(code);
        int result = LineCounter.countPhysicalLines(file);
        assertEquals(6, result);
    }

    @Test
    void testCountLogicalLines() throws IOException {
        String code = """
                // Comentario
                                
                public class Hola {
                    public static void main(String[] args) {
                        System.out.println("Hola");
                    }
                }
                """;
        Path file = createTempFile(code);
        int result = LineCounter.countLogicalLines(file);
        assertEquals(4, result); // Solo cuenta las líneas con código
    }

    @Test
    void testEmptyFile() throws IOException {
        Path file = createTempFile("");
        assertEquals(0, LineCounter.countPhysicalLines(file));
        assertEquals(0, LineCounter.countLogicalLines(file));
    }

    @Test
    void testCommentsOnly() throws IOException {
        String code = """
                // comentario
                /* bloque */
                *
                */
                """;
        Path file = createTempFile(code);
        assertEquals(4, LineCounter.countPhysicalLines(file));
        assertEquals(0, LineCounter.countLogicalLines(file));
    }
}
