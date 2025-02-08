public class Student {
    private String id;
    private String name;
    private int age;
    private String address;
public Student(){

}
public Student(String id,String name,int age,String address){
    this.id=id;
    this.name=name;
    this.address=address;
    this.age=age;
}
public String getId(){
    return id;
}

public void setId(String id){
    this.id=id;
}

    public String getName(){
        return name;
    }

    public void setname(String name){
        this.name=name;
    }
    public int getage(){
        return age;
    }

    public void setage(int id){
        this.age=age;
    }
    public String getaddress(){
        return address;
    }

    public void setaddress(String address){
        this.address=address;
    }

}
