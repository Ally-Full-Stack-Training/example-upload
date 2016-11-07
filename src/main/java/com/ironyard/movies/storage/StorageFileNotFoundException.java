package com.ironyard.movies.storage;
/**
 * Example taken from: https://github.com/spring-guides/gs-uploading-files.git
 */
public class StorageFileNotFoundException extends StorageException {

    public StorageFileNotFoundException(String message) {
        super(message);
    }

    public StorageFileNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}