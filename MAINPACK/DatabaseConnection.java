package MAINPACK;
import java.io.FileInputStream;
import java.sql.*;
import java.util.Scanner;

 class DbInitialize {
	Connection con;
	Statement st;
	String s;
	PreparedStatement ps,ps1;
	ResultSet rs;
	DatabaseMetaData dmd;
	
	DbInitialize() throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		System.out.println("Driver Loaded");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/","root","root");
		System.out.println("Connection Established");
		st=con.createStatement();
		System.out.println("Statement object created");			
		 
	}
	void createDB() throws Exception {
		//check database exists or not , then drop
		DatabaseMetaData dmd=con.getMetaData();
		ResultSet rs=dmd.getCatalogs();
		while(rs.next()) {
			String c1=rs.getString(1);
			if(c1.equalsIgnoreCase("test")) {
				s="drop database test";
				st.executeUpdate(s);
				System.out.println("Database droped");	
			}
				
			
		}
		s="create database test";
		st.executeUpdate(s);
		System.out.println("Database Created");	
		
	}
	void useDB() throws Exception {
		s="use test";
		st.executeUpdate(s);
		System.out.println("Database used");
	}
	 void createTables() throws Exception {
		 
		s="Create table login(name varchar(50),password varchar(20))";
        st.executeUpdate(s);
   s="CREATE TABLE BRANCH(BR_NAME VARCHAR(20) PRIMARY KEY, BR_CITY VARCHAR(20), ASSETS REAL)"; 
   st.executeUpdate(s);	
   s="CREATE TABLE CUSTOMER (CUST_NAME VARCHAR(20) PRIMARY KEY, CUST_STREET VARCHAR (20), CUST_CITY VARCHAR (20))"; 
   st.executeUpdate(s);	
   s="CREATE TABLE ACCOUNT (ACCNO INT PRIMARY KEY, BR_NAME VARCHAR(20), BALANCE REAL, FOREIGN KEY (BR_NAME) REFERENCES BRANCH (BR_NAME) ON DELETE CASCADE)"; 
   st.executeUpdate(s);
   s="CREATE TABLE CUST_IMAGE (CUSTOMER_NAME VARCHAR(20),CUST_IMAGE BLOB,FOREIGN KEY(CUSTOMER_NAME) REFERENCES CUSTOMER(CUST_NAME) ON DELETE CASCADE)";
   st.executeUpdate(s);
   s="CREATE TABLE DEPOSITOR (CUST_NAME VARCHAR (20), ACCNO INT, PRIMARY KEY (CUST_NAME, ACCNO), FOREIGN KEY (CUST_NAME) REFERENCES CUSTOMER (CUST_NAME) ON DELETE CASCADE, FOREIGN KEY (ACCNO) REFERENCES ACCOUNT (ACCNO) ON DELETE CASCADE)";
   st.executeUpdate(s);
   s="CREATE TABLE LOAN (LOAN_NO INT PRIMARY KEY, BR_NAME VARCHAR (20), AMOUNT REAL, FOREIGN KEY (BR_NAME) REFERENCES BRANCH (BR_NAME) ON DELETE CASCADE)";
   st.executeUpdate(s);
   s="CREATE TABLE BORROWER (CUST_NAME VARCHAR (20), LOAN_NO INT, PRIMARY KEY (CUST_NAME, LOAN_NO), FOREIGN KEY (CUST_NAME) REFERENCES CUSTOMER (CUST_NAME) ON DELETE CASCADE, FOREIGN KEY (LOAN_NO) REFERENCES LOAN (LOAN_NO) ON DELETE CASCADE)";
   st.executeUpdate(s);
   s="create table customerextradetails(cust_name varchar(40) primary key,birthdate date,gender varchar(10), passportnumber varchar(20),city varchar(20),pin int,mobno int,emailid varchar(30),sourceofwealth varchar(20),citizenship varchar(10),foreign key(cust_name) references customer(cust_name) on delete cascade)";
   st.executeUpdate(s);
        System.out.println("Tables Created");
	}
	 void insertRecords() throws Exception {
		s="INSERT INTO BRANCH VALUES \r\n" + 
				"('KORMANGALA','BENGALURU',20500.3),\r\n" + 
				"('SADASHIVANAGAR','BENGALURU',154329.5),\r\n" + 
				"('VITTALNAGAR','HYDERABAD',350000),\r\n" + 
				"('KASTHURINAGAR','DELHI',125000),\r\n" + 
				"('MARUTINAGAR','HYDERABAD',212351.6),\r\n" + 
				"('RAJANKUNTE','MUMBAI',53535.8)";  
		st.executeUpdate(s);				
		s="INSERT INTO ACCOUNT VALUES\r\n" + 
				"(123456,'KORMANGALA',5000),\r\n" + 
				"(123457,'SADASHIVANAGAR',35000),\r\n" + 
				"(123458,'VITTALNAGAR',60000),\r\n" + 
				"(123459,'KASTHURINAGAR',255600),\r\n" + 
				"(123460,'VITTALNAGAR',37890),\r\n" + 
				"(123461,'MARUTINAGAR',20000),\r\n" + 
				"(123462,'SADASHIVANAGAR',40000)";
		st.executeUpdate(s);
		s="INSERT INTO CUSTOMER VALUES('KAVYA', 'SADASHIVANAGAR', 'BENGALURU'),('ABHAY', 'KAMALANAGAR', 'TUMKUR'),('SHEETAL', 'KASTHURINAGAR', 'BENGALURU'),('KSHAMITHA', 'MARUTILAYOUT', 'TUMKUR'),('LIKITH', 'MADHURANAGAR', 'HYDERABAD'),('SACHIN', 'VITTALNAGAR', 'HYDERABAD')";
		st.executeUpdate(s);
		s="INSERT INTO DEPOSITOR VALUES('KAVYA',123457),('ABHAY',123456),('KAVYA',123456),('KSHAMITHA',123458),('KSHAMITHA',123460),('LIKITH',123461),('KAVYA',123462)";System.out.println("Records Inserted");
		st.executeUpdate(s);
		s="INSERT INTO LOAN VALUES(231,'SADASHIVANAGAR',50500.5),(232,'VITTALNAGAR',25000),(233,'MARUTINAGAR',60300.3),(234,'KASTHURINAGAR',45000.7),(235,'KORMANGALA',25534)";
		st.executeUpdate(s);
		s="INSERT INTO BORROWER VALUES('KAVYA',231),('KSHAMITHA',232),('ABHAY',235),('LIKITH',234),('SACHIN',233)";
		st.executeUpdate(s);
		s="INSERT INTO LOGIN VALUES('presidency','presidency'),('sunil','sunil')";
		st.executeUpdate(s);
	 }
	 int insertLogin(String nm,String pw) throws Exception {
		  s="insert into LOGIN values(?,?)";
		  ps=con.prepareStatement(s);
		  
		  ps.setString(1, nm);
		  ps.setString(2,pw);
		  
		  int n=ps.executeUpdate();
	        if(n==1)
	        	return 1;
	        else 
	        	return 0;
			
	 }
	 int insertCustomer(String nm,String street,String city) throws Exception {
		  s="insert into CUSTOMER values(?,?,?)";
		  ps=con.prepareStatement(s);
		  
		  ps.setString(1, nm);
		  ps.setString(2,street);
		  ps.setString(3,city);
		  int n=ps.executeUpdate();
	        if(n==1)
	        	return 1;
	        else 
	        	return 0;
			
	 }
	 int insertCustomerExtraDetails(String un,String dob,String gender) throws Exception {
		  s="insert into customerextradetails(cust_name,birthdate,gender) values(?,?,?)";
		  ps=con.prepareStatement(s);
		  
		  ps.setString(1, un);
		  ps.setString(2, dob);
		  ps.setString(3, gender);
		  int n=ps.executeUpdate();
		 
	        if(n==1)
	        	return 1;
	        else 
	        	return 0;
			
	 }
	 int transfer_money(int sano,int ano,int amount) throws Exception {
			String s="update account set BALANCE=BALANCE+? where ACCNO=?";
			String s1="update account set BALANCE=BALANCE-? where ACCNO=?";
	        ps=con.prepareStatement(s);
	        ps1=con.prepareStatement(s1);
	        
	        ps.setInt(1, amount);
	        ps.setInt(2, ano);
	        
	        ps1.setInt(1, amount);
	        ps1.setInt(2, sano);
	        int n=ps.executeUpdate();
	        int r=ps1.executeUpdate();
          if (n==1&&r==1) {
			    return 1;
        	  }
          else 
        	  return 0;
			  
		  }
		 
	 int insertCustomerExtraDetails2(String un,String passportnumber,String city,int pin,int mobile,String email,String sow,String citizenship) throws Exception {
		  s="update customerextradetails set passportnumber=?,city=?,pin=?,mobno=?,emailid=?,sourceofwealth=?,citizenship=? where cust_name=?";
		  ps=con.prepareStatement(s);
		  
		  ps.setString(1, passportnumber);
		  ps.setString(2, city);
		  ps.setInt(3, pin);
		  ps.setInt(4, mobile);
		  ps.setString(5, email);
		  ps.setString(6, sow);
		  ps.setString(7, citizenship);
		  ps.setString(8, un);
		  int n=ps.executeUpdate();
	        if(n==1)
	        	return 1;
	        else 
	        	return 0;
			
	 }
	 
	 int insertAccount(int acc,String bn,double balance) throws Exception {
		
		
		
		 s="insert into ACCOUNT values(?,?,?)";
		  ps=con.prepareStatement(s);
		  
		  ps.setInt(1, acc);
		  ps.setString(2, bn);
		  ps.setDouble(3,balance);
		 
		  int n=ps.executeUpdate();
		
	        if(n==1)
	        	return 1;
	        else 
	        	return 0;
			
	 }
	 
	 int insertDepositor(String cn,int accno) throws Exception {
		
		 
		  s="insert into DEPOSITOR values(?,?)";
		  ps=con.prepareStatement(s);
		  
		  ps.setString(1, cn);
		  ps.setInt(2, accno);
		 
		   int n=ps.executeUpdate();
		 
		 
	        if(n==1)
	        	return 1;
	        else 
	        	return 0;
		 
			
	 }
	  void insertMoreRecords() throws Exception {
		  s="insert into LOGIN values(?,?)";
		  ps=con.prepareStatement(s);
		  String un,pwd;
		  Scanner sc=new Scanner(System.in);
		  System.out.println("Enter username");
		  un=sc.next();
		  System.out.println("Enter password");
		  pwd=sc.next();
		  ps.setString(1, un);
		  ps.setString(2,pwd);
		  int n=ps.executeUpdate();
	        System.out.println(n+" Record Inserted");        
			
	 }
	  //executeQuery()  for DQL query manager
	 int readLogin(String s1,String s2) throws Exception {
		 s="SELECT * FROM LOGIN ";
		 String name,password;
		 boolean flag=false;
		 st=con.createStatement();
		 rs=st.executeQuery(s);
		//rs=ps.executeQuery();
		 
		 while(rs.next()) {
			 
		  name=rs.getString(1);
		  password=rs.getString(2);
		  if((name.equals(s1))&&(password.equals(s2))) {
			  flag=true;
			  break;
		  }
			  
		 
		 }
		 if(flag)
		return 1;
		 else
			 return 0;
	 }
	 ResultSet  readAccount() throws Exception{
		 getAllColumns("ACCOUNT");
	        s="SELECT * FROM ACCOUNT";
			 
			 st=con.createStatement();
			ResultSet rs=st.executeQuery(s);
			 
			 
			 return rs; 
			/*Statement nm=con.createStatement();
		    rs=nm.executeQuery("select * from account");
			System.out.println("________________");
			System.out.println("------ACCOUNT----");
			while(rs.next()) {
				System.out.printf("%-20s",rs.getInt(1));
				System.out.printf("%-20s",rs.getString(2));
				System.out.print(rs.getDouble(3));
				System.out.println();
			}
			return rs;*/
			
		}
	 void readBranch() throws Exception {
		 
		
		 getAllColumns("Branch");
        s="SELECT * FROM Branch";
		 
		 st=con.createStatement();
		 rs=st.executeQuery(s);
		 while(rs.next()) {
			 
			  System.out.printf("%-27s",rs.getString(1));
			  System.out.printf("%-22s",rs.getString(2));
			  System.out.print(rs.getDouble(3));		
			  System.out.println();
		 }
		 
		  
	 }
	 ResultSet readCustomer() throws Exception {
		 
			
		 getAllColumns("customer");
        s="SELECT * FROM customer";
		 
		 st=con.createStatement();
		ResultSet rs=st.executeQuery(s);
		 
		 
		 return rs; 
	 }
	 
	 void getAllDatabases() throws Exception {
		    dmd=con.getMetaData();
		   //show databases
		    rs=dmd.getCatalogs();
		    System.out.println("all database names");
		    while(rs.next()) {
		    System.out.print(rs.getString(1));
		    
		   System.out.println();
		    }
		 } 
	 
	 void getAllTables(String dbname) throws Exception {
		 s="use "+dbname;
			st.executeUpdate(s);
			System.out.println("Database used");
		 String table[] = { "TABLE" };
		 rs = dmd.getTables(null, null, null, table);
		 System.out.println("all tables names");
		 while(rs.next()) {
			    System.out.print(rs.getString("TABLE_NAME"));
			    
			   System.out.println();
			    }
	 }
	 void getAllColumns(String tabname) throws Exception {
		 dmd=con.getMetaData();
		 rs = dmd.getColumns(null, null, tabname, null);
		
		 while (rs.next()) {
             System.out.print(rs.getString("COLUMN_NAME")+" "
                     + rs.getString("TYPE_NAME") +"("
                     + rs.getString("COLUMN_SIZE")+")"+"\t");
         }
		 System.out.println();
		 
 }
	 
	int insertImage(String un,FileInputStream fin) throws Exception {
		//FileInputStream fin=new FileInputStream("E:\\Images\\sunilphoto.jpg");
		String sql="insert into CUST_IMAGE values(?,?)";
		ps=con.prepareStatement(sql);
		ps.setString(1, un);
		ps.setBinaryStream(2,fin,fin.available());
		int r=ps.executeUpdate();
		if(r==1)
			return 1;
		else 
			return 0;
		

	}
	
	void callProcedure() throws Exception {
		CallableStatement cst=con.prepareCall("call total_balance()");
		rs=cst.executeQuery();
		while(rs.next())
		System.out.println("Total Balance is "+rs.getInt(1));
	}
	int updateCustomer(String cs,String cc,String cn) throws Exception {
		
  s="update customer set cust_street=?,cust_city=? where cust_name=?";
  ps=con.prepareStatement(s);
  Scanner sc=new Scanner(System.in);
 /* System.out.println("Enter Name of Customer");
  cn=sc.next();
  System.out.println("Enter street of Customer");
  cs=sc.next();
  System.out.println("Enter city of Customer");
  cc=sc.next();*/
  ps.setString(1, cs);
  ps.setString(2, cc);
  ps.setString(3, cn);
  int n=ps.executeUpdate();
  System.out.println(n+" Record Updated");
  if(n==1)
     return 1;
  else
	  return 0;
	}
	void deleteCustomer() throws Exception {
		s="delete from customer where cust_name=?";
		ps=con.prepareStatement(s);
				Scanner sc=new Scanner(System.in);
				String cn;
		  System.out.println("Enter Name of Customer");
		  cn=sc.next();
		  ps.setString(1, cn);
		  int n=ps.executeUpdate();
		  System.out.println(n+" Record deleted");
		
	}
	
 }
	 
  
	public class DatabaseConnection {

	public static void main(String[] args) throws Exception {
		DbInitialize obj=new DbInitialize();
		obj.createDB();
		obj.useDB();
		obj.createTables();
		obj.insertLogin("presidency", "presidency");
		obj.insertLogin("sunil", "sunil");
	    obj.insertRecords();
		
	}
	}
		
		
		
		
		
		
		
		
		
		
		
		