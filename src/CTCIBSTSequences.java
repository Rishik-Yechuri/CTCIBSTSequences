import java.util.ArrayList;

public class CTCIBSTSequences {
    public static void main(String[] args) {
        try{
            CTCIBSTSequences obj = new CTCIBSTSequences();
            obj.run(args);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public void run(String[] args){
        //Creates the data(Binary Tree)
        Node node = new Node(5);
        node.leftNode = new Node(3);
        node.rightNode = new Node(6);
        node.rightNode.rightNode = new Node(8);
        node.leftNode.rightNode = new Node(4);
        //Prints all arrays that could lead to the Binary Search Tree
        ArrayList<ArrayList<Integer>> possibleCombos = new ArrayList<>();
        findSequences(possibleCombos,node,new ArrayList<Node>(),new ArrayList<Integer>());
        System.out.println(possibleCombos);
    }
    public void findSequences(ArrayList<ArrayList<Integer>> possibleCombos,Node currNode,ArrayList<Node> availableNodes,ArrayList<Integer> currentList){
        ArrayList<Node> tempHashSet = new ArrayList<Node>(availableNodes);
        currentList = new ArrayList<>(currentList);
        tempHashSet.remove(currNode);
        currentList.add(currNode.num);
        if(currNode.leftNode != null){
            tempHashSet.add(currNode.leftNode);
        }
        if(currNode.rightNode != null){
            tempHashSet.add(currNode.rightNode);
        }
        for(int x=0;x<tempHashSet.size();x++){
            findSequences(possibleCombos,tempHashSet.get(x),tempHashSet,currentList);
        }
        if(tempHashSet.size() == 0){
            possibleCombos.add(currentList);
        }
    }
}
class Node {
    public int num;
    public Node leftNode;
    public Node rightNode;
    public Node(int num){
        this.num = num;
    }
}