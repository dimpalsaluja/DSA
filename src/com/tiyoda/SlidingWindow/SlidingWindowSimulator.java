package com.tiyoda.SlidingWindow;

import com.tiyoda.Utils.InputUtil.ArrayInput;
import com.tiyoda.Utils.InputUtil.Input;
import com.tiyoda.Utils.OutputUtil.ArrayOutput;
import com.tiyoda.Utils.OutputUtil.Output;
import com.tiyoda.SlidingWindow.FixedSizeSlidingWindow.CountOccurrencesOfAnagrams;
import com.tiyoda.SlidingWindow.FixedSizeSlidingWindow.FirstNegativeNumberInWindowOfSizeK;
import com.tiyoda.SlidingWindow.FixedSizeSlidingWindow.MaximumSumSubArrayOfSizeK;

import java.io.IOException;

public class SlidingWindowSimulator {
    public static void main(String[] args)throws IOException {
        int n = Input.readInteger();
        int[] arr = ArrayInput.readArray();
        int k = Input.readInteger();
        int res = MaximumSumSubArrayOfSizeK.findMaximumSumSubArrayOfGivenSize(arr, n, k);
        ArrayOutput.printArrayList(FirstNegativeNumberInWindowOfSizeK
                .findFirstNegativeNumberInEachWindowOfGivenSize(arr, n, k));
        res = CountOccurrencesOfAnagrams.findCountOfOccurrencesOfAnagrams(Input.readInput(),
                Input.readInput());
        Output.printObject(res);
        Output.printLine();
    }
}
