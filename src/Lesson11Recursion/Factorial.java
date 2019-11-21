package Lesson11Recursion;

public class Factorial {

    public static void main(String[] args) {
        int x = 5;
        System.out.println(x + "! = " + fact1(x));
        System.out.println(x + "! = (Recursive)" + factr(x));
        //System.out.println(x + "! = (Bad Method)" + badMethod(x));
    }
    
    public static int factr(int num){
        if(num == 1)
            return 1;
        else
            return num * factr(num-1);
    }
    
    public static int fact1(int num){
        int answer = num; //5
        //4, 3, 2, 1
        for (int i = num-1; i >=1; i--) {
            answer = answer * i;            
        }
        return answer;
    }
    
    //this may cause stack overflow if called for num < 7
    public static int badMethod( int num){
        if(num == 7)
            return 7;
        else return badMethod(num - 1);
    }
    
}
