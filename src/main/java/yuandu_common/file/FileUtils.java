package yuandu_common.file;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.*;

/**
 * 文件处理工具类
 *
 * @author caozj
 */
public class FileUtils {

	/**
	 * 创建目录
	 *
	 * @param filePath
	 *            - 源文件(可以是文件,也可以是目录)
	 */
	public static void mkdirs(String filePath) {
		if (StringUtils.isBlank(filePath)) {
			return;
		}
		if (filePath.indexOf(".") != -1) {// 可能是文件
			filePath = filePath.substring(0, filePath.lastIndexOf("/"));
		}
		File file = new File(filePath);
		if (!file.exists()) {
			file.mkdirs();
		}
	}

	/**
	 * copy文件 1. 请确认目标文件所在目录是否存在 2. 请确认当前用户是否有写权限
	 *
	 * @param inPath
	 *            - 源文件(绝对路径)
	 * @param outPath
	 *            - 目标文件
	 */
	public static void copy(String inPath, String outPath) {
		InputStream is = null;
		OutputStream os = null;
		try {
			is = new FileInputStream(new File(inPath));
			os = new FileOutputStream(new File(outPath));
			IOUtils.copy(is, os);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			IOUtils.closeQuietly(is);
			IOUtils.closeQuietly(os);
		}
	}

	/**
	 * copy文件 1. 请确认目标文件所在目录是否存在 2. 请确认当前用户是否有写权限
	 *
	 * @param inFile
	 *            - 源文件
	 * @param outPath
	 *            - 目标文件
	 */
	public static void copy(File inFile, String outPath) {
		InputStream is = null;
		OutputStream os = null;
		try {
			is = new FileInputStream(inFile);
			os = new FileOutputStream(new File(outPath));
			IOUtils.copy(is, os);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			IOUtils.closeQuietly(is);
			IOUtils.closeQuietly(os);
		}
	}

	/**
	 * copy文件 1. 请确认目标文件所在目录是否存在 2. 请确认当前用户是否有写权限
	 *
	 * @param is
	 *            - 源文件流
	 * @param outPath
	 *            - 目标文件
	 */
	public static void copy(InputStream is, String outPath) {
		OutputStream os = null;
		try {
			os = new FileOutputStream(new File(outPath));
			IOUtils.copy(is, os);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			IOUtils.closeQuietly(is);
			IOUtils.closeQuietly(os);
		}
	}

	/**
	 * 获取文件的扩展名
	 *
	 * @param fileName
	 *            文件名
	 * @return
	 */
	public static String getFileExt(String fileName) {
		int index = fileName.lastIndexOf(".");
		String ext = StringUtils.EMPTY;
		if (index > -1) {
			ext = fileName.substring(index + 1);
		}
		return ext;
	}

}
