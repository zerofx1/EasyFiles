package ru.quizie.easyfiles;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class SimpleFileManager implements FileManager {

    @Override
    public File createFileOrGet(Path filePath, String nameFile, Path sourceFilePath) {
        final File dir = filePath.toFile();
        if (!dir.exists()) dir.mkdirs();

        final File file = new File(dir, nameFile);
        try {
            if (!file.exists()) {
                file.createNewFile();

                if (sourceFilePath != null && Files.exists(sourceFilePath))
                    Files.copy(sourceFilePath, file.toPath(), StandardCopyOption.REPLACE_EXISTING);
            }
            return file;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public File createFileOrGet(Path filePath, String nameFile) {
        return createFileOrGet(filePath, nameFile, null);
    }

    @Override
    public boolean removeFile(Path filePath, String nameFile) {
        final File file = new File(filePath.toFile(), nameFile);
        if (file.exists()) return file.delete();
        return false;
    }

    @Override
    public File getFile(Path filePath, String nameFile) {
        final File file = new File(filePath.toFile(), nameFile);
        return file.exists() ? file : null;
    }

    @Override
    public boolean fileExists(Path filePath, String nameFile) {
        final File file = new File(filePath.toFile(), nameFile);
        return file.exists();
    }

}
