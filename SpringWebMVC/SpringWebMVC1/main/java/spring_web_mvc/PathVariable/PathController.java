package spring_web_mvc.PathVariable;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
//otomatis mengambil nilai dari url, dan mengisinya ke parameter
@Controller
public class PathController {

    @GetMapping("/orders/{orderId}/products/{productId}")
    @ResponseBody
    public String order(@PathVariable(name = "orderId") String orderId,@PathVariable(name = "productId") String productId){
        return "OrderId: "+orderId+", ProductId: "+productId;
    }

}
