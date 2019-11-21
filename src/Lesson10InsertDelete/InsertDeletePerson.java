package Lesson10InsertDelete;

public class InsertDeletePerson {

    static int logicalSize = 0;
    public static void main(String[] args) {
        Person peeps[] = new Person[10];
        peeps[0] = new Person("Andy", "male", 23);
        peeps[1] = new Person("Cindy", "female", 31);
        peeps[2] = new Person("Fred", "male", 54);
        peeps[3] = new Person("Sue", "female", 19);        
        logicalSize = 4;
        showPerson(peeps);
        System.out.println("Inserting Meg (female age 27");
                
        //where does it go?
        Person p = new Person("Meg", "female", 27);
        int loc = findInsertPoint(peeps, p);        
        insert(peeps, p, loc);
        showPerson(peeps);
        System.out.println("Inserting Leonard and Penny");
        p = new Person("Leonard", "male", 38);
        loc = findInsertPoint(peeps, p);
        insert(peeps, p, loc);
        p = new Person("Penny", "female", 35);
        loc = findInsertPoint(peeps, p);
        insert(peeps, p, loc);
        showPerson(peeps);
        
               
        ////////////////////////TESTING DELETE/////////////////////////////
        System.out.println("Removing Fred");
        p = new Person("Fred", "", 0);
        loc = search(peeps, p);
        delete(peeps,loc);
        showPerson(peeps);
    }
    
    public static void showPerson(Object arr[]){
        System.out.println("------------------------------");
        for (int i = 0; i < logicalSize; i++) {
            System.out.println(arr[i]);
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

