package com.pk.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table
@SequenceGenerator(name="friendidseq",sequenceName="friendid_seq")
public class Friend 
{
	@Id
	 @GeneratedValue(strategy=GenerationType.SEQUENCE,generator="friendidseq")
	 int friendId;
	 @JsonFormat(shape= JsonFormat.Shape.STRING,pattern = "dd-MM-yyyy")
	 String username;
	 String friendusername;
	 String status;
	public int getFriendId() {
		return friendId;
	}
	public void setFriendId(int friendId) {
		this.friendId = friendId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getFriendusername() {
		return friendusername;
	}
	public void setFriendusername(String friendusername) {
		this.friendusername = friendusername;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
}
