import java.util.Arrays;

public class merge {
    public static void main(String[] args) {
        int[] newarray = new int[] {1,9,2,5,8,3,6,7};
        int[] array = merging(newarray, 0, newarray.length - 1);
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }

    public static int[] merging(int[] args, int low, int high) {
        if (high <= low)
            return args;
        int mid = low + (high - low) / 2;
        merging(args, low, mid);
        merging(args, mid + 1, high);
        int[] buf = Arrays.copyOf(args, args.length);
        for (int k = low; k <= high; k++)
            buf[k] = args[k];
        int i = low, j = mid + 1;
        for (int k = low; k <= high; k++) {
            if (i > mid) {
                args[k] = buf[j];
                j++;
            } else if (j > high) {
                args[k] = buf[i];
                i++;
            } else if (buf[j] < buf[i]) {
                args[k] = buf[j];
                j++;
            } else {
                args[k] = buf[i];
                i++;
            }
        }
        return args;
    }
}