public class AvlTree<T extends Comparable<T>> {
    /**
     * root node
     */
    private AvlNode<T> rootNode;

    public AvlTree() {
        rootNode = null;
    }

    /**
     * get the height of tree
     * empty tree return zero ,
     *
     * @param tree
     * @return
     */
    private int height(AvlNode<T> tree) {
        if (tree != null) {
            return tree.height;
        }
        return 0;
    }

    public int height() {
        return height(rootNode);
    }

    /**
     * max one
     *
     * @param a
     * @param b
     * @return
     */
    private int max(int a, int b) {
        return a > b ? a : b;
    }

    /**
     * 判断空
     */
    public void emptyTree() {
        rootNode = null;
    }

    public boolean isEmptyTree() {
        return rootNode == null;
    }

    /**
     * 判断节点是否存在
     *
     * @param node
     * @param key
     * @return
     */
    private boolean contains(AvlNode<T> node, T key) {
        if (node == null) {
            return false;
        }

        AvlNode<T> x = search(key);
        return x == null ? false : true;

    }

    public boolean contains(T key) {
        return contains(rootNode, key);
    }

    private AvlNode<T> findMin(AvlNode<T> node) {
        if (node == null) {
            return null;
        } else if (node.left == null) {
            return node;
        } else {
            return findMin(node.left);
        }
    }


    /**
     * 查找最小节点
     *
     * @return
     */
    public AvlNode finMin() {
        return findMin(rootNode, key);
    }

    /**
     * 查找最大节点
     *
     * @return
     */
    public AvlNode finMax() {
        return findMax(rootNode);
    }

    /**
     * 非递归 编写findMax
     *
     * @param node
     * @return
     */
    private AvlNode findMax(AvlNode<T> node) {

            while (node != null) {
                node = node.right;
            }

        return node;
    }

    /**
     * 先序遍历 avl树
     *
     * @param tree
     */
    private void preOrder(AvlNode<T> tree) {

        if (tree != null) {
            System.out.println(tree.element + " ");
            preOrder(tree.left);
            preOrder(tree.right);
        }

    }

    public void preOrder() {
        this.preOrder(rootNode);
    }

    /**
     * 中序遍历
     *
     * @param tree
     */
    private void inOrder(AvlNode<T> tree) {
        if (tree != null) {
            inOrder(tree.left);
            System.out.println(tree.element + " ");
            inOrder(tree.right);
        }
    }

    public void inOrder() {
        inOrder(rootNode);
    }

    /**
     * 后序遍历
     *
     * @param tree
     */
    private void postOrder(AvlNode<T> tree) {
        if (tree != null) {
            postOrder(tree.left);
            postOrder(tree.right);
            System.out.println(tree.element + " ");

        }
    }

    public void postOrder() {
        this.postOrder(rootNode);
    }

    /**
     * 查询树 递归
     *
     * @param node
     * @param key
     * @return
     */
    private AvlNode<T> search(AvlNode<T> node, T key) {

        if (node == null) {
            return node;
        }
        //key >element return 1;
        //key ==element return 0;
        //key <element return -1;
        int compareResult = key.compareTo(node.element);

        if (compareResult < 0) {
            return search(node.left, key);
        } else if (compareResult > 0) {
            return search(node.right, key);
        }

        return node;
    }

    public AvlNode<T> search(T key) {
        return search(rootNode, key);
    }


    /**
     * 非递归 查询
     *
     * @param node
     * @param key
     * @return
     */
    private AvlNode<T> iteratorSearch(AvlNode<T> node, T key) {
        while (node != null) {
            int compareResult = key.compareTo(node.element);
            if (compareResult < 0) {
                node = node.left;
            } else if (compareResult > 0) {
                node = node.right;
            } else {
                return node;
            }

        }
        return node;
    }

    public AvlNode<T> iteratorSearch(T key) {
        return this.iteratorSearch(rootNode, key);
    }



    /**
     * LL 左左
     * https://www.cnblogs.com/skywang12345/p/3577479.html#commentform
     * @param k2
     * @return 旋转后的根节点
     */
    private AvlNode<T> leftLeftRotation(AvlNode<T> k2){
           AvlNode<T> k1;

           k1=k2.left;
           k2.left=k1.right;
           k1.right=k2;

           k2.height=max(height(k2.left),height(k2.right))+1;
           k2.height=max(height(k1.left),k2.height)+1;

           return k1;


    }




    /**
     * extends 泛型上限 Compareable
     *
     * @param <T>
     */
    private static class AvlNode<T extends Comparable<T>> {
        /**
         * Constructors
         *
         * @param t
         */
        AvlNode(T t) {
            this(t, null, null);
        }

        AvlNode(T t, AvlNode<T> lt, AvlNode<T> rt) {
            element = t;
            left = lt;
            right = rt;
            height = 0;
        }

        /**
         * the data in the code
         */
        T element;

        /**
         * left child
         */
        AvlNode<T> left;

        /**
         * right child
         */
        AvlNode<T> right;

        /**
         * height
         */
        int height;


    }
}

