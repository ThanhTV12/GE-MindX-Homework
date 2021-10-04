package lesson1.onclass;

public class DatchFlagPartitionProblem {
    public static void main(String[] args) {
        System.out.println("Hello");
        int[] A = {5, 4, 1, 3, 6, 7, 0};
        int pivot = A[3];
        int boundary = -1;
        for(int i = 0; i < A.length; i++) {
            if (A[i] < pivot) {
                boundary++;
                int temp = A[i];
                A[i] = A[boundary];
                A[boundary] = temp;
            }
        }

        System.out.println("A");
        System.out.println(A);

        boundary = A.length;
        for(int i = A.length - 1; i >= 0; i--) {
            if (A[i] > pivot) {
                boundary--;
                int temp = A[i];
                A[i] = A[boundary];
                A[boundary] = temp;
            }
        }
        System.out.println("A");
        System.out.println(A);
    }
}
