package com.RNE.referentiel.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.RNE.referentiel.dto.ArticleDTO;
import com.RNE.referentiel.entities.Article;
import com.RNE.referentiel.repositories.ArticleRepository;
import com.RNE.referentiel.serviceInterface.ArticleService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ArticleImpl implements ArticleService{
	
private ArticleRepository articleRepository;

@Override
public Article saveArticle(Article article) {
	// TODO Auto-generated method stub
	return articleRepository.save(article);}


/*@Override
public List<ArticleDTO> getAllArticle() {
	// TODO Auto-generated method stub
	return articleRepository.findAll();
}
*/
@Override
public Article updateArticle(String articleCode, Article article) {
	// TODO Auto-generated method stub
	Article	existArticle=articleRepository.findById(articleCode).orElse(null);
	 existArticle.setArticleCode(article.getArticleCode());
	 existArticle.setArticleTitleFr(article.getArticleTitleFr());
	 existArticle.setArticleTitleAr(article.getArticleTitleAr());
	 existArticle.setActivation(article.getActivation());
	 existArticle.setProposal(article.getProposal());
	 
	return articleRepository.save(existArticle);
}

@Override
public void deleteArticle(String articleCode) {
	
	articleRepository.deleteById(articleCode);
	// TODO Auto-generated method stub
	
}

@Override
public ArticleDTO articleById(String articleCode) {
	// TODO Auto-generated method stub
	Article	existArticle=articleRepository.findById(articleCode).orElse(null);
	if(existArticle == null) {
		return null;
	}
	return ArticleDTO.convertEntityToDto(existArticle);
}


@Override
public List<ArticleDTO> getAllArticle() {
	 List<Article> articles = articleRepository.findAll();
     
     return articles.stream()
             .map(ArticleDTO::convertEntityToDto)
             .collect(Collectors.toList());
}

}
