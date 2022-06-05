package com.evo.ib.tree;

import java.util.*;

public class BinaryTree {


    static final int COUNT = 10;
    static Set<TreeNode> set = new HashSet<>();
    static Stack<TreeNode> stack = new Stack<>();
    static HashMap<Integer,Integer> mp = new HashMap<>();
    static int preIndex = 0;

    TreeNode root;

    public BinaryTree() {
        root = null;
    }


    public void insert(int key) {
        root = insertRec(root, key);
    }

    /* A recursive function to
       insert a new key in BST */
    TreeNode insertRec(TreeNode root, int key) {

        /* If the tree is empty,
           return a new node */
        if (root == null) {
            root = new TreeNode(key);
            return root;
        }

        /* Otherwise, recur down the tree */
        if (key < root.val)
            root.left = insertRec(root.left, key);
        else if (key > root.val)
            root.right = insertRec(root.right, key);

        /* return the (unchanged) node pointer */
        return root;
    }

    // print left child, parent, right child  (recursion)
    public void printInOrder(TreeNode root) {
        if (root != null) printInOrder(root.getLeft());
        else return;
        System.out.print(root.getVal() + " ");
        if (root != null) printInOrder(root.getRight());
        else return;

    }


    // print left child, parent, right child (loop)
    public void printInOrderLoop(TreeNode root) {
        if (root == null) return;
        Stack<TreeNode> st = new Stack<>();

        TreeNode curr = root;

        while (curr != null || st.size() > 0) {

            while (curr != null) {
                st.push(curr);
                curr = curr.getLeft();
            }
            curr = st.pop();
            System.out.print(curr.getVal() + " ");
            curr = curr.getRight();
        }
        System.out.println();
    }

    public List<Integer> inOrderLoop(TreeNode root) {
        if (root == null) return null ;
        List<Integer> list = new ArrayList<>() ;
        Stack<TreeNode> st = new Stack<>();

        TreeNode curr = root;

        while (curr != null || st.size() > 0) {

            while (curr != null) {
                st.push(curr);
                curr = curr.getLeft();
            }
            curr = st.pop();
            list.add(curr.getVal()) ;
            curr = curr.getRight();
        }
        return list ;
    }


    public void printPostOrder(TreeNode root) {
        if (root != null) {
            printPostOrder(root.getLeft());
            printPostOrder(root.getRight());
        } else return;
        System.out.print(root.getVal() + " ");
    }

    // parent first, left then right child (recursion)
    public void printPreOrder(TreeNode root) {
        if (root != null) {
            System.out.print(root.getVal() + " ");
        } else return;
        printPreOrder(root.getLeft());
        printPreOrder(root.getRight());
    }

    // parent first, left then right child (loop)
    public void printPreOrderLoop(TreeNode root) {

        Stack<TreeNode> st = new Stack<>();

        if (root == null) {
            return;
        }


        // Start from root node (set curr
        // node to root node)
        TreeNode curr = root;

        // Run till stack is not empty or
        // current is not NULL
        while (curr != null || !st.isEmpty()) {

            // Print left children while exist
            // and keep pushing right into the
            // stack.
            while (curr != null) {
                System.out.print(curr.getVal() + " ");

                if (curr.right != null)
                    st.push(curr.getRight());

                curr = curr.left;
            }

            // We reach when curr is NULL, so We
            // take out a right child from stack
            if (!st.isEmpty()) {
                curr = st.pop();
            }
        }

    }

    public static void showTrunks(Trunk p) {
        if (p == null) {
            return;
        }

        showTrunks(p.prev);
        System.out.print(p.str);
    }

    public void printTree(TreeNode root, Trunk prev, boolean isLeft) {
        if (root == null) {
            return;
        }

        String prev_str = "    ";
        Trunk trunk = new Trunk(prev, prev_str);

        printTree(root.right, trunk, true);

        if (prev == null) {
            trunk.str = "———";
        } else if (isLeft) {
            trunk.str = ".———";
            prev_str = "   |";
        } else {
            trunk.str = "`———";
            prev.str = prev_str;
        }

        showTrunks(trunk);
        System.out.println(" " + root.getVal());

        if (prev != null) {
            prev.str = prev_str;
        }
        trunk.str = "   |";

        printTree(root.left, trunk, false);
    }


    public TreeNode getRoot() {
        return root;
    }

    public void setRoot(TreeNode root) {
        this.root = root;
    }

    public int height(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> q = new LinkedList<>();
        int height = 0;
        q.add(root);
        int nodecount = q.size();

        while (1 == 1) {
            // nodeCount (queue size) indicates number of nodes
            // at current level.
            int nodeCount = q.size();
            if (nodeCount == 0)
                return height;
            height++;

            // Dequeue all nodes of current level and Enqueue all
            // nodes of next level
            while (nodeCount > 0) {
                TreeNode newnode = q.peek();
                q.remove();
                if (newnode.left != null)
                    q.add(newnode.left);
                if (newnode.right != null)
                    q.add(newnode.right);
                nodeCount--;
            }
        }

    }

    public TreeNode buildTree (int [] preorder, int [] inorder) {
        TreeNode root = null;
        for (int pre = 0, in = 0; pre < preorder.length;) {

            TreeNode node = null;
            do {
                node = new TreeNode(preorder[pre]);
                if (root == null) {
                    root = node;
                }
                if (!stack.isEmpty()) {
                    if (set.contains(stack.peek())) {
                        set.remove(stack.peek());
                        stack.pop().right = node;
                    }
                    else {
                        stack.peek().left = node;
                    }
                }
                stack.push(node);
            } while (preorder[pre++] != inorder[in] && pre < preorder.length);

            node = null;
            while (!stack.isEmpty() && in < inorder.length &&
                    stack.peek().val == inorder[in]) {
                node = stack.pop();
                in++;
            }

            if (node != null) {
                set.add(node);
                stack.push(node);
            }
        }

        return root;
    }

    public TreeNode buildTreeRec(int[] preorder, int[] inorder, int start, int end) {
        if (start > end) return null ;

        int cur = preorder[preIndex++] ;
        TreeNode node = new TreeNode(cur) ;
        if (start == end) return node ;

        int mindex = mp.get(cur) ;

        node.left = buildTreeRec(preorder, inorder, start, mindex-1) ;
        node.right = buildTreeRec(preorder, inorder, mindex+1, end) ;
        return node ;

    }

    public TreeNode buildTreeInPre (int [] preorder, int [] inorder) {
        for(int i = 0; i < inorder.length ;  i++)
        {
            mp.put(inorder[i], i);
        }
        return buildTreeRec(preorder, inorder, 0, inorder.length-1) ;
    }

    /* A function that constructs Balanced Binary Search Tree
     from a sorted array */
    public static TreeNode sortedArrayToBST(int arr[], int start, int end) {

        /* Base Case */
        if (start > end) {
            return null;
        }

        /* Get the middle element and make it root */
        int mid = (start + end) / 2;
        TreeNode node = new TreeNode(arr[mid]);

        /* Recursively construct the left subtree and make it
         left child of root */
        node.left = sortedArrayToBST(arr, start, mid - 1);

        /* Recursively construct the right subtree and make it
         right child of root */
        node.right = sortedArrayToBST(arr, mid + 1, end);

        return node;
    }

}
