# 📊 LOC Counter - Contador de Líneas de Código en Java

Este proyecto es una herramienta de línea de comandos que permite contar líneas de código fuente en archivos `.java`, ya sea líneas **físicas** o líneas de código reales (excluyendo comentarios y líneas en blanco).

---

## 🛠 Tecnologías utilizadas

- Java 17
- Maven
- Git & GitHub
- JUnit 5 (para pruebas)
- Estilo de código: [Guía de estilo de Google para Java](https://google.github.io/styleguide/javaguide.html)

---

## 🚀 Ejecución del programa

### Requisitos

- Tener instalado Maven y Java 17+
- Tener los archivos `.java` que deseas analizar

### Comando de ejemplo

```bash
mvn compile
mvn exec:java "-Dexec.mainClass=org.example.linecounter.LineCounterApplication" "-Dexec.args=loc src/main/java/org/example/linecounter/LineCounter.java"
