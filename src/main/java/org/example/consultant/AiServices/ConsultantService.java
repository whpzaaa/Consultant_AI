package org.example.consultant.AiServices;


import dev.langchain4j.service.MemoryId;
import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.UserMessage;
import dev.langchain4j.service.V;
import dev.langchain4j.service.spring.AiService;
import dev.langchain4j.service.spring.AiServiceWiringMode;
import org.example.consultant.tools.ReservationTool;
import reactor.core.publisher.Flux;

@AiService(
        wiringMode = AiServiceWiringMode.EXPLICIT,//手动装配
        //chatModel = "openAiChatModel"//选择模型
        streamingChatModel = "openAiStreamingChatModel",
        //chatMemory = "chatMemory"
        chatMemoryProvider = "chatMemoryProvider",
        contentRetriever = "embeddingStoreContentRetriever",
        tools = "reservationTool"
)
//@AiService
public interface ConsultantService {
    //public String chat(String message);

    //@UserMessage("你是菜汗，{{it}}")
//    @UserMessage("你是菜汗，{{msg}}")
//    public Flux<String> chat(@V("msg") String message);

    //@SystemMessage("你是菜汗")
    @SystemMessage(fromResource = "system.txt")
    public Flux<String> chat(@MemoryId String memoryId, @UserMessage String message);
}
