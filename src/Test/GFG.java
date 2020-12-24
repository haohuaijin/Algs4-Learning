package Test;

//查找数组的局部最小值
class GFG {
    public static int localMinUtil(int[] arr, int low, int high, int n) {
        int mid = low + (high - low) / 2;
        if((mid == 0 || arr[mid - 1] > arr[mid]) &&
                (mid == n - 1 || arr[mid] < arr[mid + 1]))
            return mid;
        else if(mid > 0 && arr[mid - 1] < arr[mid])
            return localMinUtil(arr, low, mid - 1, n);
        return localMinUtil(arr, mid + 1, high, n);
    }
    public static int localMin(int[] arr, int n) {
        return localMinUtil(arr, 0, n - 1, n);
    }
    public static void main (String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9}; //9, 6, 3, 14, 5, 7, 4
        int n = arr.length;
        int index = localMin(arr, n);
        System.out.println("the index is " + index + ", the num is " + arr[index]);
    }
}