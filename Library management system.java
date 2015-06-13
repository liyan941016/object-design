package guide;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import object.Admin;
import object.Student;
import object.Teacher;
import object.User;

public class Guidence {
	List<String> list=new ArrayList<String>();
	BufferedReader br;
	public boolean login(String name,int password){
		boolean flag=false;
		try {
			br=new BufferedReader(new FileReader(new File("./txt/library.txt")));
			String str=null;
			while((str=br.readLine())!=null){
				if (!"".equals(str)) {
					list.add(str);
				}
			}
//			System.out.println(name+"-"+password);
//			System.out.println(list);
			br.close();
		
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		for (String str1 : list) {
//			System.out.println(str1+"   "+name+"           "+password);
			if (str1.contains(name)&&str1.contains(password+"")) {
				flag=true;
				break;
				
			}else{
				flag=false;
			}
		}
		return flag;
	}
	
	public User geInformation(String name,int password){
		int count=0;
		String info = null;
		for (String str : list) {
			
			if (str.indexOf(name+"-"+password)!=-1) {
				info=list.get(count);
			}else{
				count++;
			}
		}
		String[]s=info.split("-");
		if (s.length==6) {
			Admin a=new Admin();
			a.setId(Integer.parseInt(s[0]));
			a.setName(s[1]);
			a.setPassWord(Integer.parseInt(s[2]));
			a.setAge(Integer.parseInt(s[3]));
			a.setAd_id(Integer.parseInt(s[4]));
			a.setLimit(s[5]);
			return a;
		}else if  (s.length==8) {
			Teacher t=new Teacher();
			t.setId(Integer.parseInt(s[0]));
			t.setName(s[1]);
			t.setPassWord(Integer.parseInt(s[2]));
			t.setAge(Integer.parseInt(s[3]));
			t.setGender((s[4]));
			t.setlend(Integer.parseInt(s[5]));
			t.setReturn(Integer.parseInt(s[6]));
			t.setLevel(s[7]);
			return t;
		}else   {
			Student stu=new Student();
			stu.setId(Integer.parseInt(s[0]));
			stu.setName(s[1]);
			stu.setPassWord(Integer.parseInt(s[2]));
			stu.setAge(Integer.parseInt(s[3]));
			stu.setGender((s[4]));
			stu.setlend(Integer.parseInt(s[5]));
			stu.setReturn(Integer.parseInt(s[6]));
			return stu;
		}
	}
}
package object;
/**
 * 用户对象
 * @author cz
 *
 */
public class User {
	public int id;
	public String name;
	public int age;
	public int passWord;
	
	/**
	 * User构造方法
	 * @param Id 账户id
	 * @param Name 账户姓名
	 * @param Age 账户年龄
	 * @param PassWord 账户密码
	 */
	public User(int Id,String Name,int Age,int PassWord){
		this.id = Id;
		this.name = Name;
		this.age = Age;
		this.passWord = PassWord;
	}
	public User(){
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getPassWord() {
		return passWord;
	}
	public void setPassWord(int passWord) {
		this.passWord = passWord;
	}
	
}


package object;
/**
 * 管理员对象
 * @author cz
 *
 */
public class Admin extends User{
	private int ad_id;
	private String limit;
	
	/**
	 * Admin构造方法
	 * @param A_ad_id 管理员ID
	 * @param A_limit 管理员限制
	 * @param A_id 管理员账户id
	 * @param A_name 管理员账户姓名
	 * @param A_age 管理员账户年龄
	 * @param A_passWord 管理员密码
	 */
	public Admin(int A_ad_id,String A_limit,int A_id,String A_name,int A_age,int A_passWord){
		super();
		this.ad_id = A_ad_id;
		this.limit = A_limit;
	}
	public Admin(){
		
	}
	public int getAd_id() {
		return ad_id;
	}
	public void setAd_id(int ad_id) {
		this.ad_id = ad_id;
	}
	public String getLimit() {
		return limit;
	}
	public void setLimit(String limit) {
		this.limit = limit;
	}
	@Override
	public String toString() {
		return "您好，您是管理员用户      \n你的管理id:" + getAd_id() +"\n你所拥有的权限:" + getLimit()
				+ "\n你的用户id：" + getId() + "\n你的名字：" + getName()
				+ "\n你的年龄：" + getAge() ;
	}
	
}


：
package object;
/**
 * 读者对象
 * @author cz
 *
 */
public class Lreader extends User {
	public String Gender;//性别
	public int lend;//借出
	public int Return;//归还
	
	/**
	 * Reader构造方法
	 * @param R_gender 性别
	 * @param R_lend 借出
	 * @param R_return 归还
	 * @param R_id id
	 * @param R_name 姓名
	 * @param R_age 年龄
	 * @param R_passWord 密码
	 */
	public Lreader(String R_gender,int R_lend,int R_return,int R_id,String R_name,int R_age,int R_passWord){
		super();
		this.Gender = R_gender;
		this.lend = R_lend;
		this.Return = R_return;
	}
	public Lreader(){
		super();
	}
	
	public String getGender() {
		return Gender;
	}
	public void setGender(String sex) {
		this.Gender = sex;
	}
	public int getlend() {
		return lend;
	}
	public void setlend(int take) {
		this.lend = take;
	}
	public int getReturn() {
		return Return;
	}
	public void setReturn(int revert) {
		this.Return = revert;
	}
	
	
}


package object;
public class Student extends Lreader {
	public String lclass;//学生的班级
	public String adress;//地址
	
	/**
	 * Student构造方法
	 * @param S_lclass 学生的班级
	 * @param S_adress 地址
	 * @param S_gender 性别
	 * @param S_lend 借出
	 * @param S_return 归还
	 * @param S_id id
	 * @param S_name 姓名
	 * @param S_age 年龄
	 * @param S_passWord 密码
	 */
	public Student(String S_lclass,String S_adress,String S_gender,int S_lend,int S_return,int S_id,String S_name,int S_age,int S_passWord){
		super(S_gender,S_lend,S_return,S_id,S_name,S_age,S_passWord);
		this.lclass = S_lclass;
		this.adress = S_adress;
	}
	public Student(){
		super();
	}
	
	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public String getlclass() {
		return lclass;
	}

	public void setlclass(String sclass) {
		this.lclass = sclass;
	}
	
	@Override
	public String toString() {
		return "您好，您是读者用户  你是一名学生 \n你的班级： " + getClass()+"\n你的住址： " + getAdress()  + "\n你的性别" + getGender()
				+ "\n你已借了：" + getlend() + "\n你已还：" + getReturn()
				+ "\n你的用户id：" + getId() + "\n你的名字：" + getName()
				+ "\n你的年龄：" + getAge() ;
	}
}


package object;
public class Teacher extends Lreader {
	public String level;//级别：讲师/教授/助教 
	
	/**
	 * Teacher构造方法
	 * @param T_level 级别
	 * @param T_gender 性别
	 * @param T_lend 借出
	 * @param T_return 归还
	 * @param T_id id
	 * @param T_name 姓名
	 * @param T_age 年龄
	 * @param T_passWord 密码
	 */
	public Teacher(String T_level,String T_gender,int T_lend,int T_return,int T_id,String T_name,int T_age,int T_passWord){
		super(T_gender,T_lend,T_return,T_id,T_name,T_age,T_passWord);
		this.level = T_level;
	}
	public Teacher(){
		
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	@Override
	public String toString() {
		return "您好，您是读者用户  你是一名老师  \n你的级别： " + getLevel() + "\n你的性别" + getGender()
				+ "\n你已借了：" + getlend() + "\n你已还：" + getReturn()
				+ "\n你的用户id：" + getId() + "\n你的名字：" + getName()
				+ "\n你的年龄：" + getAge() + "]";
	}
	
}


package test;

import guide.Guidence;

import java.util.Scanner;

import object.User;

/**
 * 图书管理系统
 * zhu（）主界面
 * login（）登陆
 * entry（）进入
 * @author cz
 *
 */
public class LibraryManage {
	Scanner input =new Scanner(System.in);
	boolean denglu =false;
	User user;
	public static void main(String[] args) {
		try {
			new LibraryManage().zhu();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void zhu() throws Exception {
		if(denglu){

			System.out.println(".............欢迎使用齐鲁工业大学图书管理系统..............");
			System.out.println("..                      【0】用户登录                                       ..");
			System.out.println("..                      【1】用户注册                                       ..");
			System.out.println("..                      【2】信息查询                                       ..");
			System.out.println("..                      【3】退出系统                                       ..");
			System.out.println("................................................");
			System.out.println();
			System.out.println();
			System.out.println("登陆成功，你的信息为：");
		}else {
			System.out.println("..............欢迎使用齐鲁工业大学图书管理系...............");
			System.out.println("..                      【0】用户登录                                          ..");
			System.out.println("..                      【2】信息查询                                          ..");
			System.out.println("..                      【3】退出系统                                          ..");
			System.out.println("..                                                                          |");
			System.out.println(".................................................");
			System.out.println(".................................................");
			System.out.println();	
			System.out.println("请输入指令：");
		}
		//用while
		//循环
		System.out.println(".............................");
		String str=null;
		while (input.hasNext()) {
			str=input.nextLine();
			 if("0".equals(str)) {
				 if (denglu) {
					System.out.println("已登录，无需登录");
				}else {
					login();
				}
			 }else if("1".equals(str)) {
				 System.out.println("对不起！功能未开发！！！");
			} else if("2".equals(str)) {
				 System.out.println("对不起！功能未开发！！！");
			} else if("3".equals(str)) {
				System.out.println("已成功退出   欢迎下次使用！");
				System.exit(1);
			}else {
				System.out.println("无此功能，请重新输入：");
				zhu();
			}
		}
	}

	private void login() {
		System.out.println("请输入你的用户名：");
		String name=input.nextLine();
		System.out.println("请输入你的密码：");
		int password=input.nextInt();
		Guidence ld=new Guidence();
		if (ld.login(name, password)) {
			System.out.println("恭喜你，登陆成功！");
			user=ld.geInformation(name, password);
			enetry(user);
		}else{
			System.out.println("sorry!用户名或密码输入错误！返回主界面");
			try {
				zhu();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	private void enetry(User user) {
		System.out.println(user.toString());
		System.out.println("按0退出系统");
		if (input.nextInt()==0) {
			System.out.println("欢迎使用，再见");
			System.exit(1);
		}else{
			try {
				zhu();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
