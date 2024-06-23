package demo.admin.feign;

import common.request.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "sale-service")
public interface SaleFeignClient {

    @GetMapping("/sale/greet")
    String greetSaleService();


    @PostMapping("/sale/greet/print-user")
    User printUser(User user);

}
