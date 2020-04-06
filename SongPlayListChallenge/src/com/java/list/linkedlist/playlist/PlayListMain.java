/**
 * 
 */
package com.java.list.linkedlist.playlist;

import java.util.LinkedList;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

/**
 * @author esliv
 *
 */
public class PlayListMain {

	private static ArrayList<Album> albums = new ArrayList<>();
	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {

		albums.add(new Album("abc", "Mr. A"));
		albums.add(new Album("def", "Mr. B"));
		albums.add(new Album("ghi", "Mr. C"));
		
		albums.get(0).addSong("album1 1st song", 4.2);
		albums.get(0).addSong("album1 2nd song", 6.2);
		albums.get(0).addSong("album1 3rd song", 4.42);
		printList(albums);
		//albums.get(0).removeSong("album1 1st song");
		albums.get(0).removeSong("album1 3rd song");
		printList(albums);
		albums.get(1).addSong("album2 1st song", 4.2);
		albums.get(1).addSong("album2 2nd song", 5.2);
		albums.get(1).addSong("album2 2nd song", 5.2);
		albums.get(1).addSong("album2 3rd song", 3.2);

		printList(albums);
		System.out.println("Listing out your playlist:");
		LinkedList<Song> playlist = new LinkedList<>();
		albums.get(0).addToPlaylist(1, playlist);
		albums.get(0).addToPlaylist(2, playlist);
		albums.get(0).addToPlaylist("album1 3rd song", playlist);
		//albums.get(1).addToPlaylist("album1 3rd song", playlist);
		albums.get(1).addToPlaylist(1, playlist);
		albums.get(1).addToPlaylist("album2 3rd song", playlist);
		printList(playlist);

		playSongs(playlist);

	}

	private static void playSongs(LinkedList<Song> playlist) {
		ListIterator<Song> playListIterator = playlist.listIterator();
		if (playlist.isEmpty()) {
			System.out.println("No songs to play in the list");
			return;
		} else {
			System.out.println("Now playing " + playListIterator.next().toString());
			printOptions();
		}

		boolean play = true;
		boolean forward = true;
		while(play) {
			System.out.println("Enter your option");
			int option = scanner.nextInt();
			switch(option) {
				case 1:
					printOptions();
					break;
				case 2:
					if(!forward) {
						if(playListIterator.hasNext()) {
							playListIterator.next();
						}
						forward = true;
					}
					if(playListIterator.hasNext()) {
						System.out.println("Now playing " + playListIterator.next().toString());
					} else {
						System.out.println("Reached end of playlist.");
						forward = false;
					}
					break;
				case 3:
					if(forward) {
						if(playListIterator.hasPrevious()) {
							playListIterator.previous();
						}
						forward = false;
					}
					if(playListIterator.hasPrevious()) {
						System.out.println("Now playing " + playListIterator.previous().toString());
					} else {
						System.out.println("At the start of playlist.");
						forward = true;
					}
					break;
				case 4:
					if(forward) {
						if(playListIterator.hasPrevious()) {
							System.out.println("Replaying the current song " + playListIterator.previous().toString());
							forward = false;
						} else {
							System.out.println("Reached start of playlist");
						}
					} else if (!forward) {
						if(playListIterator.hasNext()) {
							System.out.println("Replaying the current song " + playListIterator.next().toString());
							forward = true;
						}
						else {
							System.out.println("Reached end of playlist");
						}
					}
					 
					break;
				case 5:
					printList(playlist);
					break;
				case 6:
					play = false;
					System.out.println("Closing song player...");
					break;
				case 7:
					if(playlist.size() > 0) {
						playListIterator.remove();
						if(playListIterator.hasNext()) {
							System.out.println("Now playing " + playListIterator.next());
						} else if (playListIterator.hasPrevious()) {
							System.out.println("Now playing " + playListIterator.previous());
						}
					}
					
					break;
			}
		}

	}

	
	private static void printOptions() {
		System.out.println("1 - Print options");
		System.out.println("2 - Play next song");
		System.out.println("3 - Play previous song");
		System.out.println("4 - Replay current song");
		System.out.println("5 - Display songs in playlist");
		System.out.println("6 - Stop playing");
		System.out.println("7 - Delete current song");
		
	}

	private static <T> void printList(List<T> list) {
		System.out.println("========================");
		list.forEach(a -> System.out.println(a));
		System.out.println("========================");
	}
}
