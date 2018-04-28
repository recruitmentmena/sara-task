package com.therealdanvega.repository;

import java.util.Date;
import java.util.concurrent.Future;
import java.util.stream.Stream;

import com.therealdanvega.domain.News;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.scheduling.annotation.Async;

public interface NewsRepository extends PagingAndSortingRepository<News, Long> {
	@Async
	Future<News> findByTitle(String title);

	@Async
	Future<News> findByPublishingdate(String publishingdate);

}
