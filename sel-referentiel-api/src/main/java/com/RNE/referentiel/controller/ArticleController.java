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
import com.RNE.referentiel.entities.Article;
import com.RNE.referentiel.serviceInterface.ArticleService;

import lombok.AllArgsConstructor;


@RestController
@RequestMapping("/api/referentiel/articles")
@AllArgsConstructor
public class ArticleController {


	private ArticleService articleService;
	
	 @PostMapping
	    public ResponseEntity<Article> createArticle(@RequestBody Article article) {
	        
	        Article savedArticle = articleService.saveArticle(article);
	        return new ResponseEntity<>(savedArticle, HttpStatus.CREATED);
	    }
		@GetMapping
		public ResponseEntity<List<ArticleDTO>> getAllArticle(){
			List<ArticleDTO> articleList = articleService.getAllArticle();
	          return  new ResponseEntity<>(articleList, HttpStatus.OK);
		}
		 
		@GetMapping("{codeArticle}")
		public ResponseEntity<ArticleDTO> getCodePostalById(@PathVariable String articleCode) {
		    ArticleDTO articleDTO = articleService.articleById(articleCode);
		    
		    if (articleDTO != null) {
		        return new ResponseEntity<>(articleDTO, HttpStatus.OK);
		    } else {
		        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		    }
		}
		
		
		
		@PutMapping("update/{codeArticle}")
		public ResponseEntity<Article> updateArticle(@PathVariable String codeArticle,@RequestBody Article article){
			return new ResponseEntity<Article>(articleService.updateArticle(codeArticle, article),HttpStatus.OK);
		}
		
		@DeleteMapping("delete/{codeArticle}")
		public ResponseEntity<String> deleteArticle(@PathVariable String codeArticle){
			articleService.deleteArticle(codeArticle);
			return new  ResponseEntity<String>("Article successfully deleted!", HttpStatus.OK);
		}
}
