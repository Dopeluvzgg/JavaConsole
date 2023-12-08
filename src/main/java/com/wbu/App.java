package com.wbu;

import com.wbu.File.FileOperations;

import java.util.InputMismatchException;
import java.util.Scanner;

import static com.wbu.definition.Const.*;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        short index = -1;
        Scanner scanner = new Scanner(System.in);
        FileOperations fileOperations = null;

        while (index != JAVA_CONSOLE_OPERATION_CANCEL) {
            try {
                System.out.print("\033[H\033[2J");
                System.out.flush();
                System.out.println("===============================");
                System.out.println("======欢迎使用javase控制台========");
                System.out.println("=======请输入相应数字使用==========");
                System.out.println("==========0.退出控制台===========");
                System.out.println("==========1.文件处理=============");
                System.out.println("================================");
                // 获取用户要进行的操作
                index = scanner.nextShort();
            } catch (InputMismatchException e) {
                System.out.println("没有识别到您想进行的操作，请重新输入！");
            }

            switch (index) {
                case JAVA_CONSOLE_OPERATION_CANCEL:
                    break;
                case JAVA_CONSOLE_OPERATION_FILE:
                    if (fileOperations == null)
                        fileOperations = new FileOperations();
                    fileOperations.printOperation(scanner, (short)0);
                    break;
            }
        }


    }
}
