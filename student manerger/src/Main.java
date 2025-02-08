
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Student> list = new ArrayList<>();
        loop:
        while (true) {
            System.out.println("——————————欢迎来到学生管理系统————————");
            System.out.println("1.添加学生");
            System.out.println("2.删除学生");
            System.out.println("3.修改学生");
            System.out.println("4.查询学生");
            System.out.println("5.退出");
            System.out.println("请输入您的选择");
            Scanner sc = new Scanner(System.in);
            String i = sc.next();
            switch (i) {
                case "1":
                    add(list);
                    break;
                case "2":
                    delete(list);
                    break;
                case "3":
                    update(list);
                    break;
                case "4":
                    querry(list);
                    break;
                case "5":
                    break loop;
                default:
                    System.out.println("无这个选项重新输入");

            }

        }


    }

    //添加学生
    public static void add(ArrayList<Student> list) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入学生的ID");
        String Id = sc.next();
        while(true) {
            boolean flag = con(list, Id);
            if (flag) {
                System.out.println("ID已经存在，请重新输入");
                Id = sc.next();
            }
            else{
                break;
            }
        }

        System.out.println("请输入学生的姓名");
        String name = sc.next();
        System.out.println("请输入学生的年龄");
        int age = sc.nextInt();
        System.out.println("请输入学生的地址");
        String address = sc.next();
        Student s = new Student(Id, name, age, address);
        list.add(s);
        System.out.println("学生添加成功");
    }

    public static void delete(ArrayList<Student> list) {
            Scanner sc=new Scanner(System.in);
            System.out.println("请输入要删除的id");
            String id=sc.next();
            int i=index(list,id);
            if(i!=-1){
                list.remove(i);
                System.out.println("ID存在，删除成功");
            }
            else{
                System.out.println("未找到此ID");
            }
    }


    public static void update(ArrayList<Student> list) {
        System.out.println("请输入要修改的学生的ID");
        Scanner sc=new Scanner(System.in);
        String sid=sc.next();
        int i=index(list,sid);
        if(i==-1){
            System.out.println("未找到此ID");
        }
        else{
            Student stu=list.get(i);
            System.out.println("请输入该学生的姓名");
            String a=sc.next();
            stu.setname(a);
            System.out.println(stu.getName());

        }
    }

    public static void querry(ArrayList<Student> list) {
        if (list.size() == 0) {
            System.out.println("当前无学生信息");
            return;
        }
        System.out.println("id\t\t姓名\t年龄\t家庭住址\t");
        for (int i = 0; i < list.size(); i++) {
            Student st = list.get(i);
            System.out.println(st.getId() + "\t" + st.getName() + "\t" + st.getage() + "\t" + st.getaddress());
        }
    }

    public static boolean con(ArrayList<Student> list, String id) {
        for (int i = 0; i < list.size(); i++) {
            Student st=list.get(i);
            String sid=st.getId();
            if(sid.equals(id)){
                return true;
            }
        }
        return false;
    }

    public static int index(ArrayList<Student> list,String id){
        for (int i = 0; i < list.size(); i++) {
            Student stu=list.get(i);
            String sid=stu.getId();
            if(sid.equals(id)){
                return i;
            }
        }
        return -1;
    }
}
