package com.bean;

import java.io.File;
public class FileInfo {
	private File doc; //��װ�ϴ��ļ�������
	private String docFileName; //��װ�ϴ��ļ�����������
	private String docContentType; //��װ�ϴ��ļ�����������
	private String targetdir; //����·��
	private String targetfilename; //������ļ���
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
