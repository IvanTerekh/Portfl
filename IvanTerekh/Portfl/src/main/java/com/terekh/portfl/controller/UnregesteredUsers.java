package com.terekh.portfl.controller;

import java.util.Map;
import java.util.TreeMap;

import com.terekh.portfl.model.User;

public class UnregesteredUsers {
	
	public UnregesteredUsers(){
		
	}

	Map<String, User> users = new TreeMap<>();

	public boolean put(User user) {
		if (users.containsKey(user.getUsername())) {
			users.put(user.getUsername(), user);
			return true;
		} else {
			return false;
		}
	}
	
	public boolean contains(User user){
		return contains(user.getUsername());
	}
	
	public boolean contains(String username){
		return users.containsKey(username);
	}
	
	public void remove(User user){
		remove(user.getUsername());
	}
	
	public void remove(String username){
		users.remove(username);
	}
	
	public User getByUsername(String username){
		return this.users.get(username);
	}
	
	public int Size(){
		return this.users.size();
	}

}
