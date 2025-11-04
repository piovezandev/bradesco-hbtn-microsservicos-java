package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class SongRepository {
	private List<Song> list = new ArrayList<Song>();

	public SongRepository() {
		list.add(new Song(1, "Bohemian Rhapsody", "Queen", "A Night at the Opera", "1975"));
		list.add(new Song(2, "Imagine", "John Lennon", "Imagine", "1971"));
	}

	public List<Song> getAllSongs() {
		return list;
	}

	public Song getSongById(Integer id) {
		return list
				.stream()
				.filter(p -> p.getId() == id)
				.findFirst()
				.orElse(null);
	}

	public void addSong(Song s) {
		list.add(s);
	}

	public void updateSong(Song s) {
		list.stream()
		.filter(p -> p.getId() == s.getId())
		.forEach(p -> {
			p.setNome(s.getNome());
			p.setArtista(s.getArtista());
			p.setAlbum(s.getAlbum());
			p.setAnoLancamento(s.getAnoLancamento());
		});
	}

	public void removeSong(Song s) {
		list.removeIf(p -> p.getId() == s.getId());
	}
}