# EasyFiles
Мега легкое API, которое упрощает создание/удаление файлов. Данная API создана с целью сокращения времени написания одного и того же кода в разных проектах.

# Подключение
```gradle
repositories {
    mavenCentral()
    maven { url 'https://jitpack.io' }
}

dependencies {
    implementation("com.github.zerofx1:EasyFiles:18efca711c")
}
```

# Пример использования
```java
public class Test {

    private static final FileManager FILE_MANAGER = new SimpleFileManager();

    public static void main(String[] args) {
        final Path projectPath = Path.of("C:/projects/EasyFiles");
        final File myFile = FILE_MANAGER.createFileOrGet(projectPath, "test.yml");

        System.out.println("File name: " + myFile.getName());
    }
}
```
