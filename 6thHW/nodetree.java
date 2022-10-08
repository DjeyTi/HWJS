import java.util.Stack;

class Node {
    private Object value; // ключ узла
    private Node leftChild; // Левый узел потомок
    private Node rightChild; // Правый узел потомок

    public void printNode() { // Вывод значения узла в консоль
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
    private Node rootNode; // корневой узел
 
    public Tree() { // Пустое дерево
        rootNode = null;
    }

    public void insertNode(Object value, boolean[] left) { // метод вставки нового элемента
        Node newNode = new Node(); // создание нового узла
        newNode.setValue(value); // вставка данных
        if (rootNode == null) { // если корневой узел не существует
            rootNode = newNode;// то новый элемент и есть корневой узел
        }
        else { // корневой узел занят
            Node currentNode = rootNode; // начинаем с корневого узла
            Node parentNode;
            while (true) // мы имеем внутренний выход из цикла
            {
                parentNode = currentNode;
                for (int i = 0; i < left.length; i++) {
                    if (left[i] == true) {   // движение влево?
                        parentNode = currentNode;
                        currentNode = currentNode.getLeftChild();
                        if (currentNode == null){ // если был достигнут конец цепочки,
                            parentNode.setLeftChild(newNode); //  то вставить слева и выйти из методы
                            return;
                        }
                    }
                    else { // Или направо?
                        parentNode = currentNode;
                        currentNode = currentNode.getRightChild();
                        if (currentNode == null) { // если был достигнут конец tnцепочки,
                            parentNode.setRightChild(newNode);  //то вставить справа
                            return; // и выйти
                        }
                    }
                }
            }
        }
    }

    public void printTree() { // метод для вывода дерева в консоль
        Stack<Object> globalStack = new Stack<>(); // общий стек для значений дерева
        globalStack.push(rootNode);
        int gaps = 32; // начальное значение расстояния между элементами
        boolean isRowEmpty = false;
        String separator = "-----------------------------------------------------------------";
        System.out.println(separator);// черта для указания начала нового дерева
        while (isRowEmpty == false) {
            Stack<Object> localStack = new Stack<>(); // локальный стек для задания потомков элемента
            isRowEmpty = true;
            for (int j = 0; j < gaps; j++)
                System.out.print(' ');
            while (globalStack.isEmpty() == false) { // покуда в общем стеке есть элементы
                Node temp = (Node) globalStack.pop(); // берем следующий, при этом удаляя его из стека
                if (temp != null) {
                    System.out.print(temp.getValue()); // выводим его значение в консоли
                    localStack.push(temp.getLeftChild()); // соохраняем в локальный стек, наследники текущего элемента
                    localStack.push(temp.getRightChild());
                    if (temp.getLeftChild() != null ||
                            temp.getRightChild() != null)
                        isRowEmpty = false;
                }
                else {
                    System.out.print("__");// - если элемент пустой
                    localStack.push(null);
                    localStack.push(null);
                }
                for (int j = 0; j < gaps * 2 - 2; j++)
                    System.out.print(' ');
            }
            System.out.println();
            gaps /= 2;// при переходе на следующий уровень расстояние между элементами каждый раз уменьшается
            while (localStack.isEmpty() == false)
                globalStack.push(localStack.pop()); // перемещаем все элементы из локального стека в глобальный
        }
        System.out.println(separator);// подводим черту
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