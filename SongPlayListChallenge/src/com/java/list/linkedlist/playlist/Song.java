/**
 * 
 */
package com.java.list.linkedlist.playlist;

/**
 * @author esliv
 *
 */
public class Song {
	private String title;
	private double duration;
	/**
	 * @param title
	 * @param duration
	 */
	public Song(String title, double duration) {
		this.title = title;
		this.duration = duration;
	}
	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * @return the duration
	 */
	public double getDuration() {
		return duration;
	}
	
	@Override
	public String toString() {
		return "Song [title = " + title + ", duration = " + duration + "]";
	}
	
}
