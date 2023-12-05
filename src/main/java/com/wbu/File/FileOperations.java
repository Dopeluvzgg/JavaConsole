package com.wbu.File;

import com.wbu.definition.Operation;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.wbu.Utils.Const.*;

/**
 * @author shuo.yu2@dxc.com
 * @className FileOperations
 * @description
 * @date 2023/12/4
 * × @version 1.0
 */
public class FileOperations implements Operation {

    private int matchFileCount;

    @Override
    public void printOperation(Scanner scanner, short index) {
        System.out.print("\033[H\033[2J");
        System.out.println("=================================");
        System.out.println("======欢迎使用文件操作小工具=========");
        System.out.println("=======请输入相应数字使用===========");
        System.out.println("===========1.文件查找=============");
        System.out.println("===========2.文件编码转换==========");
        System.out.println("=================================");

        if (index == 0)
            index = Short.parseShort(scanner.next());
        String fileName;
        String directoryName;

        switch (index) {
            case OPERATION_FIND_FILE:
                // 初始化相似文件的个数统计
                matchFileCount = 0;
                // 获取要查找的目录和文件名
                 directoryName = scanner.next();
                fileName = scanner.next();
                // 检查用户输入，并在要求目录里查找目标文件
                while (!findFile(directoryName, fileName)) {
                    directoryName = scanner.next();
                    fileName = scanner.next();
                }
                // 统计找到相似的文件个数
                if (matchFileCount == 0)
                    System.out.println("没有找到目标文件！");
                break;
            case OPERATION_FILE_TRANSFER_ENCODE:
                // 获取要转换编码的文件名和要转换的编码格式
                fileName = scanner.next();
                String fromEncode = scanner.next();
                String toEncode = scanner.next();
                // 执行编码转换
                while (!transferEncode(fileName, fromEncode, toEncode)) {
                    fileName = scanner.next();
                    fromEncode = scanner.next();
                    toEncode = scanner.next();
                }
                break;
            case OPERATION_DELETE_DUPLICATE_FILE:
                directoryName = scanner.next();
                while (!deleteDuplicateFile(directoryName)) {
                    directoryName = scanner.next();
                }
                break;
        }
    }

    /**
     * 在所给目录里查找用户想查找的文件
     * @param directoryName 想查找文件的目录路径
     * @param fileName 要查找的文件名
     * @return 是否执行成功，如果目录有效，没有找到目标文件也算执行成功
     */
    private boolean findFile(String directoryName, String fileName) {
        File directory = new File(directoryName);
        // 如果目录存在而且有读取权限，并且用户提供的是目录的名称，
        if (directory.exists() && directory.isDirectory() && directory.canRead()) {
            // 获取该目录下所有的项目，包括文件名和目录名
            for (String name: Objects.requireNonNull(directory.list())) {
                // 为每个项目构建绝对路径
                File file = new File(directoryName + "\\" + name);
                // 如果该项目也是目录，继续进入该目录查找目标文件
                if (file.isDirectory() && file.canRead()) {
                    findFile(file.getAbsolutePath(), fileName);
                }
                // 如果该项目是文件，则检查是不是满足要查找的文件
                if (file.isFile() && name.contains(fileName)) {
                    System.out.println("找到了一个相似文件，文件所在路径：" + file.getAbsolutePath());
                    matchFileCount++;
                }
            }
        } else {
            System.out.println("没有该目录，请重新输入");
            return false;
        }
        return true;
    }

    /**
     * @param fileName 要转换编码的文件名
     * @param fromEncode 文件原本的编码格式
     * @param toEncode 要转换的编码格式
     * @return 是否执行成功
     */
    private boolean transferEncode(String fileName, String fromEncode, String toEncode) {
        boolean handleFlag;
        // 获取指定文件
        File file = new File(fileName);

        if (file.exists()) {
            int readLen;
            byte[] bytes = new byte[1024];
            int dotIndex = file.getName().indexOf(".");

            File tempFile = null;
            FileInputStream fileInputStream = null;
            FileOutputStream fileOutputStream = null;

            try {
                // 打开io流
                tempFile = File.createTempFile("transfer", null);
                fileInputStream = new FileInputStream(file);
                fileOutputStream = new FileOutputStream(tempFile);
                // 从目标文件读取一定字节转换成用户要求的编码格式后写入临时文件
                while ((readLen = fileInputStream.read(bytes)) > 0) {
                    // 将读取到的字节写入到转换后的文件
                    String transferString = new String(bytes, 0, readLen,fromEncode);
                    System.out.println(new String(transferString.getBytes(toEncode)));
                    fileOutputStream.write(transferString.getBytes(toEncode));
                }
                handleFlag = true;
                System.out.println("生成的临时文件的路径为：" + tempFile.getAbsolutePath());
            } catch (FileNotFoundException e) {
                System.out.println("没找到文件！");
                handleFlag = false;
            } catch (IOException e) {
                System.out.println("文件转换异常！");
                handleFlag = false;
            } finally {
                // 关闭io流
                try {
                    if (tempFile != null) {
                        tempFile.deleteOnExit();
                    }
                    if (fileInputStream != null) {
                        fileInputStream.close();
                    }
                    if (fileOutputStream != null) {
                        fileOutputStream.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return handleFlag;
        }

        System.out.println("没找到文件！");
        return false;
    }

    public boolean deleteDuplicateFile(String directoryName) {
        File directory = new File(directoryName);
        ArrayList<File> fileList = new ArrayList<>();
        if (directory.exists() && directory.isDirectory()) {
            String[] files = directory.list();
            if (files != null) {
                Arrays.stream(files).forEach(file -> fileList.add(new File(file)));
            }
        }
        else {
            System.out.println("该目录不存在！");
            return false;
        }
        return true;
    }
}
