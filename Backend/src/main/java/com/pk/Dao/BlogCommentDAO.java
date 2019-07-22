package com.pk.Dao;

import java.util.List;

import com.pk.Model.BlogComment;

public interface BlogCommentDAO 
{
     public boolean addComment(BlogComment blogComment);
     public boolean deleteComment(BlogComment blogComment);
     public BlogComment getBlogComment(int blogCommentId);
     public List<BlogComment> listBlogComments(int blogId);
}
