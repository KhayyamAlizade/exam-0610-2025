package az.ingress.queue;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;

import javax.annotation.PostConstruct;

@Slf4j
@Component
@RequiredArgsConstructor
public class QueueSender {
    private final AmqpTemplate amqpTemlate;
    private final ObjectMapper objectMapper;


    @SneakyThrows
    public void  sendMessageToQ(ChangeCommentViewStatusDto request){
        amqpTemlate.convertAndSend("TEST_Q",objectMapper.writeValueAsString(request));
        log.info("Sending to queue TestQ");

    }

    @PostConstruct
    public void test(){
        sendMessageToQ(new ChangeCommentViewStatusDto(4L));
    }
}
