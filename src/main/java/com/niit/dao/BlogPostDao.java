package com.niit.dao;

import java.util.List;

import com.niit.model.BlogComment;
import com.niit.model.BlogPost;

public interface BlogPostDao 
{
void saveBlogPost(BlogPost blogpost);
List<BlogPost> getAllBlogs(int approved);
void updateBlogPost(BlogPost blogPost);
BlogPost getBlogById(int id);
List<BlogComment> getBlogComments(int blogId);
void addBlogComment(BlogComment blogComment);
}