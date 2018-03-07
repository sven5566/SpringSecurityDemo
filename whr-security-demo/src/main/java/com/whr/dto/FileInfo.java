package com.whr.dto;

public class FileInfo {
	private String filePath;

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public FileInfo(String filePath) {
		super();
		this.filePath = filePath;
	}
}
