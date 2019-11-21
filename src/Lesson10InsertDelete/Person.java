package Lesson10InsertDelete;

public class Person implements Comparable {
    private String name, gender;
    private int age;
    
    public Person(String n, String g, int a){
        name = n;
        gender = g;
        age = a;
    }
    
    public String getName(){
        return name;
    }
    
    public String toString(){
        //Bob: age 12, male
        return name + ": Age " + age + ", " + gender;
    }
    
    public String getGender(){
        return gender;
    }
    
    public int getAge(){
        return age;
    }

    @Override
    public int compareTo(Object t) {
        String othername = ((Person)t).getName();
        return name.compareTo(othername);
    }
}
