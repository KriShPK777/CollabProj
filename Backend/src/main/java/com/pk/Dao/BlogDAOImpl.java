package com.pk.Dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.pk.Model.Blog;

@Repository ("BlogDAO")
@Transactional
public class BlogDAOImpl implements BlogDAO
{
   
	@Autowired
	SessionFactory sessionFactory;
	
	
	@Override
	public boolean addBlog(Blog blog) 
	{
	   try
	   {
		   sessionFactory.getCurrentSession().save(blog);
		   return true;
	   }
	   catch(Exception e)
	   {
		return false;
	}
}	   

	@Override
	public boolean deleteBlog(Blog blog) 
	{
		 try
		   {
			   sessionFactory.getCurrentSession().delete(blog);
			   return true;
		   }
		   catch(Exception e)
		   {
		return false;
	}
}
	@Override
	public boolean updateBlog(Blog blog) 
	{
		 try
		   {
			   sessionFactory.getCurrentSession().update(blog);
			   return true;
		   }
		   catch(Exception e)
		   {

		return false;
	}
}		 

	@Override
	public List<Blog> listBlogs() 
	{
		Session session=sessionFactory.openSession();
		Query query=(Query) session.createQuery("from Blog");
		List<Blog> listBlogs=query.list();
		session.close();
		return listBlogs;
	}

	@Override
	public Blog getBlog(int blogId) 
	{
		Session session=sessionFactory.openSession();
		Blog blog=(Blog) session.get(Blog.class, blogId);
		session.close();
		return blog;
	}

	@Override
	public boolean incrementLikes(int blogId) 
	{
		try
		{
			Blog blog=this.getBlog(blogId);
			blog.setLikes(blog.getLikes()+1);
			sessionFactory.getCurrentSession().update(blog);
			return true;			
		}
		catch(Exception e)
		{			
		return false;
	}
}

	@Override
	public boolean incrementDisLikes(int blogId) 
	{
		try
		{
			Blog blog=this.getBlog(blogId);
			blog.setLikes(blog.getDislikes()+1);
			sessionFactory.getCurrentSession().update(blog);
			return true;
		}
		catch(Exception e)
		{	
		return false;
	}
}

	@Override
	public boolean approveBlog(Blog blog) 
	{
		try
		{
			blog.setStatus("A");
			sessionFactory.getCurrentSession().update(blog);
			return true;
		}
		catch(Exception e)
		{
		return false;
	}
	}

	@Override
	public boolean rejectBlog(Blog blog) 
	{
		try
		{
			blog.setStatus("P");
			sessionFactory.getCurrentSession().update(blog);
			return true;
		}
		catch(Exception e)
		{
		return false;
		}
	}
}
	
