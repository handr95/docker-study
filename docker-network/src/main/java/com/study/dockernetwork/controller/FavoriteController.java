package com.study.dockernetwork.controller;

import com.study.dockernetwork.model.Favorite;
import com.study.dockernetwork.repository.FavoriteRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("/fav")
@Controller
public class FavoriteController {

    final FavoriteRepository favoriteRepository;

    public FavoriteController(FavoriteRepository favoriteRepository) {
        this.favoriteRepository = favoriteRepository;
    }

    @GetMapping
    public String goFavPage() {
        return "fav";
    }

    @ResponseBody
    @PostMapping("/save")
    public Favorite save(@RequestBody Favorite favorite) {
        return favoriteRepository.save(favorite);
    }

    @GetMapping("/list")
    public String list(Model model) {
        model.addAttribute("favoriteList", favoriteRepository.findAll());
        return "favlist";
    }
}