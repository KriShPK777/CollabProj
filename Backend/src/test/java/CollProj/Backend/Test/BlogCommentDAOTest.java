package CollProj.Backend.Test;

import static org.junit.Assert.assertTrue;

import java.util.List;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import CollProj.Backend.Dao.BlogCommentDAO;
import CollProj.Backend.Model.BlogComment;

public class BlogCommentDAOTest 
{
    static BlogCommentDAO blogCommentDAO;
    
    @BeforeClass
    public static void executeFirst()
    {
    	 AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
    	 context.scan("CollProj.Backend");
    	 context.refresh();
    	 
    	 blogCommentDAO=(BlogCommentDAO)context.getBean("blogCommentDAO");
    }
    @Test
    public void addBlogCommentTest()
    {
    	BlogComment comment=new BlogComment();
    	comment.setCommentText("Nice Blog");
    	comment.setUsername("Sam");
    	
    	
    	assertTrue("Problem in Adding a Blog Comment",blogCommentDAO.addComment(comment));
    }
	
    @Test
    public void listBlogcomments()
    {
    	List<BlogComment> listBlogComments=blogCommentDAO.listBlogComments(952);
    	
    	assertTrue("Problem in displaying Comments",listBlogComments.size()>0);
    	
    	for(BlogComment comment:listBlogComments)
    	{
    		System.out.print(comment.getCommentText()+":::");
    		System.out.println(comment.getUsername());
    	}
    	
    }
    @Test
    public void deleteBlogCommentTest()
    {
    	BlogComment comment=blogCommentDAO.getBlogComment(973);
    	
    	assertTrue("Problem in Deleting Comment:",blogCommentDAO.deleteComment(comment));
    	}
}
