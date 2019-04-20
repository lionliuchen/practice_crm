package com.cherry.crm.utils;

import java.util.UUID;

/**
 * 文件上传的工具类
 * @author zhang
 *
 */
public class UploadUtils {
	/**
	 * 解决目录下文件名重复的问题
	 * @param fileName
	 * @return
	 */
	public static String getUuidFileName(String fileName) {
		int idx = fileName.lastIndexOf(".");//aa.txt
		String extions=fileName.substring(idx);
		return UUID.randomUUID().toString().replaceAll("-","")+extions;
	}
	
	/**
	 * 目录分离
	 * @param args
	 */
	public static String getPath(String uuidFileName) {
		int code1 = uuidFileName.hashCode();
		int d1=code1 & 0xf;//作为一级目录
		int code2 = code1>>>4;
		int d2=code2 & 0xf;
		return "/"+d1+"/"+d2;
	}
	
	public static void main(String[] args) {
		System.out.println(getPath("aa.txt"));
	}
}
