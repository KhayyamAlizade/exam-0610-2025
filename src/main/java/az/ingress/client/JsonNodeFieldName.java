package az.ingress.client;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;

@Getter
@RequiredArgsConstructor
public enum JsonNodeFieldName {
    MESSAGE("message"),
    CODE("code");

    private final String name;

}
