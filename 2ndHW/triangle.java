public class triangle {

    static double findtrianglenumber(int a) {
        return 0.5*a*(a + 1);
    }

    public static void main(String[] args) {
        int a = 2;
        var answer = findtrianglenumber(a);
        System.out.println((int)answer);
    }
}