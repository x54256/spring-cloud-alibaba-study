package cn.x5456.common;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

//商品
@Entity(name = "shop_product")
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer pid;//主键

    private String pname;//商品名称
    private Double pprice;//商品价格
    private Integer stock;//库存

    /*
    INSERT INTO shop_product VALUE(NULL,'小米','1000','5000');
    INSERT INTO shop_product VALUE(NULL,'华为','2000','5000');
    INSERT INTO shop_product VALUE(NULL,'苹果','3000','5000');
    INSERT INTO shop_product VALUE(NULL,'OPPO','4000','5000');
     */
}