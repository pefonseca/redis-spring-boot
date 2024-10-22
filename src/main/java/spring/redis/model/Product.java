package spring.redis.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class Product implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id;
    private String name;
    private double price;

}
