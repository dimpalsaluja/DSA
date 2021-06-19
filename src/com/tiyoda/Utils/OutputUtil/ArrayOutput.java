package com.tiyoda.Utils.OutputUtil;

import java.util.ArrayList;

public class ArrayOutput extends Output {
    public static void printArray(int[] arr) {
        for(int ele: arr) {
            printObject(ele);
        }
        printLine();
    }

    public static <K> void printArrayList(ArrayList<K> list) {
        for(K ele : list)
            printObject(ele);
        printLine();
    }

}
