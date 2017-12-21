package com.cp.utils;

import java.io.*;

/**
 * Created by 熊康 on 2017/12/9.
 */
public class FileUtils {
    /**
     * 将指定文件转成字节数组
     * @param file
     * @return byte[]
     */
    public static byte[] fileToBytes(File file) {
        InputStream inputStream = null;
        try {
            inputStream = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        byte[] b = new byte[(int) file.length()];
        try {
            inputStream.read(b);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return b;
    }
}
