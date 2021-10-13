import com.sun.javafx.collections.MappingChange;
import java.sql.SQLOutput;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
            Map<String, String> userLoginInfo = initUI();
            boolean ok = checkNameAndPwd(userLoginInfo.get("loginName"), userLoginInfo.get("loginPwd"));
            {
                if (ok == true) {
                    System.out.println("登陆成功");
                    System.out.println("---1:学生信息录入---");
                    System.out.println("---2:课程录入---");
                    System.out.println("---3:管理员注册---");
                    System.out.println("---4:管理员注销");
                    System.out.println("---5:选课维护---");
                    System.out.println("---6:推出系统---");
                    System.out.print("请输入你的选择:");
                    int select = sc.nextInt();
                    switch (select) {
                        case 1:
                            System.out.println("学生信息录入");
                            break;
                        case 2:
                            System.out.println("课程录入");
                            break;
                        case 3:
                            System.out.println("管理员注册");
                            break;
                        case 4:
                            System.out.println("管理员注销");
                            break;
                        case 5:
                            System.out.println("选课维护");
                            break;
                        default:
                            System.out.println("对不起您的输入有误，请重新选择！");
                    }
                }
            }
    }
    public static boolean checkNameAndPwd(String loginName,String loginPwd){
        return false;
    }
    public static Map<String,String> initUI(){
        System.out.println("欢迎使用该系统，请输入信息进行验证");
        Scanner s=new Scanner(System.in);
        System.out.print("用户名:");
        String logiName=s.next();
        System.out.print("密码:");
        String loginPwd= s.next();
    //    将用户名和密码封装到Map集合中
        Map<String,String> userLoginInfo=new HashMap<>();
        userLoginInfo.put("loginName",logiName);
        userLoginInfo.put("loginPwd",loginPwd);
        return userLoginInfo;
    }
}
