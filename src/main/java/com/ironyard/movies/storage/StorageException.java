package com.ironyard.movies.storage;
/**
 * Example taken from: https://github.com/spring-guides/gs-uploading-files.git
 */
public class StorageException extends RuntimeException {

    public StorageException(String message) {
        super(message);
    }

    public StorageException(String message, Throwable cause) {
        super(message, cause);
    }
}
