package com.therealdanvega.service;

import com.therealdanvega.domain.News;
import com.therealdanvega.repository.NewsRepository;

import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutionException;


@Service
public class NewsService {

    private NewsRepository userRepository;

    public NewsService(NewsRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Iterable<News> list() {
        return userRepository.findAll();
    }
    public Iterable<News> filter(Order[] order) {
        return userRepository.findAll(new Sort(order));
    }
    public News save(News user) {
        return userRepository.save(user);
    }

    public void save(List<News> users) {
        userRepository.save(users);
    }
    public News getByTitle(String title) throws InterruptedException, ExecutionException {
        return userRepository.findByTitle(title).get();
    }
    public News getByDate(String date) throws InterruptedException, ExecutionException {
        return userRepository.findByPublishingdate(date).get();
    }
}
