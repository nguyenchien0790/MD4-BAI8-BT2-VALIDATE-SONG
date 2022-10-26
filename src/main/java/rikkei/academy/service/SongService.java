package rikkei.academy.service;

import rikkei.academy.model.Song;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SongService implements ISongService {
    private static Map<Integer , Song> songMap = new HashMap<>();
    static {
        songMap.put(1, new Song(1,"Trang Vo","Dan Truong","Nhac Tre"));
        songMap.put(2, new Song(2,"La Do","Trung Duc","Nhac Cach Mang"));
        songMap.put(3, new Song(3,"Tinh Nho Mau Quen","Quang Le","Nhac Vang"));
    }

    @Override
    public List<Song> findAll() {
        return new ArrayList<>(songMap.values());
    }

    @Override
    public void save(Song song) {
        songMap.put(song.getId(),song);

    }

    @Override
    public Song findById(int id) {
        return songMap.get(id);
    }

    @Override
    public void update(Song song) {
        songMap.put(song.getId(),song);

    }

    @Override
    public void remote(int id) {
        songMap.remove(id);

    }
}
