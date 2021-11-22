package com.godcodes.SpringApplicationGradle;

import com.google.gson.Gson;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringApplicationGradleApplication {

	public static final Gson gson = new Gson();

	public static void main(String[] args) {
		SpringApplication.run(SpringApplicationGradleApplication.class, args);
	}

	public static Gson getAppGson()
	{
		return gson;
	}

}
