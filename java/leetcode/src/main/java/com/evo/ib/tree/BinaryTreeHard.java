package com.evo.ib.tree;

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

    public TreeNode lowestCommonAncestorBST(TreeNode root, TreeNode p, TreeNode q) {
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

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (p == null) return q  ;
        if (q == null) return p ;
        if (root == null) return null ;
        List <TreeNode> list1 = new ArrayList<>() ;
        List <TreeNode> list2 = new ArrayList<>() ;
        boolean ans1 = findPath(root, p, list1)  ;
        boolean ans2 = findPath(root, q, list2) ;
        if (!(ans1 || ans2)) {
            System.out.println ("cannot find given nodes") ;
            return null ;
        }
        int i ;
        for (i = 0 ; i < list1.size() && i < list2.size() ; i++) {
            if (!(list1.get(i).val == list2.get(i).val)) break ;
        }

        return list1.get(i-1) ;
    }

    public boolean findPath(TreeNode root, TreeNode p, List<TreeNode> list) {

        if (root == null) return false ;
        list.add(root) ;
        if (root.val == p.val) return true ;
        if (root.left != null && findPath(root.left, p, list)){
            return true;
        }
        if (root.right != null && findPath(root.right, p, list)) {
            return true;
        }
        list.remove(list.size()-1) ;
        return false ;
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

    public int maxPathSum(TreeNode root) {
        int res = Integer.MIN_VALUE ;

        return maxPathSumAll(root, res) ;
     }

     public int maxPathSumAll(TreeNode root, int res) {

        if (root == null) return 0 ;

        int left = maxPathSumAll(root.left, res) ;
        int right = maxPathSumAll(root.right, res) ;

        int max_single = Math.max(Math.max(left, right) + root.val, root.val) ;

        int max = Math.max(max_single, left+right+ root.val) ;

        return (Math.max(res, max)) ;

     }

     public TreeNode  depthFirstSearch(TreeNode root,  TreeNode node) {

        if (root == null) return null ;
        Stack<TreeNode>  stack = new Stack<>() ;
        stack.push(root) ;

        while (stack.size() > 0) {
            TreeNode cur = stack.pop() ;
            System.out.print(cur.val + " ");
            if (node.val == cur.val )  return cur ;
            if (cur.right != null) stack.push(cur.right) ;
            if (cur.left != null) stack.push(cur.left) ;
        }
        return null ;
     }

     public TreeNode breadthFirstSearch (TreeNode root, TreeNode node) {
        if (root == null) return null ;
        Queue<TreeNode> queue = new LinkedList<>() ;
        queue.add(root) ;
        int currentCount = queue.size() ;
        int nextLevelCount = 0 ;

        while (queue.size() > 0) {
            while (currentCount > 0) {
                TreeNode cur = queue.remove() ;
                System.out.print (cur.val + " ") ;
                --currentCount ;
                if (cur.val == node.val) return cur ;
                if (cur.left != null) {
                    queue.add(cur.left) ;
                    ++nextLevelCount ;
                }
                if (cur.right != null) {
                    queue.add(cur.right) ;
                    ++nextLevelCount ;
                }
            }
            currentCount = nextLevelCount ;
            nextLevelCount = 0 ;

        }
        return null ;
     }
}
