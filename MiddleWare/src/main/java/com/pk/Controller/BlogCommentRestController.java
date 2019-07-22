package com.pk.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pk.Dao.BlogCommentDAO;
import com.pk.Model.Blog;
import com.pk.Model.BlogComment;

@RestController
public class BlogCommentRestController 
{
	 @Autowired
	  BlogCommentDAO blogCommentDAO;
		

	    @GetMapping(value="/getAllBlogComments/{blogId}")
	    public ResponseEntity<List<BlogComment>> getAllBlogComment(@PathVariable("blogId")int blogId)
	    {
	    	List<BlogComment> listBlogComments=blogCommentDAO.listBlogComments(blogId);	    	
	    	if(listBlogComments.size()>0)
	    	{
	    		return new  ResponseEntity<List<BlogComment>>(listBlogComments,HttpStatus.OK);
	    	}
	    	else
	    	{
	    		return new  ResponseEntity<List<BlogComment>>(listBlogComments,HttpStatus.NOT_FOUND);
	    	}
	    }
	     

	    @PostMapping(value="/addComment")
	    public ResponseEntity<String> addComment(@RequestBody BlogComment comment)
	    {
	    	if(blogCommentDAO.addComment(comment))
	    	{
	    		return new  ResponseEntity<String>("Blog Comment Added Successfully",HttpStatus.OK);
	    	}
	    	else
	    	{
	    		return new  ResponseEntity<String>("Problem Occured While Adding Comment",HttpStatus.NOT_FOUND);
	    	}
	    }
}
