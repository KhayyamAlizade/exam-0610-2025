package az.ingress.client;



import com.fasterxml.jackson.databind.JsonNode;

import com.fasterxml.jackson.databind.ObjectMapper;
import feign.Response;

import feign.codec.ErrorDecoder;
import lombok.extern.slf4j.Slf4j;

import static org.springframework.boot.web.error.ErrorAttributeOptions.Include.MESSAGE;

@Slf4j
public class CustomErrorDecoder implements ErrorDecoder {

    @Override
    public Exception decode(String methodKey, Response response) {
        var errorMessage = CLIENT_ERROR_MESSAGE;
        var errorCode = CLIENT_ERROR_CODE;

        JsonNode jsonNode;
        try (var body = response.body().asInputStream()) {
            jsonNode = new ObjectMapper().readValue(body, JsonNode.class);
        } catch (Exception e) {
            throw new CustomFeignException(errorMessage, response.status(), errorCode);
        }

        if (jsonNode.has(MESSAGE.getValue())) {
            errorMessage = jsonNode.get(MESSAGE.getValue()).asText();
        }

        if (jsonNode.has(CODE.getValue())) {
            errorCode = jsonNode.get(CODE.getValue()).asText();
        }

        log.error("ActionLog.decode.error Message: {}, Method: {}", errorMessage, methodKey);
        return new CustomFeignException(errorMessage, response.status(), errorCode);
    }
}


