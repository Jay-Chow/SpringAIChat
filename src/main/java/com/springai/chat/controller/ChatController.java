package com.springai.chat.controller;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChatController {

    private final ChatClient chatClient;

    // The ChatClient bean we defined in Config.java is injected here.
    public ChatController(ChatClient ollamaChatClient) {
        this.chatClient = ollamaChatClient;
    }

    @GetMapping("/chat")
    public String askOllama(@RequestParam(defaultValue = "Tell me a joke") String prompt) {
        return chatClient.prompt()
                .user(prompt)
                .call()
                .content();
    }
}
