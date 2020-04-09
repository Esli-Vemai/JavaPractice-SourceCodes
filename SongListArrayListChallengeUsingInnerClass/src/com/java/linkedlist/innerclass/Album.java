package com.java.linkedlist.innerclass;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dev on 18/09/15.
 */
public class Album {
	private String name;
	private String artist;
	private SongList songlist;

	public Album(String name, String artist) {
		this.name = name;
		this.artist = artist;
		songlist = new SongList();
	}

	public boolean addSong(String title, double duration) {
		return songlist.add(title, duration);
	}

	public boolean addToPlayList(int trackNumber, List<Song> playList) {
		Song checkedSong = songlist.findSong(trackNumber);
		if (checkedSong != null) {
			return playList.add(checkedSong);
		}
		System.out.println("This album does not have a track " + trackNumber);
		return false;
	}

	public boolean addToPlayList(String title, List<Song> playList) {
		Song checkedSong = songlist.findSong(title);
		if (checkedSong != null) {
			return playList.add(checkedSong);
		}
		System.out.println("The song " + title + " is not in this album");
		return false;

	}

	private class SongList {
		private ArrayList<Song> songs;

		public SongList() {
			this.songs = new ArrayList<>();
		}

		public boolean add(String title, double duration) {
			if (findSong(title) == null) {
				this.songs.add(new Song(title, duration));
				return true;
			}
			return false;
		}

		private Song findSong(String title) {
			for (Song checkedSong : this.songs) {
				if (checkedSong.getTitle().equals(title)) {
					return checkedSong;
				}
			}
			return null;
		}

		private Song findSong(int trackNumber) {
			int index = trackNumber - 1;
			if (index > 0 && index < songs.size()) {
				return songs.get(index);
			}
			return null;
		}
	}

}
