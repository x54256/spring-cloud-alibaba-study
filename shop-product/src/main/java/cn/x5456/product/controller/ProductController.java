package cn.x5456.product.controller;

import cn.x5456.common.JsonUtils;
import cn.x5456.common.Product;
import cn.x5456.product.dao.ProductDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class ProductController {

    @Autowired
    private ProductDao productDao;

    //商品信息查询
    @RequestMapping("/product/{pid}")
    public Product product(@PathVariable("pid") Integer pid) {
        log.info("接下来要进行{}号商品信息的查询", pid);
        Product product = productDao.findById(pid).get();
        log.info("商品信息查询成功,内容为{}", JsonUtils.toString(product));
        return product;
    }

    @Transactional
    @RequestMapping("/product/reduceInventory")
    public void reduceInventory(@RequestParam("pid") Integer pid, @RequestParam("num") Integer num) {
        Product product = productDao.findById(pid).get();
        product.setStock(product.getStock() - num);
        productDao.save(product);

//        int i = 1 / 0;
    }

}
