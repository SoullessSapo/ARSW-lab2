## 🧪 Pruebas unitarias

Se desarrollaron pruebas unitarias con **JUnit 5** para verificar el funcionamiento correcto del conteo de líneas físicas y lógicas usando archivos temporales.

### Archivos de prueba: `LineCounterTest.java`

Ubicación:  
`src/test/java/org/example/linecounter/LineCounterTest.java`

### Cobertura de pruebas:

| Test                               | Propósito                                                            |
|------------------------------------|----------------------------------------------------------------------|
| `testCountPhysicalLines()`         | Verifica que cuente todas las líneas (incluyendo comentarios y vacías). |
| `testCountLogicalLines()`          | Verifica que cuente solo líneas de código reales.                   |
| `testEmptyFile()`                  | Verifica que un archivo vacío retorne 0 líneas.                     |
| `testCommentsOnly()`               | Verifica que comentarios y líneas vacías no se cuenten como LOC.    |

### Ejecución de las pruebas

Desde IntelliJ:
- Haz clic derecho en la clase `LineCounterTest` → **Run 'LineCounterTest'**

Desde consola:

```bash
mvn test
[INFO] -------------------------------------------------------
[INFO]  T E S T S
[INFO] -------------------------------------------------------
[INFO] Running org.example.linecounter.LineCounterTest
[INFO] Tests run: 4, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.237 s - in org.example.linecounter.LineCounterTest
[INFO] 
[INFO] BUILD SUCCESS
