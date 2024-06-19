package jp.co.creambakery.repository;

import java.util.*;
import org.springframework.data.jpa.repository.*;
import jp.co.creambakery.entity.*;

public interface ItemRepository extends JpaRepository<Item, Integer>
{
	List<Item> findAllByOrderByDateCreatedAsc();
	@Query("SELECT i FROM Item i WHERE i.deleted = 0 AND i.store IS NOT NULL")
	List<Item> findAllNotDeletedByStoreIsNotNull();

}
