package com.example.Bai1;

import com.example.Bai1.Http.HttpClientTest;
import com.example.Bai1.Http.HttpUrlTest;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;

@SpringBootApplication
public class Bai1Application {

	public static void main(String[] args) {
		try {
			URL url = new URL("https://jsonplaceholder.typicode.com/albums");
			System.out.println(new HttpUrlTest().connect(url));
			//System.out.println(new HttpClientTest().connect(url));
		} catch (MalformedURLException e) {
			throw new RuntimeException(e);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
        SpringApplication.run(Bai1Application.class, args);
	}

}
