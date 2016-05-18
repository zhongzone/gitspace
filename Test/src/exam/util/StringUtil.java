package exam.util;

import java.security.MessageDigest;

public class StringUtil {
	
	/**
	 * 对字符串进行MD5加密
	 * @return 加密后的MD5密码
	 */
	public static String MD5Encode(String sourceString) {
		String resultString = null;
		try {
			resultString = new String(sourceString);
			MessageDigest md = MessageDigest.getInstance("MD5");
			resultString = byte2hexString(md.digest(resultString.getBytes()));
		} catch (Exception ex) {
		}
		return resultString;
	}

	/**
	 * 将二进制数组转化为十六进制字符串
	 */
	public static final String byte2hexString(byte[] bytes) {
		StringBuffer buf = new StringBuffer(bytes.length * 2);
		for (int i = 0; i < bytes.length; i++) {
			if ((bytes[i] & 0xff) < 0x10) {
				buf.append("0");
			}
			buf.append(Long.toString(bytes[i] & 0xff, 16));
		}
		return buf.toString();
	}

	public static void main(String[] args) {
		System.out.println(MD5Encode("123"));
		System.out.println(byte2hexString("123".getBytes()));
	}
}
