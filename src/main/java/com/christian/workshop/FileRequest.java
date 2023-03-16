package com.christian.workshop;

public class FileRequest {
    private String[] line;
    private String fileType;

    public FileRequest(String[] line, String fileType) {
        this.line = line;
        this.fileType = fileType;
    }

    public String[] getLine() {
        return line;
    }
    public String getFileType() {
        return fileType;
    }

}
