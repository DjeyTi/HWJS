public class sort {
    
    public static void main(String[] args) {
        int arr[] = new int[] {1,10,5,99,12,77,29,19,56,49,17,69,28,4};     
        sorting(arr);  
        for (int i = 0; i < arr.length; i++)
            System.out.println(arr[i]);              
    }

    public static void heapsort(int arr[], int n, int i) {
        int max = i;
        int left = 2 * i + 1;
        int rigth = 2 * i + 2;
        if (left < n && arr[left] > arr[max])
            max = left;
        if (rigth < n && arr[rigth] > arr[max])
            max = rigth;
        if (max != i) {
            int borrow = arr[i];
            arr[i] = arr[max];
            arr[max] = borrow;
            heapsort(arr, n, max);
        }
    }

    public static void sorting(int arr[]) {
        int n = arr.length;
        for (int i = n / 2 - 1; i >= 0; i--)
            heapsort(arr, n, i);
        for (int i = n - 1; i >= 0; i--) {
            int borrow = arr[0];
            arr[0] = arr[i];
            arr[i] = borrow;
            heapsort(arr, i, 0);
        }
    }
}
