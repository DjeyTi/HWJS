public class hanoi {

    public static void main(String[] args) {
        tower(3, 'A', 'B', 'C');
    }
    
    public static void tower(int a, char first, char second, char third) {
        if (a == 1) {
            System.out.println("Перемещаем диск 1 со стобика " + first + " на стобик " + second);
        } else {
            tower(a - 1, first, third, second);
            System.out.println("Перемещаем диск " + a + " со стобика " + first + " на стобик " + second);
            tower(a - 1, third, second, first);
        }

    }
    
}