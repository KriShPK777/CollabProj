package com.pk.Controller;



import java.util.Date;


import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.RestController;

import com.pk.Model.Message;
import com.pk.Model.OutputMessage;

@RestController
public class ChatRestController 
{
	
	@MessageMapping("/chat")
	@SendTo("/topic/message")
	public OutputMessage sendMessage(Message message)
	{

		return new OutputMessage(message, new Date());
     
	}
                
}
	

