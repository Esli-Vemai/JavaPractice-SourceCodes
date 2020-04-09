/**
 * 
 */
package com.java.inner.clas;

/**
 * @author esliv
 *
 */
public class ButtonClassforAnonymousClassDemo {
	private String title;
	private OnClickClass onclickClass;
	
	public ButtonClassforAnonymousClassDemo(String title) {
		super();
		this.title = title;
	}

	public String getTitle() {
		return title;
	}

	public void setOnClickClass( OnClickClass onClickClass) {
		this.onclickClass = onClickClass;
	}
	
	public void onClick() {
		this.onclickClass.onClick(this.title);
	}
	
	
	public interface OnClickClass {
		public void onClick(String title);
	}
}
