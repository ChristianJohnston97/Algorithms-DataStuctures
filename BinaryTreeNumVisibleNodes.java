// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");
import java.util.*;

class BinaryTreeNumVisibleNodes {
    
    // inner helper class 
    class Tree
    {
        public int value;
        public Tree left;
        public Tree right;

    }
    
    // root of binary tree
    Tree root;
    
    
    public int biggestNodeOnPathToNode(int val)
    {
        int largestNode = 0;
        // start at the root 
        Tree node = root;
        if(node != null)
        {
            // IN ORDER TRAVERSAL
            if(node.left != null)
            {
                solution(node.left);
            }

            if(node.value > largestNode)
            {
                largestNode = node.value;

            }
            // if we have found the node,return
            if(node.value == val)
            {
                return largestNode;
            }

            if(node.right != null)
            {
                solution(node.right);
            }
        }
        return -1;
    }
    
    // test if a node is visible 
    public boolean isVisible(Tree node)
    {
        int val = node.value;
        int biggest = biggestNodeOnPathToNode(val);
        // if biggest value on path is bigger than its own value, then not visible 
        if(biggest > val)
        {
            return false;
        }
        else
        {
            return true;
        }
    }

    
    public int solution(Tree tree) {
        int number = 0;
        // if empty tree, return 0
        if(tree == null)
        {
            return 0;
        }
        //  test if visible 
        if(isVisible(tree))
        {
            number++;
        }

        // again a level order traversal to get to every node
        if(tree != null)
        {
            if(tree.left != null)
            {
                solution(tree.left);
            }           
            if(tree.right != null)
            {
                solution(tree.right);
            }
        }
        return number;
    }
}