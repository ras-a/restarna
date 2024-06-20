package jp.co.creambakery.repository;

import java.util.*;
import org.springframework.data.jpa.repository.*;
import jp.co.creambakery.entity.*;

public interface ItemRepository extends JpaRepository<Item, Integer>
{

	@Query("SELECT i FROM Item i WHERE i.deleted = 0 AND i.store IS NOT NULL")
	List<Item> findAllNotDeletedByStoreIsNotNull();

	@Query("SELECT i FROM Item i JOIN i.creams c GROUP BY i ORDER BY SUM(c.price) + i.bread.price")
    List<Item>findAllByOrderByPrice();
	List<Item>findAllByOrderByDateCreated();
	List<Item>findAllByBreadAndCreamsContainsAndNameContaining(Bread bread, Cream cream, String itemName);
	
}
