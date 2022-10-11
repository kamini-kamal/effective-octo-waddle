//import java.util.ArrayList;
//
//public class FindTargetSum {
//    public static void main(String[] args) {
//        ArrayList<Integer> inputArray = new ArrayList<>();
//        inputArray.add(2);//0
//        inputArray.add(11);//1
//        inputArray.add(15);//2
//        inputArray.add(7);//3
//        int target = 18;
//        ArrayList<Integer> resultArray = new ArrayList<>();
//        findTheTargetIndices(inputArray, target, resultArray);//[index1, index 2]
//
//        String inputString = "abcabcbb";// abc abcdbb, a bcadcbb
//        boolean stop = false;
//        char visited[] = new char[];//abcabcbb
//        while(!stop){
//            int iterator = 0;
//            if(visited.length!=0){
//
////            if(visited[iterator].equals(inputStr.substring(iterator, iterator+1))){
//                if(inputString.matches(String.valueOf(visited[iterator]))){
//                    stop = true;
//                } else {
//                    visited[iterator] = (char)inputString.substring(iterator);
//                }
//            }
//            iterator ++;
//        }
//    }
//
////    Find the longest substring without repeating characters
////    Input: s = “abcabcbb”
////    Output: 3
////    Explanation: The answer is “abc”, with the length of 3.
////    Input: s = “bbbbb”
////    Output: 1
////    boolean stop = false;
////    char visited = new char[]; //abcabcbb
////    while(!stop){
////        int iterator = 0;
////        if(visited.length!=0){
////
//////            if(visited[iterator].equals(inputStr.substring(iterator, iterator+1))){
////            if(inputStr.matches(visited[iterator])){
////                stop = true;
////            } else {
////                visited[iterator] = inputString.substring(iterator, iterator+1);
////            }
////        }
////        iterator ++;
////    }
//
//
//
//    public static  String longestSubstring(String str, int index, int length){//initial 0
//        if(str.length()==1){
//            return str;
//        } else {
//            int pivot = length/2; //abcabcbb
//            //check for the first subString
////            if(str.substring(0, pivot).equalsIgnoreCase(pivot+1, str.length())){
////                longestSubstring()
////            }
//           /// str.mat
//            if(str.substring(index, pivot).equals(str.substring(pivot+1, length-1))){
//                longestSubstring(str.substring(index, pivot), index++, pivot);
//                longestSubstring(str.substring(pivot+1, ), index++, pivot);
//            }
//        }
//   // }
//
//    public static void findTheTargetIndices(ArrayList<Integer> inputArray, int target, ArrayList<Integer> result) {
//
//        for (int i = 0; i < inputArray.size(); i++) {
//            int complement = target - inputArray.get(i);
//            for (int j = i + 1; j < inputArray.size(); j++) {
//                if (inputArray.get(j) == complement) {
//                    result.add(i);
//                    result.add(j);
//                }
//            }
//        }
//        for(int i=0;i<result.size();i++){
//            System.out.println("Element   " + result.get(i));
//        }
//    }
//}
