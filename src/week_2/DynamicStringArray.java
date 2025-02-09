package week_2;

public class DynamicStringArray {

    private String[] data;
    private int cap=10;
    private int idx =0;
    public DynamicStringArray(){
        data = new String[cap];
    }

    public void addName(String name) {
        if(idx==data.length){
           //create new array with higher size
            String[] temp = new String[cap * 2];
            //copy the content of data;

            data = temp;
        }
        data[idx++] = name;
    }

    public String toString(){
        String names = "";
        for(String name:this.data){
            names+=" "+name;
        }
        return names;
    }
}
