package cn.x5456.order.dao;

import cn.x5456.common.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDao extends JpaRepository<Order, Integer> {
}