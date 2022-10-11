import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class validSubSequenceProblem {
    public static void main(String[] args){
        boolean validate = Program1.validateSequence(Arrays.asList(5, 1, 22, 25, 6, -1, 8, 10), Arrays.asList(1, 6, -1, 10));
        System.out.println("Valid substring::" + validate + " " +Arrays.asList(1, 6, -10, 10).toString());
    }
}

class Program1 {
    public static boolean validateSequence(List<Integer> array, List<Integer> sequence){
        int sequnceNumber = 0;
        for(int val: array){
            if(val == sequence.get(sequnceNumber)){
                sequnceNumber++;
            }
            if(sequnceNumber==sequence.size()){
                break;
            }
        }
        return  sequnceNumber==sequence.size();
    }

    public static String findTournamentWinner(ArrayList<ArrayList<String>> competitions, ArrayList<Integer> results){
        String winner = null;

        return winner;
    }
}
