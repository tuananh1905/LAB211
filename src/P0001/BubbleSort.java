//https://docs.google.com/document/d/11DS62akFAwbSEDqGB3h8nlIeqLgJnd0z/edit
package P0001;

import java.util.Random;
import java.util.Scanner;

public class BubbleSort {

    public static void main(String[] args) {
        BubbleSort bs = new BubbleSort();
        Random rand = new Random();

        int range = bs.checkInput();

        int[] arr = new int[range];
        for (int i = 0; i < range; i++) {
            arr[i] = rand.nextInt(range);
        }

        System.out.print("Unsorted array: ");
        bs.printArray(arr);

        bs.bubbleSort(arr);
        
        System.out.print("Sorted array: ");
        bs.printArray(arr);
    }

    int checkInput() {
        Scanner scan = new Scanner(System.in);
        int range;
        System.out.println("Enter number of array: ");
        do {
            while (!scan.hasNextInt()) {
                String input = scan.next();
                System.out.println("\""+input+"\" is not number, you need to enter a decimal number!!!");
            }
            range = scan.nextInt();
            if (range < 0) {
                System.out.println("\""+range+"\" is negative number, you need to enter a positive decimal number!!!");
            }
        } while (range < 0);
        return range;
    }

    void printArray(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; ++i) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    void bubbleSort(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
}
