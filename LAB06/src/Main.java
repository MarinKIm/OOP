public class Main{
    public static void main(String[] args){
        int[] arr1 = {7,4,5,1,3};
        int[] arr2 = {9,2,2,5,4,3,1,6,7,3,8,0,3};

        printArr(arr1);
        mergeSort(arr1);
        printArr(arr1);

        printArr(arr2);
        mergeSort(arr2);
        printArr(arr2);

    }

    public static void mergeSort(int[] a){
        mergeSort(a, a.length);
    }

    public static void mergeSort(int[] a, int n){
        if(n<2){
            return;
        }

        int mid = n/2;

        int[] left = new int[mid];
        int[] right = new int[n-mid];

        for(int i=0; i<mid ;i++){
            left[i] = a[i];
        }

        for(int i=mid; i<n;i++){
            right[i-mid] = a[i];
        }

        mergeSort(left, mid);
        mergeSort(right, n-mid);

        merge(a,left,right,mid,n-mid);
    }

    public static void merge(int[] a, int[] left, int[] right, int l, int r) {
        int i = 0, j = 0, k = 0;

        while (i < l && j < r) {
            if (left[i] <= right[j]) {
                a[k++] = left[i++];
            }
            else {
                a[k++] = right[j++];
            }
        }

        while (i < l){
            a[k++] = left[i++];
        }
        while (j < r){
            a[k++] = right[j++];
        }
    }

    public static void printArr(int[] a){
        for(int i=0; i<a.length;i++){
            System.out.print(a[i]+" ");
        }
        System.out.println('\n');

    }

}
