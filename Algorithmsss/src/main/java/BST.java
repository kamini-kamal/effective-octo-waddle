import java.util.ArrayList;
import java.util.List;

class ProgramBST {
    public static void main(String[] args){
        BST root = new BST(75);
        root.left = new BST(75);
        root.right = new BST(105);

        root.right.left = new BST(90);
        root.right.right = new BST(120);
        root.right.right.right = new BST(135);
        List<Integer> preOrderList = new ArrayList<Integer>();
        preOrderTraverse(root, preOrderList);
        for(int i=0;i<preOrderList.size();i++){
            //System.out.println("element:: " + preOrderList.get(i));
        }
        //int closestNodeValue = findClosestValueInBst(root, 75);
        //System.out.println("closestNodeValue" + closestNodeValue);
    }
    public static List<Integer> preOrderTraverse(BST tree, List<Integer> array) {
        // Write your code here.
        array.add(tree.value);
        if(tree.left!=null){
            preOrderTraverse(tree.left, array);
        }

        if(tree.right!=null){
            preOrderTraverse(tree.right, array);
        }
        return array;
    }
    public static int findClosestValueInBst(BST tree, int target) {
        // Write your code here.
        return findClosestValueInBst(tree, target, tree.value);
        //return closest.value;
    }

    public static int findClosestValueInBst(BST tree, int target, int closest){
        if(Math.abs(target - closest) > Math.abs(target - tree.value)){
            closest = tree.value;
        }
        if(target < tree.value && tree.left!=null){
            return findClosestValueInBst(tree.left, target, closest);
        } else if(target > tree.value && tree.right!=null){
            return findClosestValueInBst(tree.right, target, closest);
        } else {
            return closest;
        }
    }

    static class BST {
        public int value;
        public BST left;
        public BST right;

        public BST(int value) {
            this.value = value;
        }
    }

}

