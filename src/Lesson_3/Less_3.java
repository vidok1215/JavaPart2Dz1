package Lesson_3;

import java.util.Arrays;

public class Less_3 {
    public static void main(String[] args) {
        //писать тут
        replacement();
        System.out.println("\n^_^.^_^.^_^.^_^.^_^.^_^.^_^.");
        brainExplosion();
        System.out.println("\n^_^.^_^.^_^.^_^.^_^.^_^.^_^.");
        boom();
        System.out.println("^_^.^_^.^_^.^_^.^_^.^_^.^_^.");
        int[][] arr1 = {{1, 0, 0, 1},{0, 1, 1, 0},{0, 1, 1, 0},{1, 0, 0, 1}};
        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr1.length; j++) {
                System.out.print(" " + arr1 [i][j] + " ");
            }
            System.out.println(" ");
        }
        System.out.println("Done");
    }// конец
    public static void replacement() {
    int[] arr = { 1, 1, 0, 1, 0, 1 };
        for ( int i = 0; i < arr.length; i++) {
        if (arr[i] == 0) {
            System.out.print("1 ");
        } else {
            System.out.print("0 ");
        }


    }}
    public static void brainExplosion() {
        String[] vdk = new String[100];
        for (int i = 0; i < vdk.length; i++) {
            vdk[i] = "| " + i;
        }
        for (int i = 0; i < vdk.length; i++) {
            System.out.print(vdk[i]);
        }
    }

    public static void boom() {
        int[] bl = {1 , 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for (int i = 0; i < bl.length; i++) {
            if (bl[i] < 6)
                bl[i] *= 2;
            }
        System.out.println(Arrays.toString(bl));
    }
//    public static void cross(int[][] arr) {
////        for (int i = 0; i < arr.length; i++) {
////            arr[i][i] = 1;
////            arr[i][arr.length - 1 -i] = 1;
////        }
//
//    }

}
