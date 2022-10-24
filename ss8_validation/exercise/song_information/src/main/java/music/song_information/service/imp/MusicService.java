package music.song_information.service.imp;

import music.song_information.model.Music;
import music.song_information.repository.IMusicRepository;
import music.song_information.service.IMusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MusicService implements IMusicService {
    @Autowired
    private IMusicRepository musicRepository;

    @Override
    public List<Music> findAll() {
        return musicRepository.findAll();
    }

    @Override
    public void save(Music music) {
        musicRepository.save(music);
    }

    @Override
    public Music findById(int id) {
        return musicRepository.findById(id).orElse(null);
    }

    @Override
    public void update(Music music) {
        musicRepository.save(music);
    }
}
