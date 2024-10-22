package spring.redis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import spring.redis.model.Product;

import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @PostMapping
    public void createProduct(@RequestBody Product product) {
        redisTemplate.opsForValue().set("product:" + product.getId(), product, 10, TimeUnit.MINUTES);
    }

    @GetMapping("/{id}")
    public Product getProduct(@PathVariable String id) {
        return (Product) redisTemplate.opsForValue().get("product:" + id);
    }

}
