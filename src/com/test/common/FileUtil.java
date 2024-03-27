package com.test.common;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

public class FileUtil {

	/**
	 * 自动生成文件名称
	 * 
	 * @return
	 */
	public static String createFileName() {
		Date date = new Date();
		String fileName = String.valueOf(date.getTime());
		return fileName;
	}

	/**
	 * 上传文件
	 * 
	 * @param file
	 *            上传的文件
	 * @param fileName
	 *            上传文件完整路径
	 * @throws IOException
	 */
	public static void uploadFile(File file, String fileName) throws IOException {
		BufferedInputStream input = null;
		BufferedOutputStream output = null;
		try {
			input = new BufferedInputStream(new FileInputStream(file));
			output = new BufferedOutputStream(new FileOutputStream(fileName));

			byte[] array = new byte[256];
			int count = input.read(array, 0, array.length);
			while (count != -1) {
				output.write(array, 0, count);
				count = input.read(array, 0, array.length);
			}
			output.flush();
		} finally {
			if (input != null) {
				input.close();
			}
			if (output != null) {
				output.close();
			}
		}
	}
}
