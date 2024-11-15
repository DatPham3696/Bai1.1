package com.example.Bai1.Controller;

import com.example.Bai1.Service.AlbumService;
import lombok.RequiredArgsConstructor;
import org.json.simple.parser.ParseException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.MalformedURLException;

@RestController
@RequiredArgsConstructor
public class AlbumController {
    private final AlbumService albumService;
    @GetMapping("/saveAlbum")
    public String saveAlbu()  {
        try {
            albumService.saveAlbumIntoDB();
            return "Lưu data thành công";
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

    }
}
