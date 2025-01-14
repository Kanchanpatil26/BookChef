package com.kanchan.db;

public class User {
	public static int uid;
	public static String uemail;

	public static String getUemail() {
		return uemail;
	}

	public static  void setUemail(String uemail) {
		User.uemail = uemail;
	}

	public static int getUid() {
		return uid;
	}

	public static void setUid(int uid) {
		User.uid = uid;
	}

}
