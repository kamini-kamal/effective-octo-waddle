

import java.net.URL;
import java.util.*;

public class TwoSumProblem {
    public static void main(String[] args){
        int array[] = new int[]{3, 5, -4, 8, 11, 1, -1, 6};
        int array2[] = new int[]{-5, 3, 2, -3, 1};//{1, 0, 5, 0, 3};//{7, 12, 3, 1, 2, -6, 5, -8, 6};
        int result[] = Program.twoNumberSum(array, 10);
        List<Integer[]> list = Program.threeNumberSum(array2, 0);
        int smallestDiffArray[] = Program.smallestDifferencePair(new int[]{1, 3, 15, 11, 2},  new int[]{23, 127, 235, 19, 8});
        int removeDuplicates = Program.removeDuplicates(new int[]{1, 1, 1, 3, 5, 5, 7});
        System.out.print("[ ");
        //URL url = new URL("https://jsonmock.hackerrank.com/api/food_outlets?city="+"&page=1");
        Arrays.stream(result).forEach((e) -> {
            System.out.print(e + " ");
        });

        System.out.print("]");
        System.out.println("");

        System.out.println("**************** Two sum *****************");

        list.stream().forEach((element) -> {
            System.out.print("[ ");
            Arrays.stream(element).forEach(e -> System.out.print(e + " "));
            System.out.print("]");
            System.out.println();
        });

        System.out.println("**************** Three Sum *****************");

        System.out.print("[ ");
        Arrays.stream(smallestDiffArray).forEach((e) -> {
            System.out.print(e + " ");
        });
        System.out.print("]");
        System.out.println("");

        System.out.println("**************** smallest difference *****************");
        System.out.println("removeDuplicates " + removeDuplicates);

        int sortedSquare[] = Program.sortedSquare(new int[]{-5, -2, -1, 0, 4, 6});
        Arrays.stream(sortedSquare).forEach(e -> {
            System.out.print(e + " ");
        });

    }
}

class Program {
    /* two sum problem
    Sample Input
    array = [3, 5, -4, 8, 11, 1, -1, 6]
    targetSum = 10
*/
    /*
     *  I will use HashMap to solve this problem
     *  1. initialize an empty HashMap
     *  2. iterate through the array and check for the complement in the HashMap
     *  3. If complement is found then push that element and the complement inside the array
     *  4. If complement not found, push the element in the HashMap
     */
    public static int[] twoNumberSum(int[] array, int targetSum){
        Map<Integer, Integer> numMap = new HashMap<>();
        for(int i=0;i< array.length; i++){
            if(numMap.containsKey(targetSum - array[i])){
                return new int[]{targetSum - array[i], array[i]};
            } else {
                numMap.put(array[i], 0);
            }
        }
        //numMap.forEach((k, v) ->    System.out.println(k+" : "+ v));
        return new int[0];
    }
    /* three sum problem
    Sample Input
    array = [7, 12, 3, 1, 2, -6, 5, -8, 6]
    targetSum = 0

    output: [[2, -8, 6], [3, 5, -8], [1, -6, 5]]
*/
    /*
     *  I will use HashSet to solve this problem
     *  1. fix the first element
     *  2. iterate through the array and check for the complement in the HashSet
     *  3. If complement is found then push that element and the complement inside the Set<Integer>
     *  4. If complement not found, push the element in the HashSet
     */
    public static List<Integer[]> threeNumberSum(int[] array, int targetSum){
        List<Integer[]> list =  new ArrayList<>();
        for(int i=0; i<array.length;i++){
            int currentTarget = targetSum - array[i];
            Set<Integer> visitedElements = new HashSet<>();
            for(int j = i; j<array.length;j++){
                if(visitedElements.contains(currentTarget - array[j])){
                    list.add(new Integer[] {array[i], array[j], currentTarget - array[j]});
                } else {
                    visitedElements.add(array[j]);
                }
            }
        }
        return list;
    }

    /* smallest difference pair problem
    Sample Input
    array = [1, 3, 15, 11, 2],  [23, 127, 235, 19, 8]
    output: [11, 8]; this pair has the smallest difference
*/
    /*
    [1, 1, 1, 3, 5, 5, 7]
     */
    public static int[] smallestDifferencePair(int[] array1, int[] array2){
        int result[] = new int[2];
        Arrays.sort(array1); // [1, 2, 3, 11, 15]
        Arrays.sort(array2); // [8, 19, 23, 127, 235]

        double smallestDifference = Double.MAX_VALUE;

        int i=0, j=0;

        while(i<array1.length && j< array2.length){
            double currentDifference = Math.abs(array1[i] - array2[j]);
            if(currentDifference < smallestDifference){
                smallestDifference = currentDifference;
                result[0] = array1[i];
                result[1] = array2[j];
            }
            if(array1[i] < array2[j]){
                i++;
            } else {
                j++;
            }
        }

        return result;
    }

    public static int removeDuplicates(int[] array){
        int j = 0;
        for(int i=0;i<array.length;i++){
            if(i<array.length - 1 && array[i]==array[i+1]){
                continue;
            } else {
                array[j++] = array[i];
            }
        }

        return j;
    }
/**
 * [-5, -2, -1, 0, 4, 6]
 */

    public static int[] sortedSquare(int[] array){
        int sqArr[] = new int[array.length];
        Arrays.sort(array); //(nlogn)
        int left=0, right=array.length-1;
        int n = array.length-1;
        while(left<=right){
            int leftSq = array[left]*array[left];
            int rightSq = array[right]*array[right];
            if(leftSq > rightSq){
                sqArr[n--] = leftSq;
                left++;
            } else {
                sqArr[n--] = rightSq;
                right--;
            }
        }
        return sqArr;
    }



}
