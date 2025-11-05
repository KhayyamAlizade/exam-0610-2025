package az.ingress.client;


import az.ingress.exception.CustomFeignException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import feign.Response;
import feign.codec.ErrorDecoder;
import lombok.extern.slf4j.Slf4j;

import static az.ingress.client.JsonNodeFieldName.CODE;
import static az.ingress.client.JsonNodeFieldName.MESSAGE;
import static az.ingress.enums.error.ExceptionConstants.CLIENT_ERROR_CODE;
import static az.ingress.enums.error.ExceptionConstants.CLIENT_ERROR_MESSAGE;


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

        if (jsonNode.has(MESSAGE.getName())) {
            errorMessage = jsonNode.get(MESSAGE.getName()).asText().toString();
        }

        if (jsonNode.has(CODE.getName())) {
            errorCode = jsonNode.get(CODE.getName()).asText();
        }

        log.error("ActionLog.decode.error Message: {}, Method: {}", errorMessage, methodKey);
        return new CustomFeignException(errorMessage, response.status(), errorCode);
    }
}


