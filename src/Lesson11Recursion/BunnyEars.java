package Lesson11Recursion;

import java.util.ArrayList;

public class BunnyEars {

    ArrayList<Integer> testdata; //data being sent in
    ArrayList<Integer> expected; //expected results
    String id;
    
    static ArrayList<int[]> testing;
    
    BunnyEars(ArrayList<Integer> al, ArrayList<Integer> ex, String name){
        testdata = al;
        expected = ex;
        id = name;
    }
    
     
    
    //the actual method that solves the problem
    public int solve(int bunnies){
        if(bunnies == 0){
            return 0;
        } else {
            return 2 + solve(bunnies - 1);
        }
    }
        
    //testing the method with test data and comparing results
    public void test(){
        System.out.println("Expected\t\tRun\tResult");
        System.out.println("=====================================");
        for (int i = 0; i < testdata.size(); i++) {
            String output = id + " (" + testdata.get(i) + ")-> " + expected.get(i);
            System.out.print(String.format("%-25s", output));//puts question into 25 even spaces
            int result = solve(testdata.get(i));
            String status = result ==expected.get(i)? "OK" : "FAIL";
            System.out.println(result + "\t" + status);
        }
    }
    
    public static void main(String[] args) {
        ArrayList<Integer> in = new ArrayList();
        ArrayList<Integer> out= new ArrayList();
        //add test data
        in.add(0); in.add(1); in.add(2);
        in.add(3); in.add(4); in.add(5);
        in.add(12); in.add(50); in.add(234);
        //add expected results
        out.add(0); out.add(2); out.add(4);
        out.add(6); out.add(8); out.add(10);
        out.add(24); out.add(100); out.add(468);
        //create problem
        BunnyEars prob = new BunnyEars(in, out, "BunnyEars");
        //run the test
        prob.test();                
    }
    
}
