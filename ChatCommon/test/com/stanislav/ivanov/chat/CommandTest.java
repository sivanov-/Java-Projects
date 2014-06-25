package com.stanislav.ivanov.chat;

import org.junit.Assert;
import org.junit.Test;

import com.fasterxml.jackson.databind.ObjectMapper;

public class CommandTest {

	@Test
	public void testSerialize() throws Exception {
		
		SendPrivateMessageCommand cmd1 = new SendPrivateMessageCommand();
		cmd1.user = "test-user";
		cmd1.message = "hahahah";
		
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(cmd1);
		
		Command cmd = mapper.readValue(json, Command.class);
		Assert.assertTrue(cmd instanceof SendPrivateMessageCommand);
		SendPrivateMessageCommand cmd2 = (SendPrivateMessageCommand) cmd;
		Assert.assertEquals(cmd1.user, cmd2.user);
		Assert.assertEquals(cmd1.message, cmd2.message);
	}
	
}
