package tree;

import java.util.LinkedList;

public class BinarySearchTree {
    /*
    * 二叉查找树
    *
    * 结构： 树 -》 二叉树 -》 二叉查找树
    * 特征： 父节点比左子树值大，比右子树值大
    *
    * 深度优先遍历
    *       1、前序遍历  父-》左子-》右子    递归公式： loop ->  print(father) -> loop(left)->loop(right)
    *       2、中序遍历
    *       3、后序遍历
    *
    * 广度优先遍历
    *       按层遍历
    *
    * 删除节点：
    *       1、没有子节点
    *       2、只有一个子节点
    *       3、有两个子节点
    * */
    private Node root ;

    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        tree.insert(3);
        tree.insert(1);
        tree.insert(5);
        tree.insert(2);
        tree.insert(9);
        tree.floorLoop(tree.root);
    }

    //中序遍历
    public void middleLoop(Node _node){
        if (_node==null)return;
        System.out.println(_node.data);
        middleLoop(_node.left);
        middleLoop(_node.right);
    }
    //前序遍历
    public void beforeLoop(Node _node){
        if (_node==null)return;
        middleLoop(_node.left);
        System.out.println(_node.data);
        middleLoop(_node.right);
    }
    //后序遍历
    public void afterLoop(Node _node){
        if (_node==null)return;
        middleLoop(_node.left);
        middleLoop(_node.right);
        System.out.println(_node.data);
    }

    //按层遍历
    public void floorLoop(Node _root){
        if (_root==null)return ;
        LinkedList<Node> queue = new LinkedList<Node>();
        queue.offer(_root); //将元素加入到队尾
        while (!queue.isEmpty()){
            Node tmpNode = queue.poll();//取出队列的第一个元素
            System.out.println(tmpNode.data);
            if (tmpNode.left != null)queue.offer(tmpNode.left);
            if (tmpNode.right != null)queue.offer(tmpNode.right);
        }
    }

    public void insert(int _data){
        if (root==null){
            root = new Node(_data);
            return ;
        }

        Node tmpNode = root;
        while (tmpNode != null){
            if (_data>tmpNode.data){
                if(tmpNode.right==null){
                    tmpNode.right = new Node(_data);
                    return ;
                }
                else{
                    tmpNode = tmpNode.right ;
                }
            }else {
                if(tmpNode.left==null){
                    tmpNode.left = new Node(_data);
                    return ;
                }
                else{
                    tmpNode = tmpNode.left ;
                }
            }
        }
    }


    class Node {
        private Node left ;
        private Node right ;
        private int data ;
        public Node(int data){
            this.data=data;
        }
    }


}
