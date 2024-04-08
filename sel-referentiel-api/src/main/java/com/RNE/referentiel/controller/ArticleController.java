package com.RNE.referentiel.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.RNE.referentiel.dto.ArticleDTO;
import com.RNE.referentiel.serviceInterface.ArticleService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/referentiel/articles")
@AllArgsConstructor
public class ArticleController {

    private ArticleService articleService;

    @PostMapping
    public ResponseEntity<ArticleDTO> createArticle(@RequestBody ArticleDTO articleDTO) {

        ArticleDTO savedArticleDTO = articleService.saveArticle(articleDTO);
        return new ResponseEntity<>(savedArticleDTO, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ArticleDTO>> getAllArticles() {
        return new ResponseEntity<List<ArticleDTO>>(articleService.getAllArticles(), HttpStatus.OK);
    }

    @GetMapping("{codeArticle}")
    public ResponseEntity<ArticleDTO> getArticleByCode(@PathVariable String codeArticle) {
        return new ResponseEntity<ArticleDTO>(articleService.getArticleByCode(codeArticle), HttpStatus.OK);

    }

    @PutMapping("update/{codeArticle}")
    public ResponseEntity<ArticleDTO> updateArticle(@PathVariable String codeArticle, @RequestBody ArticleDTO articleDTO) {
        return new ResponseEntity<ArticleDTO>(articleService.updateArticle(codeArticle, articleDTO), HttpStatus.OK);
    }

    @DeleteMapping("delete/{codeArticle}")
    public ResponseEntity<String> deleteArticle(@PathVariable String codeArticle) {
        articleService.deleteArticle(codeArticle);
        return new ResponseEntity<String>("Article successfully deleted!", HttpStatus.OK);
    }
}