package com.evo.ib.tree;

import com.sun.source.tree.Tree;

import java.util.*;

public class BinaryTreeHard {

    public boolean isValidBST(TreeNode root) {
        if (root == null) return true ;
        return isValidBST (root, Long.MIN_VALUE, Long.MAX_VALUE) ;
    }

    public boolean isValidBST(TreeNode root, long min, long max) {
        if (root == null) return true ;
        if (root.val < min || root.val > max) return false ;
        //System.out.println (root.val + " " + min + " " + max) ;
        return (isValidBST(root.left, min, (long) root.val -1L) &&
                isValidBST(root.right, (long)root.val+1L, max)) ;
    }

    public boolean isSymmetric(TreeNode root) {

        if (root == null) return true ;

        return (checkMirror (root.left, root.right)) ;

    }

    public boolean checkMirror(TreeNode a, TreeNode b) {
        if (a == null && b ==null)  return true ;

        if (a == null || b == null) return false ;

        return (a.val == b.val && (checkMirror(a.left, b.right) && checkMirror(a.right, b.left))) ;
    }

    public boolean isValidNullBST (TreeNode root, TreeNode l, TreeNode r) {
        if (root == null) return true ;

        if (l != null && root.val <= l.val) return false ;
        if (r!= null && root.val >= r.val) return false ;
        return isValidNullBST(root.left, l, root) && isValidNullBST(root.right, root, r) ;
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (p == null) return q  ;
        if (q == null) return p ;
        if (root == null) return null ;


        TreeNode save = root ;
        while (root != null) {
            if ((root.val < p.val && root.val > q.val) ||
                    (root.val > p.val && root.val < q.val))
                return root ;
            if (root.val == p.val) return p ;
            if (root.val == q.val) return q ;
            if (root.val < p.val  && root.val < q.val) root = root.right ;
            if (root.val > p.val  && root.val >  q.val) root = root.left ;
        }
        return save ;
    }

    public TreeNode inOrderSccc (TreeNode root, TreeNode p) {
        if (p.right != null)
            return minNode(p.right) ;
        TreeNode succ = null ;

        while (root != null) {
            if (p.val < root.val){
                succ = root ;
                root = root.left ;
            }
            else if (p.val > root.val) {
                root = root.right;
            } else
                break;

        }
        if (root != null) succ=root ;
        return succ ;
    }

    public TreeNode minNode(TreeNode r) {
        if (r.left != null)
            r = r.left ;
        return r ;
    }

    public List<List<Integer>> zigZagOrder (TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null) return list ;
        Queue<TreeNode> queue = new LinkedList<>() ;
        queue.add(root );
        boolean zigzag = true ;
        int levelcount = queue.size() ;
        int nextlevelcount = 0 ;

        while (levelcount > 0) {
            Stack<TreeNode> stack = new Stack<>() ;
            List<Integer> llist = new ArrayList<>() ;
            while (levelcount > 0) {
                TreeNode node = queue.remove() ;
                if (node != null) {
                    llist.add(node.val) ;
                    --levelcount ;
                }
                if (zigzag) {
                    if (node.left != null) {
                        stack.push(node.left);
                        ++nextlevelcount;
                    }
                    if (node.right != null) {
                        stack.push(node.right) ;
                        ++nextlevelcount ;
                    }
                }
                else {
                    if (node.right != null) {
                        stack.push(node.right);
                        ++nextlevelcount;
                    }
                    if (node.left != null) {
                        stack.push(node.left);
                        ++nextlevelcount;
                    }
                }


            }
            while(stack.size() > 0) {
                queue.add(stack.pop()) ;
            }
            levelcount = nextlevelcount ;
            zigzag = !zigzag ;
            nextlevelcount = 0 ;
            list.add(llist) ;

        }
        return list ;
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null) return list ;
        Queue<TreeNode> queue = new LinkedList<>() ;
        queue.add(root );
        int levelcount = queue.size() ;
        int nextlevelcount = 0 ;

        while (levelcount > 0) {
            List<Integer> llist = new ArrayList<>() ;
            while (levelcount > 0) {
                TreeNode node = queue.remove() ;
                if (node != null) {
                    llist.add(node.val) ;
                    --levelcount ;
                    if (node.left != null) {
                        queue.add(node.left);
                        ++nextlevelcount;
                    }
                    if (node.right != null) {
                        queue.add(node.right) ;
                        ++nextlevelcount ;
                    }
                }
            }
            levelcount = nextlevelcount ;
            nextlevelcount = 0 ;
            list.add(llist) ;

        }
        return list ;
    }
}
