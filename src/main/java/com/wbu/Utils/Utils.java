package com.wbu.Utils;

import java.io.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author shuo.yu2@dxc.com
 * @className Utils
 * @description
 * @date 2023/12/6
 * × @version 1.0
 */
public class Utils {
    // 文件读取缓存大小
    public static final short FILE_READ_BUFFER_SIZE = 16384;

    /**
     * 生成文件的MD5
     * @param filePath 文件路径
     * @return md5字节数组，如果生成失败，返回null
     */
    public static byte[] generateFileMD5(File filePath) {
        // 定义要加密文件每次io的读取数、读取的缓存buffer、MD5加密类
        int length;
        byte[] bytes = new byte[FILE_READ_BUFFER_SIZE];
        MessageDigest md5;
        // 每次从文件中读取一部分内容，读取完毕后,更新MD5工具进行再计算
        try (var inputStream = new BufferedInputStream(new FileInputStream(filePath))){
            md5 = MessageDigest.getInstance("MD5");
            // 读取文件内容，并更新MD5工具的计算，直到文件读取完毕为止
            while ((length = inputStream.read(bytes)) > 0) {
                md5.update(bytes, 0, length);
            }
            // 返回MD5工具计算的结果
            return md5.digest();
        } catch (NoSuchAlgorithmException | IOException e) {
            System.out.println("生成文件MD5时发生错误！");
        }

        return null;
    }
}
