import java.util.Arrays;

public class wave {
    public static void main(String[] args) {
        int[][] array = new int[7][7];
        int[] start = new int[]{1, 1};
        int[] end = new int[]{6, 6};
        array = wave_sorting(array, start, end);
        for (int[] row: array) {
            for (int element: row) {
                System.out.print(element + ", ");
            }
            System.out.println();
        }
        way(array, start, end);
    }
    
    public static int[][] wave_sorting(int[][] args, int[] start, int[] end) { // x, y
        args[start[0]][start[1]] = 1;
        int[][] list = new int[4][4];
        int[] position = new int[2]; 
        int mark = 2;
        int count = 0;
        while (args[end[0]][end[1]] == 0 ) {
            if (mark == 2) {
                for (int i = start[0] - 1; i <= start[0] + 1; i++) {
                    for (int j = start[1] - 1; j <= start[1] + 1; j++) {
                        if (i == start[0] - 1 & j == start[1] - 1 || i == start[0] + 1 & j == start[1] + 1 
                         || i == start[0] + 1 & j == start[1] - 1 || i == start[0] - 1 & j == start[1] + 1
                         || i < 0 || j < 0)
                            continue; 
                        if (args[i][j] == 0) {
                            args[i][j] = mark;
                            position[0] = i;
                            position[1] = j;
                            list[count] = Arrays.copyOf(position, 2);
                            count++;
                        }
                    }
                }
                mark++;
            } else {
                int[][] new_list = new int[count*2][2];
                if (mark == 3)
                    new_list = new int[8][2];
                count = 0;
                for (int k = 0; k < list.length; k++) {
                    int[][] same_list = new int[3][3];
                    int second_count = 0;
                    for (int i = list[k][0] - 1; i <= list[k][0] + 1; i++) {
                        for (int j = list[k][1] - 1; j <= list[k][1] + 1; j++) {
                            if (i == list[k][0] - 1 & j == list[k][1] - 1 || i == list[k][0] + 1 & j == list[k][1] + 1 
                             || i == list[k][0] + 1 & j == list[k][1] - 1 || i == list[k][0] - 1 & j == list[k][1] + 1
                             || args.length <= i || i < 0 || args[0].length <= j || j < 0)
                            continue; 
                            if (args[i][j] == 0) {
                                args[i][j] = mark;
                                position[0] = i;
                                position[1] = j;
                                same_list[second_count] = Arrays.copyOf(position, 2);
                                second_count++;
                            }
                        }
                    }
                    for (int i = 0; i < second_count; i++) {
                        new_list[count] = Arrays.copyOf(same_list[i], 2);
                        count++;
                    }
                }
                mark++;
                list = Arrays.copyOf(new_list, count);
            }
        }
        return args;
    }   

    public static void way(int[][] args, int[] start, int[] end) {
        int mark = 1;
        System.out.print("Путь до точки назначения: \nСтарт(" + start[0] + ", " + start[1] + ") ");
        while (mark != args[end[0]][end[1]]) {
            if (start[0] < end[0]) {
                System.out.print("Вниз ");
                mark++;
            }
            if (start[0] > end[0]) {
                System.out.print("Вверх ");
                mark++;
            }
            if (start[1] < end[1]) {
                System.out.print("Вправо ");
                mark++;
            }
            if (start[1] > end[1]) {
                System.out.print("Влево "); 
            mark++;
            }           
        }
        System.out.print("Конец(" + end[0] + ", " + end[1] + ")");
    } 
}
