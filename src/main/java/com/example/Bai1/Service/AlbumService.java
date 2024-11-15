package com.example.Bai1.Service;

import com.example.Bai1.Entity.Album;
import com.example.Bai1.Http.HttpUrlTest;
import com.example.Bai1.Repository.IAlbumRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Service;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

@Service
public class AlbumService {
        private final IAlbumRepository albumRepository;
        public AlbumService(IAlbumRepository albumRepository){
            this.albumRepository = albumRepository;
        }
        public void saveAlbumIntoDB() throws MalformedURLException, ParseException {
            URL url = new URL("https://jsonplaceholder.typicode.com/albums");
            String json = HttpUrlTest.connect(url);
            JSONArray jsonArray =(JSONArray) new JSONParser().parse(json);
            List<Album> albums = new ArrayList<>();
            for (Object object : jsonArray){
                JSONObject albumJson = (JSONObject) object;
                Album album = new Album();
                album.setId(((Long) albumJson.get("id")));
                album.setUserId((Long) albumJson.get("userId"));
                album.setTitle((String) albumJson.get("title"));
                albums.add(album);
            }
            albumRepository.saveAll(albums);
        }
}
