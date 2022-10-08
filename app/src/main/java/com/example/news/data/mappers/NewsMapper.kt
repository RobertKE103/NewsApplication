package com.example.news.data.mappers

import com.example.news.data.entity.ArticleDbModel
import com.example.news.data.entity.NewsResponseDbModel
import com.example.news.data.entity.SourceDbModel
import com.example.news.domain.models.Article
import com.example.news.domain.models.NewsResponse
import com.example.news.domain.models.Source

class NewsMapper {

    fun mapEntityToDbModel(newsResponse: NewsResponse): NewsResponseDbModel = NewsResponseDbModel(
        articleEntities = newsResponse.articles.map { mapArticleEntityToDbModel(it) },
        status = newsResponse.status,
        totalResults = newsResponse.totalResults
    )


    fun mapDbModelToEntity(newsResponseDbModel: NewsResponseDbModel): NewsResponse = NewsResponse(
        articles = newsResponseDbModel.articleEntities.map { mapArticleDbModelToEntity(it) },
        status = newsResponseDbModel.status,
        totalResults = newsResponseDbModel.totalResults
    )


    private fun mapArticleEntityToDbModel(article: Article): ArticleDbModel = ArticleDbModel(
        author = article.author,
        content = article.content,
        description = article.description,
        publishedAt = article.publishedAt,
        sourceEntity = mapSourceEntityToDbMode(article.source),
        title = article.title,
        url = article.url,
        urlToImage = article.urlToImage
    )


    private fun mapArticleDbModelToEntity(articleDbModel: ArticleDbModel): Article = Article(
        author = articleDbModel.author,
        content = articleDbModel.content,
        description = articleDbModel.description,
        publishedAt = articleDbModel.publishedAt,
        source = mapSourceDbModelToEntity(articleDbModel.sourceEntity),
        title = articleDbModel.title,
        url = articleDbModel.url,
        urlToImage = articleDbModel.urlToImage
    )


    private fun mapSourceEntityToDbMode(source: Source): SourceDbModel = SourceDbModel(
        id = source.id,
        name = source.name
    )

    private fun mapSourceDbModelToEntity(sourceDbModel: SourceDbModel): Source = Source(
        id = sourceDbModel.id,
        name = sourceDbModel.name
    )


}