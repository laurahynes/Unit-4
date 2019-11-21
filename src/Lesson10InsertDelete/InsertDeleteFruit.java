package Lesson10InsertDelete;

import java.util.Scanner;

public class InsertDeleteFruit {
    
    static int logicalSize = 0;

    public static void main(String[] args) {
        String fruits[] = new String[10];
        fruits[0] = "Apple";
        fruits[1] = "Kiwi";
        fruits[2] = "Orange";
        fruits[3] = "Strawberry";        
        logicalSize = 4;
        showFruit(fruits);
        
        System.out.println("Inserting Peach");
        //where does it go?
        int loc = findInsertPoint(fruits, "Peach");
        System.out.println("Peach will be inserted at " + loc);
        insert(fruits,"Peach", loc);
        showFruit(fruits);
        System.out.println("Inserting Banana and Raspberry");
        loc = findInsertPoint(fruits, "Banana");
        insert(fruits, "Banana", loc);
        loc = findInsertPoint(fruits, "Raspberry");
        insert(fruits, "Raspberry",loc);
        showFruit(fruits);
        ////////////////////////TESTING DELETE/////////////////////////////
        Scanner scan = new Scanner(System.in);
        String f;
        while(true){
            System.out.print("Enter fruit to delete, or \"q\" to quit > ");
            f = scan.nextLine();
            if(f.equals("q"))break;
            //find fruit in list
            loc = search(fruits, f);
            if(delete(fruits, loc) == false)
                System.out.println("Could not delete - " + f + " not found.");
            else
                System.out.println(f + " was deleted.");
            showFruit(fruits);
        }
    }
    
    public static void showFruit(String arr[]){
        System.out.println("------------------------------");
        for (int i = 0; i < logicalSize; i++) {
            System.out.print(arr[i] + ", ");
        }
        System.out.println("\n------------------------------\n");
    }
    
    //search is needed to find an item to delete - need to know its location
    public static int search(Object[] a, Object searchValue) {
        int left = 0;
        int right = logicalSize - 1;
        while (left <= right) {
            int midpoint = (left + right) / 2;
            int result = ((Comparable) a[midpoint]).compareTo(searchValue);
            if (result == 0) {
                return midpoint;
            } else if (result < 0) {
                left = midpoint + 1;
            } else {
                right = midpoint - 1;
            }
        }
        return -1;

    }

    //call find insertpoint first to get target index, then send it into here
//////////////////////////////////////////////////////////////////////////////////
    public static boolean insert(Object array[], Object newItem, int targetIndex) {
        // Check for a full array and return false if full
        if (logicalSize == array.length) {
            return false;
        }
        // Check for valid target index or return false 
        if (targetIndex < 0 || targetIndex > logicalSize) {
            return false;
        }
        // Shift items down by one position
        for (int i = logicalSize; i > targetIndex; i--) {
            array[i] = array[i - 1];
        }
        // Add new item, increment logical size,return true                       
        array[targetIndex] = newItem;
        logicalSize++;
        return true;
    }

    //before calling delete, must search for item first and send that result into here
//////////////////////////////////////////////////////////////////////////////////
    public static boolean delete(Object array[], int targetIndex) {
        if (targetIndex < 0 || targetIndex >= logicalSize) {
            return false;
        }

        // Shift items up by one position
        for (int i = targetIndex; i < logicalSize - 1; i++) {
            array[i] = array[i + 1];
        }

        // Decrement logical size and return true 
        logicalSize--;
        return true;
    }

    //call this before inserting new item
    //very similar to search, but we are looking for a location for a NEW item
/////////////////////////////////////////////////////////////////////////////////
    public static int findInsertPoint(Object a[], Object searchValue) {
        int left = 0;
        int right = logicalSize - 1;
        int midpoint = 0;

        while (left <= right) {
            midpoint = (left + right) / 2;

            int result = ((Comparable) a[midpoint]).compareTo(searchValue);

            if (result < 0) {
                left = midpoint + 1;
            } else {
                right = midpoint - 1;
            }
        }
        if (((Comparable) a[midpoint]).compareTo(searchValue) < 0) {
            midpoint++;
        }
        return midpoint;
    }

}
