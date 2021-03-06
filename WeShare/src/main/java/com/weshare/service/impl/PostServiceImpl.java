package com.weshare.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.weshare.model.Post;
import com.weshare.repository.PostRepository;
import com.weshare.service.PostService;

@Service
public class PostServiceImpl implements PostService {
	@Autowired
	private PostRepository postRepository;

	@Override
	public List<Post> getAllPosts() {
		return postRepository.findAll();
	}

	@Override
	public void savePost(Post post) {
		postRepository.saveAndFlush(post);
	}

	@Override
	public Post getPostById(int id) {
		return postRepository.findById(id).get();
	}

	@Override
	public void setPostScoreById(int score, int postId) {
		postRepository.setPostScoreById(score, postId);
	}
	
	@Override
	public void setCommentsNumById(int postId, int commentNum)
	{
		postRepository.setCommentsNumById(commentNum, postId);
	}
	
	@Override
	public void deletePost(Post post) {
		postRepository.delete(post);
	}
	
	@Override
	public List<Post> blurrySearch(String query)
	{
		List<Post> postList = postRepository.findByTitleContaining(query);
		
		return postList;
	}
}
