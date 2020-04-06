/**
 * 
 */
package com.java.list.linkedlist.playlist;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Iterator;

/**
 * @author esliv
 *
 */
public class Album {
	private String name;
	private String artist;
	private ArrayList<Song> songs;
	/**
	 * @param name
	 */
	public Album(String name, String artist) {
		this.name = name;
		this.artist = artist;
		this.songs = new ArrayList<>();
	}
	
	
	
	
	public boolean addSong(String title, double duration) {
		Song song = new Song(title, duration);
		if(findSong(song) != null) {
			System.out.println("Song already in the album");
			return false;
		} else {
			return this.songs.add(song);
		}
	}
	
	public void removeSong(String title) {
		Iterator iterator = songs.iterator();
		while(iterator.hasNext()) {
			iterator.next();
			iterator.remove();
		}
		/* Don't use this approach as it is not reliable and may show unexpected output.
		 * if(findSong(title) == -1) { System.out.println("Song not found"); return
		 * false; } else { return this.songs.remove( songs.get(findSong(title))); }
		 */
	}
	
	
	//public boolean addToPlaylist(int tractNumber, LinkedList<Song> linkedSongs) {
	//changed method return type to void to avoid method with side effects, as recommended
	public void addToPlaylist(int tractNumber, LinkedList<Song> linkedSongs) {
		int index = tractNumber -1;
		if(tractNumber >= 0 && tractNumber < songs.size()) {
			Song songToBeAdded = songs.get(index);
			linkedSongs.add(songToBeAdded);
			//return linkedSongs.add(songToBeAdded);
		} else {
			System.out.println("Song you wanted is not in the album.");
			//return false;
		}
	}
	
	
	public void addToPlaylist(String songTitle, LinkedList<Song> linkedSongs) {
		int index = findSong(songTitle);
		if(index >= 0) {
			linkedSongs.add(songs.get(index));
		} else {
			System.out.println("Song you wanted is not in the album.");
		}
	}
	
	
	private Song findSong(Song song) {
		int index = songs.indexOf(song);
		if(index >= 0) {
			return songs.get(index);
		} else {
			return null;
		}
	}
	
	private int findSong(String title) {
		int index = -1;
		for(Song song : this.songs) {
			if(title.equalsIgnoreCase(song.getTitle())) {
				index = songs.indexOf(song);
			}
		}
		
		return index;
	}
	
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @return the songs
	 */
	public ArrayList<Song> getSongs() {
		return this.songs;
	}
	
	
	/**
	 * @return the artist
	 */
	public String getArtist() {
		return artist;
	}


	@Override
	public String toString() {
		return "Album [name = " + name + " , artist " + artist + " , songs = " + this.songs + "]";
	}
	
}
