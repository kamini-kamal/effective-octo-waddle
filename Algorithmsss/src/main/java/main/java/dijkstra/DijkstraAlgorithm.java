import java.util.List;



class Result {

    /*
     * Complete the 'findMaxProducts' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts INTEGER_ARRAY products as parameter.
     */

    public static long findMaxProducts(List<Integer> products) {
        // Write your code here


        int[][] matrix = new int[products.size()][products.size()];
        int cursor = 0;
        int maxSum = 0;
        if(products.get(1)>products.get(0)){
            cursor=1;
            maxSum = products.get(1);
        } else {
            cursor=0;
            maxSum = products.get(0);
        }
        for(int i=0;i<products.size();i++){
            matrix[i][0] = Math.max(products.get(i), products.get(0));
            for(int j=0;j<products.size();j++){
                matrix[0][j] = Math.max(products.get(0), products.get(j));
            }
        }

        for(int i=1;i<products.size();i++){
            int maxSoFar = 0;
            for(int j=1;j<products.size();j++){

                if(products.get(j)>products.get(i)){

                    cursor = j;
                }
                if(cursor == j && products.get(j)>products.get(i)){
                    maxSoFar = products.get(j);
                } else {
                    if(products.get(j)<products.get(i)){
                        int remove = maxSoFar - products.get(j);
                        maxSoFar = products.get(j) + remove;

                    }
                }

            }
            maxSum = Math.max(maxSum, maxSoFar);
        }
        return maxSum;
    }

}
//
//public class Solution {
//    public static void main(String[] args) throws IOException {
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
//
//        int productsCount = Integer.parseInt(bufferedReader.readLine().trim());
//
//        List<Integer> products = IntStream.range(0, productsCount).mapToObj(i -> {
//            try {
//                return bufferedReader.readLine().replaceAll("\\s+$", "");
//            } catch (IOException ex) {
//                throw new RuntimeException(ex);
//            }
//        })
//                .map(String::trim)
//                .map(Integer::parseInt)
//                .collect(toList());
//
//        long result = Result.findMaxProducts(products);
//
//        bufferedWriter.write(String.valueOf(result));
//        bufferedWriter.newLine();
//
//        bufferedReader.close();
//        bufferedWriter.close();
//    }
//}
