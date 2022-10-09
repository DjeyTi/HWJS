import java.util.Stack;

class Node {
    private Object value;
    private Node leftChild;
    private Node rightChild;

    public void printNode() {
        System.out.println(" Выбранный узел имеет значение :" + value);
    }

    public Object getValue() {
        return this.value;
    }

    public void setValue(final Object value) {
        this.value = value;
    }

    public Node getLeftChild() {
        return this.leftChild;
    }

    public void setLeftChild(final Node leftChild) {
        this.leftChild = leftChild;
    }

    public Node getRightChild() {
        return this.rightChild;
    }

    public void setRightChild(final Node rightChild) {
        this.rightChild = rightChild;
    }

    @Override
    public String toString() {
        return "Node{" +
               "value=" + value +
               ", leftChild=" + leftChild +
               ", rightChild=" + rightChild +
               '}';
    }
}

class Tree {
    private Node rootNode;
 
    public Tree() {
        rootNode = null;
    }

    public void insertNode(Object value, boolean[] left) {
        Node newNode = new Node();
        newNode.setValue(value);
        if (rootNode == null) {
            rootNode = newNode;
        }
        else {
            Node currentNode = rootNode;
            Node parentNode;
            while (true)
            {
                parentNode = currentNode;
                for (int i = 0; i < left.length; i++) {
                    if (left[i] == true) {
                        parentNode = currentNode;
                        currentNode = currentNode.getLeftChild();
                        if (currentNode == null){
                            parentNode.setLeftChild(newNode);
                            return;
                        }
                    }
                    else {
                        parentNode = currentNode;
                        currentNode = currentNode.getRightChild();
                        if (currentNode == null) {
                            parentNode.setRightChild(newNode);
                            return;
                        }
                    }
                }
            }
        }
    }

    public void printTree() {
        Stack<Object> globalStack = new Stack<>();
        globalStack.push(rootNode);
        int gaps = 32;
        boolean isRowEmpty = false;
        String separator = "-----------------------------------------------------------------";
        System.out.println(separator);
        while (isRowEmpty == false) {
            Stack<Object> localStack = new Stack<>();
            isRowEmpty = true;
            for (int j = 0; j < gaps; j++)
                System.out.print(' ');
            while (globalStack.isEmpty() == false) {
                Node temp = (Node) globalStack.pop();
                if (temp != null) {
                    System.out.print(temp.getValue());
                    localStack.push(temp.getLeftChild());
                    localStack.push(temp.getRightChild());
                    if (temp.getLeftChild() != null ||
                            temp.getRightChild() != null)
                        isRowEmpty = false;
                }
                else {
                    System.out.print("__");
                    localStack.push(null);
                    localStack.push(null);
                }
                for (int j = 0; j < gaps * 2 - 2; j++)
                    System.out.print(' ');
            }
            System.out.println();
            gaps /= 2;
            while (localStack.isEmpty() == false)
                globalStack.push(localStack.pop());
        }
        System.out.println(separator);
    }
}

public class nodetree {
    public static void main(String[] args) {
        Tree tree = new Tree();
        String str = new String("1(3(31,511(202,nil)),2(4,5)");
        String[] new_str = str.split(",");
        boolean[] check = new boolean[]{true, true, true};
        int count = -1;
        for (String element: new_str) {
            if (element.contains("(")){
                String[] pack = element.split("\\(");
                for (String part: pack) {
                    tree.insertNode(part, check);
                    count++;
                    if (part == pack[pack.length - 1] & check[check.length - 1] == true){
                        check[count / 2] = false;
                    }
                    else if (part == pack[pack.length - 1] & check[check.length - 1] == false) {
                        for (int i = check.length - 1; i >= 0; i--) {
                            if (check[i]) {
                                check[i] = false;
                                count = 0;
                                break;
                            } else {
                                check[i] = true;
                            }
                        }
                    }
                }
            } else if (element.contains(")")) {
                String[] pack = element.split("\\)");
                    for (String part: pack) {
                        tree.insertNode(part, check);
                        count++;
                        if (part == pack[pack.length - 1] & check[check.length - 1] == true){
                            check[count / 2] = false;
                        }
                        else if (part == pack[pack.length - 1] & check[check.length - 1] == false) {
                            for (int i = check.length - 1; i >= 0; i--) {
                                if (check[i]) {
                                    check[i] = false;
                                    count = 0;
                                    break;
                                } else {
                                    check[i] = true;
                                }
                            }
                        }
                    }
            }       
        }
        tree.printTree();
    }
}