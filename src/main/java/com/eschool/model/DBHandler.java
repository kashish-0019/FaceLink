package com.eschool.model;
import java.sql.*;

import java.util.ArrayList;


public class DBHandler {
   
	private String message;
	
	Connection getConnection() {
		Connection con=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost/myfb?user=root&password=root");
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return con;
	}
	
	public void save(User user) {
		message="";
		
		try {
			Connection cn=getConnection();
			String query="insert into users values(?,?,?)";
			PreparedStatement st=cn.prepareStatement(query);
			st.setString(1, user.getEmail());
			st.setString(2, user.getPassword());
			st.setString(3, user.getName());
			st.executeUpdate();
			cn.close();
			message="Data Saved";
		}catch(Exception e) {
			message = "Error:-"+ e.getMessage();
		}
	}
	
	public User getUser(String email) {
		message="";
		User user=null;
		try {
			Connection cn=getConnection();
			String query="select * from users where email=?";
			PreparedStatement st=cn.prepareStatement(query);
			st.setString(1, email);
			ResultSet rs=st.executeQuery();
			if(rs.next())
				user=new User(rs.getString(1),rs.getString(2),rs.getString(3));
			cn.close();
		}catch(Exception e) {
			message = "Error:-"+ e.getMessage();
		}
		return user;
	}
	
	public void save(Friend friend) {
		message="";
		
		try {
			Connection cn=getConnection();
			String query="insert into friends(sender,rec,stat,dor) values(?,?,?,?)";
			PreparedStatement st=cn.prepareStatement(query);
			st.setString(1, friend.getSender());
			st.setString(2, friend.getRec());
			st.setInt(3, friend.getStat());
			st.setString(4, friend.getDor());
			st.executeUpdate();
			cn.close();
			message="Data Saved";
		}catch(Exception e) {
			message = "Error:-"+ e.getMessage();
		}
	}
	
	public void save(Wpost wpost) {
		message="";
		
		try {
			Connection cn=getConnection();
			String query="insert into wposts(sender,message,dop) values(?,?,?)";
			PreparedStatement st=cn.prepareStatement(query);
			st.setString(1, wpost.getSender());
			st.setString(2, wpost.getMessage());
			st.setString(3, wpost.getDop());
			st.executeUpdate();
			cn.close();
			message="Data Saved";
		}catch(Exception e) {
			message = "Error:-"+ e.getMessage();
		}
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public ArrayList<Wpost> getPosts(String email) {

        ArrayList<Wpost> wposts=new ArrayList<Wpost>();
      
        String query="select * from wposts order by wid desc";
		try {
			ArrayList<String> friends=getFriends(email);
			friends.add(email);
			
			Connection cn=getConnection();
			PreparedStatement statement = cn.prepareStatement(query);
			ResultSet result =statement.executeQuery();
			while(result.next()) {
				int wid=result.getInt(1);
				String sender=result.getString(2);
				String message=result.getString(3);
				String dop=result.getString(4);
				if(friends.contains(sender))
				{
					Wpost wpost=new Wpost(wid, sender, message, dop);
					wposts.add(wpost);
				}
			}
		}catch(Exception e) {
			System.out.println("Error:- "+e.getMessage());
		}
		
		return wposts;
	}

	public ArrayList<Friend> getPendingRequests(String email) {
	    ArrayList<Friend> list = new ArrayList<>();
	    try {
	        Connection conn = getConnection();
	        String query = "SELECT * FROM friends WHERE rec = ? AND stat = 0";
	        PreparedStatement statement = conn.prepareStatement(query);
	        statement.setString(1, email);
	        System.out.println("Executing pending request query for: " + email);
	        ResultSet rs = statement.executeQuery();

	        while (rs.next()) {
	            Friend f = new Friend();
	            f.setFid(rs.getInt("fid"));
	            f.setSender(rs.getString("sender"));
	            f.setRec(rs.getString("rec"));
	            f.setStat(rs.getInt("stat"));
	            f.setDor(rs.getString("dor"));
	            list.add(f);
	        }

	        System.out.println("Found " + list.size() + " pending requests.");
	        conn.close();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return list;
	}

	public ArrayList<String> getFriends(String email) {
		ArrayList<String> friends=new ArrayList<String>();
		String query="select * from friends where (rec=? or sender=?) and stat=1";
		try {
			Connection cn=getConnection();
			PreparedStatement statement = cn.prepareStatement(query);
			statement.setString(1, email);
			statement.setString(2, email);
			ResultSet result =statement.executeQuery();
			while(result.next()) {
				int fid=result.getInt(1);
				String sender=result.getString(2);
				String rec=result.getString(3);
				int stat=result.getInt(4);
				String dor=result.getString(5);
				if(sender.equals(email))
				    friends.add(rec);
				else
					friends.add(sender);
			}
		}catch(Exception e) {
			System.out.println("Error:- "+e.getMessage());
		}
		
		return friends;
	}
	
	public void acceptRequest(int fid) {
		message="";
		
		try {
			Connection cn=getConnection();
			String query="update friends set stat=1 where fid=?";
			PreparedStatement st=cn.prepareStatement(query);
			st.setInt(1, fid);
			st.executeUpdate();
			cn.close();
			message="Data Saved";
		}catch(Exception e) {
			message = "Error:-"+ e.getMessage();
		}
	}
	
	public void rejectRequest(int fid) {
		message="";
		
		try {
			Connection cn=getConnection();
			String query="update friends set stat=2 where fid=?";
			PreparedStatement st=cn.prepareStatement(query);
			st.setInt(1, fid);
			st.executeUpdate();
			cn.close();
			message="Data Saved";
		}catch(Exception e) {
			message = "Error:-"+ e.getMessage();
		}
	}
	
}
