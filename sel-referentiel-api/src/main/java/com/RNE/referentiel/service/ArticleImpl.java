package com.RNE.referentiel.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.RNE.referentiel.entities.Article;
import com.RNE.referentiel.repositories.ArticleRepository;
import com.RNE.referentiel.serviceInterface.ArticleServiceImpl;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ArticleImpl implements ArticleServiceImpl{
	
private ArticleRepository articleRepository;

@Override
public Article saveArticle(Article article) {
	// TODO Auto-generated method stub
	return articleRepository.save(article);}

@Override
public Article articleById(String codeArticle) {
	// TODO Auto-generated method stub
	 Article	existArticle=articleRepository.findById(codeArticle).orElse(null);
	return existArticle;
}

@Override
public List<Article> getAllArticle() {
	// TODO Auto-generated method stub
	return articleRepository.findAll();
}

@Override
public Article updateArticle(String codeArticle, Article article) {
	// TODO Auto-generated method stub
	Article	existArticle=articleRepository.findById(codeArticle).orElse(null);
	 existArticle.setCodeArticle(article.getCodeArticle());
	 existArticle.setTitreArticleFr(article.getTitreArticleFr());
	 existArticle.setTitreArticleAr(article.getTitreArticleAr());
	 existArticle.setActivation(article.getActivation());
	 existArticle.setProposition(article.getProposition());
	 
	return articleRepository.save(existArticle);
}

@Override
public void deleteArticle(String codeArticle) {
	
	articleRepository.deleteById(codeArticle);
	// TODO Auto-generated method stub
	
}



}
