package ru.quizie.easyfiles;

import java.io.File;
import java.nio.file.Path;

/**
 * Легкое API для работы с файлами
 * Базовые функции создания, удаления и получения файлов.
 * @author Quizie / ConderFix
 */
public interface FileManager {

    /**
     * Создает файл или возвращает существующий.
     * Если файл не существует, создает его и копирует содержимое из sourceFilePath
     *
     * @param filePath путь к директории, где находится файл
     * @param nameFile имя файла
     * @param sourceFilePath путь к файлу-источнику для копирования содержимого (может быть null)
     * @return созданный или найденный файл
     */
    File createFileOrGet(Path filePath, String nameFile, Path sourceFilePath);

    /**
     * Создает файл или возвращает существующий (без копирования содержимого)
     *
     * @param filePath путь к директории, где находится файл
     * @param nameFile имя файла
     * @return созданный или найденный файл
     */
    File createFileOrGet(Path filePath, String nameFile);

    /**
     * Удаляет файл
     *
     * @param filePath путь к директории, где находится файл
     * @param nameFile имя файла для удаления
     * @return true если файл был удален, false если файл не существовал
     */
    boolean removeFile(Path filePath, String nameFile);

    /**
     * Получает файл
     *
     * @param filePath путь к директории, где находится файл
     * @param nameFile имя файла
     * @return найденный файл или null если файл не существует
     */
    File getFile(Path filePath, String nameFile);

    /**
     * Проверяет существует ли файл
     *
     * @param filePath путь к директории, где находится файл
     * @param nameFile имя файла
     * @return true если файл существует
     */
    boolean fileExists(Path filePath, String nameFile);
}