package music.song_information.service;

import music.song_information.model.Music;

import java.util.List;

public interface IMusicService {
    List<Music> findAll();
    void save(Music music);
    Music findById(int id);
    void update(Music music);
}
