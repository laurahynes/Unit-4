package Lesson11Recursion;

public class TheSimpsons {

    public static String start[] = {"Simpsons in Cave", "Lisa Trapped with Burns", "Burns at Moe's", "Moe with Edna", "Edna in School"};
    public static String end[] = {"Simpsons leave cave", "Lisa takes picture with Burns", "Burns gets gold", "Moe puts gold in machine", "Edna stays on as teacher"};
    
    public static void main(String[] args) {
        story(0);
    }      
    
    public static void story(int s){
        System.out.println(start[s]);        
        if(s < start.length - 1)
            story(s+1);
        System.out.println(end[s]);
    }
}
