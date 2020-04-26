package com.java.streamapi.map;
public class NamePhoneMail {
		String name;
		String phoneNo;
		String email;
		
		public NamePhoneMail(String name, String phoneNo, String email) {
			this.name = name;
			this.phoneNo = phoneNo;
			this.email = email;
		}

		@Override
		public String toString() {
			return "NamePhoneMail [name=" + name + ", phoneNo=" + phoneNo + ", email=" + email + "]";
		}
		
		
		
	}