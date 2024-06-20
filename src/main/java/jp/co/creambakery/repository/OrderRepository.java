package jp.co.creambakery.repository;

import java.util.*;

import org.springframework.data.jpa.repository.*;
import jp.co.creambakery.entity.*;

public interface OrderRepository extends JpaRepository<ProductOrder, Integer>
{
	List<ProductOrder> findAllByUser(User user);
}
