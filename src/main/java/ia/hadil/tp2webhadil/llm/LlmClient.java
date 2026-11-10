package ia.hadil.tp2webhadil.llm;

import dev.langchain4j.data.message.SystemMessage;
import dev.langchain4j.memory.ChatMemory;
import dev.langchain4j.memory.chat.MessageWindowChatMemory;
import dev.langchain4j.model.chat.ChatModel;
import dev.langchain4j.model.google.genai.GoogleGenAiChatModel;
import dev.langchain4j.service.AiServices;
import jakarta.enterprise.context.Dependent;

import java.io.Serializable;

@Dependent
public class LlmClient implements Serializable {

    private String systemRole;
    private Assistant assistant;
    private ChatMemory chatMemory;

    public LlmClient() {
        String cle = System.getenv("GEMINI_KEY");

        ChatModel modele = GoogleGenAiChatModel.builder()
                .apiKey(cle)
                .modelName("gemini-3.5-flash-lite")
                .temperature(0.7)
                .build();

        this.chatMemory = MessageWindowChatMemory.withMaxMessages(20);
        this.assistant = AiServices.builder(Assistant.class)
                .chatModel(modele)
                .chatMemory(chatMemory)
                .build();
    }

    public void setSystemRole(String systemRole) {
        this.systemRole = systemRole;
        chatMemory.clear();
        chatMemory.add(SystemMessage.from(systemRole));
    }

    public String envoyerRequete(String prompt) {
        return assistant.chat(prompt);
    }
}