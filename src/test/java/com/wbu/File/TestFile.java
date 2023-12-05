package com.wbu.File;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.File;
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
//          F:\test
//          operate = 3;
//          operator.printOperation(scanner, operate);
//          boolean flag = operator.deleteDuplicateFile("F:\\test");
     }
}
