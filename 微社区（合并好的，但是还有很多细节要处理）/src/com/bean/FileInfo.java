package com.bean;

import java.io.File;
public class FileInfo {
	private File doc; //封装上传文件的属性
	private String docFileName; //封装上传文件的名称属性
	private String docContentType; //封装上传文件的类型属性
	private String targetdir; //保存路径
	private String targetfilename; //保存的文件名
	public File getDoc() {
		return doc;
	}
	public void setDoc(File doc) {
		this.doc = doc;
	}
	public String getDocContentType() {
		return docContentType;
	}
	public void setDocContentType(String docContentType) {
		this.docContentType = docContentType;
	}
	public String getDocFileName() {
		return docFileName;
	}
	public void setDocFileName(String docFileName) {
		this.docFileName = docFileName;
	}
	public String getTargetdir() {
		return targetdir;
	}
	public void setTargetdir(String targetdir) {
		this.targetdir = targetdir;
	}
	public String getTargetfilename() {
		return targetfilename;
	}
	public void setTargetfilename(String targetfilename) {
		this.targetfilename = targetfilename;
	}
}
