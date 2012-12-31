package com.action;

import org.apache.struts2.ServletActionContext;
import org.hns.bean.User;
import org.hns.user.dao.UserHibDao;

import com.bean.FileInfo;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import com.opensymphony.xwork2.ActionSupport;

/**
 * �����ļ��ϴ���Action��
 * 
 * @skyqiang
 * @version1.0
 */
public class FileUploadAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static final int BUFFER_SIZE = 16 * 1024;
	// �ļ�����

	// �ϴ��ļ������
	FileInfo fileInfo = new FileInfo();
	private File upload;

	// �ϴ��ļ���
	private String uploadFileName;
	// �ϴ��ļ�����
	private String uploadContentType;
	// �����ļ���Ŀ¼·��(ͨ������ע��)
	private String savePath;

	// ����ʡ��getter��setter......
	// �Լ���װ��һ����Դ�ļ������Ƴ�Ŀ���ļ�����
	public void setUpload(File upload) {
		this.upload = upload;
	}

	public FileInfo getFileInfo() {
		return fileInfo;
	}

	public void setFileInfo(FileInfo fileInfo) {
		this.fileInfo = fileInfo;
	}

	public void setUploadContentType(String uploadContentType) {
		this.uploadContentType = uploadContentType;
	}

	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}

	public void setSavePath(String savePath) {
		this.savePath = savePath;
	}

	public File getUpload() {
		return upload;
	}

	public String getUploadFileName() {
		return uploadFileName;
	}

	public String getSavePath() {
		return savePath;
	}

	public String getUploadContentType() {
		return uploadContentType;
	}

	private static void copy(File src, File dst) {
		InputStream in = null;
		OutputStream out = null;
		try {
			in = new BufferedInputStream(new FileInputStream(src), BUFFER_SIZE);
			out = new BufferedOutputStream(new FileOutputStream(dst),
					BUFFER_SIZE);
			byte[] buffer = new byte[BUFFER_SIZE];
			int len = 0;
			while ((len = in.read(buffer)) > 0) {
				out.write(buffer, 0, len);
				System.out.println("�ϴ�1");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (null != in) {
				try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (null != out) {
				try {
					out.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	private synchronized String generateFileName(String filename) {
		int position = filename.lastIndexOf(".");
		String ext = filename.substring(position);
		return System.nanoTime() + ext;
	}

	public String execute() throws Exception {
		// ���ݷ��������ļ������ַ��ԭ�ļ�������Ŀ¼�ļ�ȫ·��
		// String dstPath = ServletActionContext.getServletContext()
		// .getRealPath(this.getSavePath())
		// + "\\" + this.getUploadFileName();
		String currentFileName = generateFileName(this.getUploadFileName());
		String dstPath = ServletActionContext.getRequest().getRealPath(
				"/upload")
				+ "\\" + currentFileName;
		// String dstPath1 =
		// "E://CTCommunity3.3//CTCommunity-sprint3.1//WebContent//upload//" +
		// currentFileName;
		fileInfo.setDoc(this.upload);
		fileInfo.setDocFileName(this.uploadFileName);
		fileInfo.setDocContentType(this.uploadContentType);
		fileInfo.setTargetdir(ServletActionContext.getRequest().getRealPath(
				"/upload")
				+ "\\");
		fileInfo.setTargetfilename(currentFileName);
		System.out.println("�ϴ����ļ������ͣ�" + this.getUploadContentType());

		File dstFile = new File(dstPath);
		// File dstFile1 = new File(dstPath1);
		copy(this.upload, dstFile);
		// copy(this.upload, dstFile1);

		/*
		 * int userid =
		 * Integer.parseInt(ServletActionContext.getRequest().getSession
		 * ().getAttribute("userid").toString()); User user =
		 * UserHibDao.getuser(userid); user.setPicpath(dstPath);
		 * System.out.println(user.getPicpath());
		 * System.out.println(user.getUsername()); UserHibDao.update(user);
		 * System.out.println("save picture");
		 */

		return "success";
	}
}
