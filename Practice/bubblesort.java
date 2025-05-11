public class bubblesort {
    static void sort(int a[], int n){
        int i, j, temp;
        for(i=0; i<n-1; i++){
            for(j=0; j<n-1-i; j++){
                if(a[j]>a[j+1]){
                    temp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int a[] = {5,2,1,3,4};
        sort(a, a.length);
        System.out.println("Sorted array is:");
        for(int i=0; i<5; i++){
            System.out.print(a[i]);
        }
    }
}
