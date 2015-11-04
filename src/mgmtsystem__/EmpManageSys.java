package mgmtsystem__;

import java.sql.*;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
public class EmpManageSys implements ActionListener {
Connection con;
Statement stmt;
String sql;
ResultSet rs;
StringBuffer sb = new StringBuffer();
JTextField jtf2 = new JTextField("蒋暕青",10);
JTextField jtf3 = new JTextField(10);
JTextField jtf4 = new JTextField(10);
JTextField jtf7 = new JTextField(10);
JTextField jtf5 = new JTextField(10);
JTextField jtf6 = new JTextField(10);
JTextField jtf8 = new JTextField(10);
JTextField jtf9 = new JTextField(10);
JTextArea jta10 = new JTextArea(50, 40);

public void actionPerformed(ActionEvent e) {
String str = e.getActionCommand();
if ("查询".equals(str)) {
//if check the button of 查询，then go to method of searchEmp()
searchEmp();
} else if ("增加".equals(str)) {
//if check the button of 增加，then go to method of addEmp()
addEmp();
} else if ("修改".equals(str)) {
//if check the button of 修改，then go to method of alterEmp()
alterEmp();
} else if ("撤除".equals(str)) {
//if check the button of 撤除，then go to method of deleteEmp()
deleteEmp();
}
}
//this is the constructor.
EmpManageSys() {
createGUI();
connectToDataBase();
// searchEmp();
// addEmp();
// deleteEmp();
alterEmp();
}
//connect to the database by using the method getConnection from the class of JdbcUtil.
//You can find the class of JdbcUtil at the button of this page.
public Connection connectToDataBase() {
try {
	con = JdbcUtil.getConnection();
} catch (Exception e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
System.out.println(con);
return con;
}
public void searchEmp() {
jta10.setText("");
try {
stmt = con.createStatement();
// sql = "select * from data where id=" + jtf3.getText();
// sql1="select * from sd100343 where ="+jtf3.getText();
//sql = "select * from data where chineseName ='jtf2.getText().toLowerCase().trim()' or id='jtf3.getText().toLowerCase().trim()' or engName='jtf4.getText().toLowerCase().trim()' or UNIT='jtf5.getText().toLowerCase().trim()' or TEAM='jtf6.getText().toLowerCase().trim()' or Phone='jtf7.getText().toLowerCase().trim()' or region='jtf8.getText().toLowerCase().trim()' or busStation='jtf9.getText().toLowerCase().trim()'";
String a = jtf2.getText().toLowerCase().trim();
String b = jtf3.getText().toLowerCase().trim();
String c = jtf4.getText().toLowerCase().trim();
String d = jtf5.getText().toLowerCase().trim();
String e = jtf6.getText().toLowerCase().trim();
String f = jtf7.getText().toLowerCase().trim();
String g = jtf8.getText().toLowerCase().trim();
String h = jtf9.getText().toLowerCase().trim();
sql ="select * from data where chineseName="+"'"+a+"'"+" or id ="+"'"+b+"'"+" or engName="+"'"+c+"'"+" or UNIT="+"'"+d+"'"+" or TEAM="+"'"+e+"'"+" or Phone="+"'"+f+"'"+" or region="+"'"+g+"'"+" or busStation ="+"'"+h+"'";
/*sql = "select from data where chineseName="
+ jtf2.getText().toLowerCase().trim() + "or id=" 
+ jtf3.getText().toLowerCase().trim() + "or engName="
+ jtf4.getText().toLowerCase().trim() + "or UNIT="
+ jtf5.getText().toLowerCase().trim() + "or TEAM="
+ jtf6.getText().toLowerCase().trim() + "or Phone="
+ jtf7.getText().toLowerCase().trim() + "or region="
+ jtf8.getText().toLowerCase().trim() + "or busStation="
+ jtf9.getText().toLowerCase().trim();*/
stmt.executeQuery(sql);
rs = stmt.getResultSet();
ResultSetMetaData meta = rs.getMetaData();
int cols = meta.getColumnCount();
while (rs.next()) {
for (int i = 1; i <= cols; i++) {
sb.append(" " + meta.getColumnName(i) + " =");
sb.append(rs.getString(i));
}
sb.append("\n");
jta10.setText(sb.toString());
}
} catch (SQLException e11) {
e11.printStackTrace();
}
}
public void addEmp() {
try {
stmt = con.createStatement();
String a = jtf2.getText().toLowerCase().trim();
String b = jtf3.getText().toLowerCase().trim();
String c = jtf4.getText().toLowerCase().trim();
String d = jtf5.getText().toLowerCase().trim();
String e = jtf6.getText().toLowerCase().trim();
String f = jtf7.getText().toLowerCase().trim();
String g = jtf8.getText().toLowerCase().trim();
String h = jtf9.getText().toLowerCase().trim();
//sql ="insert data chineseName="+"'"+a+"'"+","+"id="+"'"+b+"'"+","+"engName="+"'"+c+"'"+","+" or UNIT="+"'"+d+"'"+","+" or TEAM="+"'"+e+"'"+","+" or Phone="+"'"+f+"'"+","+" or region="+"'"+g+"'"+","+" or busStation ="+"'"+h+"'";
sql ="insert data (chineseName,id,engName,UNIT,TEAM,Phone,region,busStation)"+ "values"+"("+"'"+a+"'"+","+"'"+b+"'"+","+"'"+c+"'"+","+"'"+d+"'"+","+"'"+e+"'"+","+"'"+f+"'"+","+"'"+g+"'"+","+"'"+h+"'"+")";
//insert date (chineseName,id) values (3,5)
/*sql = "update data values(" + "'"+jtf2.getText()+"'" + "'"+jtf3.getText()+"'"
+ "'"+jtf4.getText()+"'" + "'"+jtf5.getText()+"'" + "'"+jtf6.getText()+"'"
+ "'"+jtf7.getText()+"'" + "'"+jtf8.getText()+"'" + "'"+jtf9.getText()+"'" + ")";*/
int i = stmt.getUpdateCount();
if ((jtf2.getText() != null) && (jtf6.getText() != null)) {
stmt.executeUpdate(sql);
jta10.setText("添加记录成功" + i + "条");
} else {
jta10.setText("带*号项为添加记录时不能为空");
}
} catch (SQLException e1) {
e1.printStackTrace();
}
}
public void deleteEmp() {
searchEmp();
try {
stmt = con.createStatement();
String a = jtf2.getText().toLowerCase().trim();
String b = jtf3.getText().toLowerCase().trim();
String c = jtf4.getText().toLowerCase().trim();
String d = jtf5.getText().toLowerCase().trim();
String e = jtf6.getText().toLowerCase().trim();
String f = jtf7.getText().toLowerCase().trim();
String g = jtf8.getText().toLowerCase().trim();
String h = jtf9.getText().toLowerCase().trim();
sql ="delete from data where chineseName="+"'"+a+"'"+" or id ="+"'"+b+"'"+" or engName="+"'"+c+"'"+" or UNIT="+"'"+d+"'"+" or TEAM="+"'"+e+"'"+" or Phone="+"'"+f+"'"+" or region="+"'"+g+"'"+" or busStation ="+"'"+h+"'";
/*sql = "delete from data where chineseName="
+"'"+jtf2.getText().toLowerCase().trim() +"'"+"or id="
+"'"+jtf3.getText().toLowerCase().trim() +"'"+"or engName="
+"'"+jtf4.getText().toLowerCase().trim() +"'"+"or UNIT="
+"'"+jtf5.getText().toLowerCase().trim() +"'"+"or TEAM="
+"'"+jtf6.getText().toLowerCase().trim() +"'"+"or Phone="
+"'"+jtf7.getText().toLowerCase().trim() +"'"+"or region="
+"'"+jtf8.getText().toLowerCase().trim() +"'"+"or busStation="
+"'"+jtf9.getText().toLowerCase().trim();*/
stmt.executeUpdate(sql);
int i = stmt.getUpdateCount();
jta10.setText("撤除操作成功" + i + "条");
} catch (SQLException e) {
e.printStackTrace();
}
}
public void alterEmp() {
searchEmp();
String a = jtf2.getText().toLowerCase().trim();
String b = jtf3.getText().toLowerCase().trim();
String c = jtf4.getText().toLowerCase().trim();
String d = jtf5.getText().toLowerCase().trim();
String e = jtf6.getText().toLowerCase().trim();
String f = jtf7.getText().toLowerCase().trim();
String g = jtf8.getText().toLowerCase().trim();
String h = jtf9.getText().toLowerCase().trim();
sql ="update data set id="+"'"+b+"'"+","+"engName ="+"'"+c+"'"+","+"UNIT="+"'"+d+"'"+","+"TEAM="+"'"+e+"'"+","+"Phone="+"'"+f+"'"+","+"region="+"'"+g+"'"+","+"busStation ="+"'"+h+"'"+ "where chineseName="+"'"+a+"'";
/*sql = "update from data where chineseName="
		+"'"+jtf2.getText().toLowerCase().trim() +"'"+"or id="
		+"'"+jtf3.getText().toLowerCase().trim() +"'"+"or engName="
		+"'"+jtf4.getText().toLowerCase().trim() +"'"+"or UNIT="
		+"'"+jtf5.getText().toLowerCase().trim() +"'"+"or TEAM="
		+"'"+jtf6.getText().toLowerCase().trim() +"'"+"or Phone="
		+"'"+jtf7.getText().toLowerCase().trim() +"'"+"or region="
		+"'"+jtf8.getText().toLowerCase().trim() +"'"+"or busStation="
		+"'"+jtf9.getText().toLowerCase().trim();*/
int i = 0;
try {
stmt.executeUpdate(sql);
i = stmt.getUpdateCount();
} catch (SQLException e1) {
e1.printStackTrace();
}
jta10.setText("修改操作成功" + i + "条");
}
public void createGUI() {
JFrame jf = new JFrame("客户信息管理系统");
jf.setLayout(new GridLayout(2, 1));
// jf.setLayout(new GridLayout(10,2));
JPanel jp00 = new JPanel(new GridLayout(5, 4));
JPanel jp1 = new JPanel();
JButton jb11 = new JButton("查询");
jb11.addActionListener(this);
JButton jb12 = new JButton("增加");
jb12.addActionListener(this);
jp1.add(jb11);
jp1.add(jb12);
jp00.add(jp1);
JPanel jp11 = new JPanel();
JButton jb111 = new JButton("修改");
jb111.addActionListener(this);
JButton jb112 = new JButton("撤除");
jb112.addActionListener(this);
jp11.add(jb111);
jp11.add(jb112);
jp00.add(jp11);
JPanel jp2 = new JPanel();
JLabel jl2 = new JLabel("姓名 * ");
jp2.add(jl2);
jp2.add(jtf2);
jp00.add(jp2);
JPanel jp3 = new JPanel();
JLabel jl3 = new JLabel("国籍 ");
jp3.add(jl3);
jp3.add(jtf3);
jp00.add(jp3);
JPanel jp4 = new JPanel();
JLabel jl4 = new JLabel("邮箱*");
jp4.add(jl4);
jp4.add(jtf4);
jp00.add(jp4);
JPanel jp5 = new JPanel();
JLabel jl5 = new JLabel("电话号码 ");
jp5.add(jl5);
jp5.add(jtf5);
jp00.add(jp5);
JPanel jp6 = new JPanel();
JLabel jl6 = new JLabel("Skype ");
jp6.add(jl6);
jp6.add(jtf6);
jp00.add(jp6);
JPanel jp7 = new JPanel();
JLabel jl7 = new JLabel("QQ ");
jp7.add(jl7);
jp7.add(jtf7);
jp00.add(jp7);
JPanel jp8 = new JPanel();
JLabel jl8 = new JLabel("备注 ");
jp8.add(jl8);
jp8.add(jtf8);
jp00.add(jp8);
JPanel jp9 = new JPanel();
JLabel jl9 = new JLabel("客户分类 ");
jp9.add(jl9);
jp9.add(jtf9);
jp00.add(jp9);
jf.add(jp00);
JPanel jp01 = new JPanel();
jta10.setText("--用户使用手册-- \n1、查询：选择一个字段，如 EngName 在文本框中输入相应内容，点击查询\n2、增加：在各个文本框中输入相应内容后，点击增加。\n3、修改：先查询到你要的记录，在更改相应内容，点击修改。\n4、撤除：类似于修改操作");
jp01.add(jta10);
jf.add(jp01);
jf.setSize(700, 500);
jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
jf.setVisible(true);
}
public static void main(String[] args) {
new EmpManageSys();
}
}