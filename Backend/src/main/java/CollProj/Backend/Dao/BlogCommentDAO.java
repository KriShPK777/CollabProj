package CollProj.Backend.Dao;

import java.util.List;

import CollProj.Backend.Model.BlogComment;

public interface BlogCommentDAO 
{
     public boolean addComment(BlogComment blogComment);
     public boolean deleteComment(BlogComment blogComment);
     public BlogComment getBlogComment(int blogCommentId);
     public List<BlogComment> listBlogComments(int blogId);
}
