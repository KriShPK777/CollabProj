package CollProj.Backend.Dao;

import java.util.List;

import CollProj.Backend.Model.Blog;

public interface BlogDAO 
{
    public boolean addBlog(Blog blog);
    public boolean deleteBlog(Blog blog);
    public boolean updateBlog(Blog blog);
    public List<Blog> listBlogs();
    public Blog getBlog(int blogId);
    
    public boolean incrementLikes(int blogId);
    public boolean incrementDisLikes(int blogId);
    
    public boolean approveBlog(Blog blog);
    public boolean rejectBlog(Blog blog);
	
}
