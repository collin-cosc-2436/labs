package week_4;

import java.util.Objects;

public class Student implements Comparable<Student> {

    String name;
    int age;

    public Student(String name,int age){
        this.name =name;
        this.age = age;
    }


//
    public boolean equals(Student obj){
        System.out.println("name: "+this.name);
        if(this.name.equals(obj.name) && this.age == obj.age){
            return true;
        }
        return false;
    }

    public int hashcode(){
        return Objects.hash(this.age,this.name);
    }


    @Override
    public int compareTo(Student o) {
//       return this.name.compareTo(o.name);


        if(this.age>o.age){
            return 1;
        }else if(this.age<o.age){
            return -1;
        }else{
            return 0;
        }
    }
}
