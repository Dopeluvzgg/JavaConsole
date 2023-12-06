package com.wbu.File;

import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Scanner;

/**
 * @author shuo.yu2@dxc.com
 * @className TestFile
 * @description
 * @date 2023/12/4
 * × @version 1.0
 */
public class TestFile {
     public static Scanner scanner;
     public static FileOperations operator;

     public static short operate;

     @BeforeClass
     public static void before() {
          scanner = new Scanner(System.in);
          operator = new FileOperations();
     }

     @Test
     public void testFindFile() {
          operate = 1;
          operator.printOperation(scanner, operate);
     }

     @Test
     public void testTransferEncode() {
          operate = 2;
          operator.printOperation(scanner, operate);
     }

     @Test
     public void testDeleteDuplicateFile() {
          operate = 3;
          operator.printOperation(scanner, operate);
//          System.out.printf("hashcode: %d\n",Arrays.hashCode(Utils.generateFileMD5(new File("F:\\test - コピー\\炉石 - コピー (7).bat"))));
//          System.out.printf("hashcode: %d\n", Arrays.hashCode(Utils.generateFileMD5(new File("F:\\test - コピー\\炉石 - コピー (5).bat"))));
     }
}
