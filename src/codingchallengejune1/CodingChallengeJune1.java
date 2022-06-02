package codingchallengejune1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CodingChallengeJune1
{
    public static void main(String[] args) {

        //reorderDigits(new int[]{515, 341, 98, 44, 211}, "desc");

        //reorderDigits(new int[]{515, 341, 98, 44, 211}, "asc");

        //reorderDigits(new int[]{63251, 78221}, "asc");

        //reorderDigits(new int[]{63251, 78221}, "desc");

        //reorderDigits(new int [] {1, 2, 3, 4}, "asc");

        //reorderDigits(new int [] {1, 2, 3, 4}, "desc");

        //canPartition(new int[]{2, 8, 4, 1});

        //canPartition(new int[]{-1, -10, 1, -2, 20});

        //canPartition(new int[]{-1, -20, 5, -1, -2, 2});

    }

    public static void reorderDigits(int[] array, String order) {

        List<String> orderedArray = new ArrayList<>();

        if (order == "desc") {
            for (int i = 0; i < array.length; i++) {
                    String currentNum = Integer.toString(array[i]);
                    char[] currentNumArr = currentNum.toCharArray();
                    int[] reorderedArray = new int[currentNum.length()];
                    for(int j = 0; j < currentNumArr.length; j ++) {
                        reorderedArray[j] = Integer.parseInt(String.valueOf(currentNumArr[j]));
                        for (int k = 0; k < reorderedArray.length; k++){
                            for(int l = 0 ; l < k; l++) {
                                if(reorderedArray[k] > reorderedArray[l]) {
                                    int newNum =  reorderedArray[k];
                                    reorderedArray[k] =  reorderedArray[l];
                                    reorderedArray[l] = newNum;
                                }
                            }
                        }
                    }

                    StringBuilder stringBuilder = new StringBuilder();
                    for (int j = 0; j < reorderedArray.length; j++){
                        stringBuilder.append(reorderedArray[j]);
                    }

                    orderedArray.add(i, String.valueOf(stringBuilder));

            }

            for (String i : orderedArray){
                System.out.println(i);
            }

            System.out.println(order);

        }

        if (order == "asc") {
            for (int i = 0; i < array.length; i++) {
                String currentNum = Integer.toString(array[i]);
                char[] currentNumArr = currentNum.toCharArray();
                int[] reorderedArray = new int[currentNum.length()];
                for(int j = 0; j < currentNumArr.length; j ++) {
                    reorderedArray[j] = Integer.parseInt(String.valueOf(currentNumArr[j]));
                    for (int k = 0; k < reorderedArray.length - 1; k++)
                    {
                        int index = k;
                        for (int l = k + 1; l < reorderedArray.length; l++){
                            if (reorderedArray[l] < reorderedArray[index]){
                                index = j;
                            }
                        }
                        int newNum = reorderedArray[index];
                        reorderedArray[index] = reorderedArray[k];
                        reorderedArray[k] = newNum;
                    }
                }

                StringBuilder stringBuilder = new StringBuilder();
                for (int j = 0; j < reorderedArray.length; j++){
                    stringBuilder.append(reorderedArray[j]);
                }

                orderedArray.add(i, String.valueOf(stringBuilder));

            }

            for (String i : orderedArray){
                System.out.println(i);
            }

            System.out.println(order);

        }
    }

    public static Boolean canPartition (int[] array) {

        Boolean result = false;

        int arrayLength = array.length;

        if (arrayLength == 1) {
            result = false;
        }

        int array1[] = new int[arrayLength];
        int array2[] = new int[arrayLength];
        int[] productArray = new int[array.length];

        array1[0] = 1;

        array2[arrayLength - 1] = 1;

        for (int i = 1; i < arrayLength; i++) {
            array1[i] = array[i - 1] * array1[i - 1];
        }

        for (int j = arrayLength - 2; j >= 0; j--) {
            array2[j] = array[j + 1] * array2[j + 1];
        }

        for (int i = 0; i < arrayLength; i++) {
            productArray[i] = array1[i] * array2[i];
        }

        for (int i = 0; i < arrayLength; i++){
            System.out.println(productArray[i]);
        }

        for (int i = 0; i < arrayLength; i++){
            for (int j = 0; j < arrayLength; j++){
                if (productArray[i] == array[j]) {
                    result = true;
                }
            }
        }

        System.out.println(result);
        return result;
    }

}