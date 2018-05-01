//package com.org.es.service.impl;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.Pageable;
//
//import com.org.es.model.Post;
//import com.org.es.repository.PostRepository;
//import com.org.es.service.PostService;
//
//public class PostServiceImpl implements PostService {
//	
//	@Autowired
//	private PostRepository postRepository;
//
//	public Post save(Post post) {
//		postRepository.save(post);
//		return post;
//	}
//
//	public Post findOne(String id) {
//		return postRepository.findOne(id);
//	}
//
//	public Iterable<Post> findAll() {
//		return postRepository.findAll();
//	}
//
//	public Page<Post> findByTagsName(String tagName, Pageable pageable) {		
//		return postRepository.findByTagsName(tagName, pageable);
//	}
//}
