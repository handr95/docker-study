package com.study.dockernetwork.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

@RequestMapping("/fav")
@Controller
public class HTTPSendController {

    final RestTemplate restTemplate;

    public HTTPSendController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @ResponseBody
    @GetMapping("/movies")
    public String movies() {
        ResponseEntity entity = restTemplate.getForEntity("https://swapi.dev/api/people", String.class);
        return String.valueOf(entity.getBody());
    }

    @ResponseBody
    @GetMapping("/people")
    public String people() {
        ResponseEntity entity = restTemplate.getForEntity("https://swapi.dev/api/people", String.class);
        return String.valueOf(entity.getBody());
    }
}
