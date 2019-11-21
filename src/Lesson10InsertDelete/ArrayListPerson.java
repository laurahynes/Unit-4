package Lesson10InsertDelete;

import java.util.ArrayList;

public class ArrayListPerson {

    public static void main(String[] args) {
        ArrayList <Person> peeps = new ArrayList();                
        /*
        .add(item) - Adds item to end of list
        .add(loc, item) - Adds item to specific location in list
        
        .get() - retrieves a COPY of the item
        .indexOf(item) - shows location of item in arraylist
        .set(loc, item) - set loc to new item
        .size() - number of items in list
        
        .remove(item) - search for item and remove it
        .remove(location) - supply location and remove it                
        */
                
        peeps.add (new Person("Andy", "male", 23));
        peeps.add (new Person("Cindy", "female", 31));
        peeps.add (new Person("Fred", "male", 54));
        peeps.add (new Person("Sue", "female", 19));
        
        showPerson(peeps);
        
        System.out.println("Inserting Meg female age 27");
                
        //where does it go?
        Person p = new Person("Meg", "female", 27);
        int loc = findInsertPoint(peeps, p);
        peeps.add(loc, p);
        
        System.out.println("Inserting Leonard and Penny");
        p = new Person("Leonard", "male", 38);
        loc = findInsertPoint(peeps, p);
        peeps.add(loc, p);
        
        p = new Person("Penny", "female", 35);
        loc = findInsertPoint(peeps, p);
        peeps.add(loc, p);
        showPerson(peeps);
        
        System.out.println("Removing Fred");
        p = new Person("Fred", "", 0);
        loc = search(peeps, p);
        peeps.remove(loc);
        showPerson(peeps);
    }
    
    public static void showPerson(ArrayList arr){
        System.out.println("------------------------------");
        for (int i = 0; i < arr.size(); i++) {
            System.out.println(arr.get(i));
        }
        System.out.println("\n------------------------------\n");
    }
    
    public static int findInsertPoint(ArrayList a, Object searchValue) {
        int left = 0;
        int right = a.size() - 1;
        int midpoint = 0;

        while (left <= right) {
            midpoint = (left + right) / 2;

            int result = ((Comparable) a.get(midpoint)).compareTo(searchValue);

            if (result < 0) {
                left = midpoint + 1;
            } else {
                right = midpoint - 1;
            }
        }
        if (((Comparable) a.get(midpoint)).compareTo(searchValue) < 0) {
            midpoint++;
        }
        return midpoint;
    }
    
    public static int search(ArrayList a, Object searchValue) {
        int left = 0;
        int right = a.size() - 1;
        while (left <= right) {
            int midpoint = (left + right) / 2;
            int result = ((Comparable) a.get(midpoint)).compareTo(searchValue);
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
    
}
