package dao;

import java.sql.*;

import model.Feedback;

public class DbOps {

	Connection conn;
	PreparedStatement pstmt;
	public String driver,dbloc,dbuser,pwd;
	public Feedback obj;
	
	public DbOps(String driver, String dbloc, String dbuser, String pwd, Feedback obj){
		this.driver=driver;
		this.dbloc=dbloc;
		this.dbuser=dbuser;
		this.pwd=pwd;
		this.obj=obj;
		
		try {
			Class.forName(this.driver);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			conn=DriverManager.getConnection(dbloc,dbuser,pwd);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void insertrcrc(Feedback obj) {
		this.obj=obj;
		int fid=this.obj.getFeedid();
		String fname=this.obj.getFeedname();
		String fmsg=this.obj.getFeedmsg();
		
		String insertquery= "INSERT INTO tblfeedback"
	}
}
