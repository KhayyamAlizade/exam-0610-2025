package az.ingress.controller.order;

import az.ingress.model.client.request.ProductResponse;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "ms-product",url = "http://localhost:8084/internal/v1/api/products")
public interface OrderController {

    @GetMapping("/{id}")
     ProductResponse getOrder(@RequestParam Long id);
}
