package com.system.view;
import com.system.beans.AdministarLogin;
import com.system.beans.StuCourse;
import com.system.beans.Students;
import com.system.utils.JDBCUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;
public class MainView {
    private Scanner sc = new Scanner(System.in);

    public void run() throws Exception {
        while (true) {
            System.out.println("---欢迎使用宝鸡文理学院学生选课管理系统---");
            System.out.print("---请选择学生登陆或管理员登陆:");
            int Ruler = sc.nextInt();
            sc.nextLine();
            if (Ruler == 1) {
                System.out.print("请输入密码:");
                int password = sc.nextInt();
                sc.nextLine();
                if(password==new AdministarLogin().getPassword()){
                    System.out.println("欢迎管理");
                    System.out.println("---1:学生信息录入---");
                    System.out.println("---2:课程录入---");
                    System.out.println("---3:管理员注册---");
                    System.out.println("---4:管理员注销");
                    System.out.println("---5:学生选课统计功能---");
                    System.out.println("---6:选课维护---");
                    System.out.print("请输入你的选择:");
                    int select = sc.nextInt();
                    sc.nextLine();
                    switch (select) {
                        case 1:
                            // 学生信息录入
                            addStudentMessage();
                            break;
                        case 2:
                            addCourseMessage();
                            break;
                        case 3:
                            addAdministarLogin();
                            break;
                        case 4:
                            deleteAdministarByID();
                            break;
                        case 5:
                            selectAllStudent();
                            break;
                        case 6:
                            System.out.println("---1:删除学生信息---");
                            System.out.println("---2:修改学生所选课程---");
                            System.out.println("---3:删除课程信息---");
                            System.out.println("---4:修改课程信息---");
                            System.out.print("请输入所需功能:");
                            int aSelect = sc.nextInt();
                            sc.nextLine();
                            switch (aSelect) {
                                case 1:
                                    deleteStudentByNumber();
                                    break;
                                case 2:
                                    changeStudentCourse();
                                    break;
                                case 3:
                                    deleteCourse();
                                    break;
                                case 4:
                                    changeCourseMessage();
                                    break;
                                default:
                                    System.out.println("对不起您的输入有误，请重新输入");
                                    break;
                            }
                            break;
                        default:
                            System.out.println("对不起您的输入有误，请重新选择！");
                            break;
                    }
                }
                else{
                    System.out.println("密码错误");
                }
            }
            if (Ruler == 0) {
                {
                    System.out.println("欢迎同学");
                    System.out.println("---1:选择课程---");
                    System.out.println("---2:选课查询---");
                    System.out.print("请输入您的选择:");
                    int select = sc.nextInt();
                    sc.nextLine();
                    switch (select) {
                        case 1:
                            selectCourse();
                            break;
                        case 2:
                            StudentSee();
                            break;
                        default:
                            System.out.println("对不起您的输入有误，请重新选择！");
                            break;
                    }
                }
            }
        }
    }

    //    添加学生信息
    public void addStudentMessage() throws SQLException {
        System.out.print("请录入学员姓名:");
        String sName = sc.nextLine();
        System.out.print("请录入学生年龄:");
        String sAge = sc.nextLine();
        System.out.print("请录入学生学号:");
        String sNumber = sc.nextLine();
        System.out.print("请录入学员性别:");
        String sSex = sc.nextLine();
        int sAge2 = Integer.parseInt(sAge);
        Connection con = JDBCUtils.getConnection();
        String sql = "insert into Students(sName,sAge,sNumber,sSex) values (?, ?, ?,?)";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, sName);
        ps.setInt(2, sAge2);
        ps.setString(3, sNumber);
        ps.setString(4, sSex);
        int row = ps.executeUpdate();
        System.out.println(row != 0 ? "添加成功" : "添加失败");
        JDBCUtils.close(con, ps);
    }

    //课程信息添加
    public void addCourseMessage() throws Exception {
        System.out.print("请录入课程名称:");
        String cCourse = sc.nextLine();
        System.out.print("请输入课程编号:");
        String cID = sc.nextLine();
        System.out.print("请输入学分:");
        int cCredit = sc.nextInt();
        sc.nextLine();
        Connection con = JDBCUtils.getConnection();
        String sql = "insert into Course(cCourse,cID,cCredit) values (?, ?, ?)";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, cCourse);
        ps.setString(2, cID);
        ps.setInt(3, cCredit);
        int row = ps.executeUpdate();
        System.out.println(row != 0 ? "添加成功" : "添加失败");
        JDBCUtils.close(con, ps);
    }

    //管理员注册
    public void addAdministarLogin() throws Exception {
        System.out.print("请输入姓名:");
        String aName = sc.nextLine();
        System.out.print("请输入年龄:");
        int aAge = sc.nextInt();
        System.out.print("请输入性别:");
        sc.nextLine();
        String aSex = sc.nextLine();
        System.out.print("请输入ID:");
        String aID = sc.nextLine();
        Connection con = JDBCUtils.getConnection();
        String sql = "insert into AdministarLogin(aName,aAge,aSex,aID) values (?,?,?,?)";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, aName);
        ps.setInt(2, aAge);
        ps.setString(3, aSex);
        ps.setString(4, aID);
        int row = ps.executeUpdate();
        System.out.println(row != 0 ? "添加成功" : "添加失败");
        JDBCUtils.close(con, ps);
    }

    // 根据工号删除管理员信息
    public void deleteAdministarByID() throws Exception {
        System.out.print("请录入要删除的管理员工号:");
        String aID = sc.nextLine();
        System.out.print("你确定要删除吗? y or n");
        String select = sc.nextLine();
        if (select.equals("n")) {
            return;
        }
        Connection con = JDBCUtils.getConnection();
        String sql = "delete from AdministarLogin where aID = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, aID);
        int row = ps.executeUpdate();
        System.out.println(row != 0 ? "删除管理员成功" : "删除管理员失败");
        JDBCUtils.close(con, ps);
    }

    //删除学生信息
    public void deleteStudentByNumber() throws Exception {
        System.out.print("请输入要删除的学生学号:");

        String sNumber = sc.nextLine();
        System.out.print("你确定要删除吗? y  or n");
        String select = sc.nextLine();
        if (select.equals("n")) {
            return;
        }
        Connection con = JDBCUtils.getConnection();
        String sql = "delete from Students where sNumber=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, sNumber);
        int row = ps.executeUpdate();
        System.out.println(row != 0 ? "删除成功" : "删除失败");
        JDBCUtils.close(con, ps);
    }

    //修改学生所选科目
    public void changeStudentCourse() throws Exception {
        System.out.print("请录入要修改学生的学号:");
        sc.nextLine();
        String stuID = sc.nextLine();
        System.out.print("请录入该生所选新科目:");
        String couID = sc.nextLine();
        Connection con = JDBCUtils.getConnection();
        String sql = "update StuCourse set couID = ? where stuID = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, couID);
        ps.setString(2, stuID);
        int row = ps.executeUpdate();
        System.out.println(row != 0 ? "修改成功" : "修改失败");
        JDBCUtils.close(con, ps);
    }

    //删除课程
    public void deleteCourse() throws Exception {
        System.out.print("请输入要删除的课程编号:");

        String cID = sc.nextLine();
        Connection con = JDBCUtils.getConnection();
        String sql = "delete from Course where cID=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, cID);
        int row = ps.executeUpdate();
        System.out.println(row != 0 ? "删除成功" : "删除失败");
        JDBCUtils.close(con, ps);
    }

    //修改课程信息
    public void changeCourseMessage() throws SQLException {
        System.out.print("请录入要修改课程的编号:");
        String cID = sc.nextLine();
        System.out.print("请录入该课程的新学分:");
        int cCredit = sc.nextInt();
        sc.nextLine();
        Connection con = JDBCUtils.getConnection();
        String sql = "update Course set cCredit=? where cID= ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1,cCredit);
        ps.setString(2, cID);
        int row = ps.executeUpdate();
        System.out.println(row != 0 ? "修改成功" : "修改失败");
        JDBCUtils.close(con, ps);
    }

    //学生选课统计
    public void selectAllStudent() throws Exception {
        Connection con = JDBCUtils.getConnection();
        String sql = "select * from StuCourse";
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet set = ps.executeQuery();
        ArrayList<StuCourse> list = new ArrayList<>();
        while (set.next()) {
            String stuID = set.getString("stuID");
            String couID = set.getString("couID");
            StuCourse s = new StuCourse(stuID, couID);
            list.add(s);
        }
        JDBCUtils.close(set, ps, con);
        for (StuCourse stucourse : list) {
            System.out.println(stucourse);
        }
    }

    //学生选择课程
    public void selectCourse() throws SQLException {
        System.out.print("请输入学生学号:");
        String stuID = sc.nextLine();
        System.out.print("请输入所选科目编号:");
        String couID = sc.nextLine();
        Connection con = JDBCUtils.getConnection();
        String sql = "insert into StuCourse(stuID,couID) values (?,?)";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, stuID);
        ps.setString(2, couID);
        int row = ps.executeUpdate();
        System.out.println(row != 0 ? "添加成功" : "添加失败");
        JDBCUtils.close(con, ps);
    }

    //选课查询
    public void StudentSee() throws Exception {
        Connection con = JDBCUtils.getConnection();
        System.out.print("请输入学号:");
        String stuID=sc.nextLine();
        String sql = "select *from StuCourse where stuID=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1,stuID);
        ResultSet set = ps.executeQuery();
        ArrayList<StuCourse> list = new ArrayList<>();
        while (set.next()) {
            String sstuID = set.getString("stuID");
            String ccouID=set.getString("couID");
            StuCourse s = new StuCourse(sstuID,ccouID);
            list.add(s);
        }
        JDBCUtils.close(set, ps, con);
        for (StuCourse stucourse : list) {
            System.out.println(stucourse);
        }
    }
}



