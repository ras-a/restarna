package jp.co.creambakery.repository;

import java.util.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.*;
import jp.co.creambakery.entity.*;

public interface ItemRepository extends JpaRepository<Item, Integer>
{

	@Query("SELECT i FROM Item i WHERE i.deleted = 0 AND i.store IS NOT NULL")
	List<Item> findAllStoreItems();
	@Query("SELECT i FROM Item i WHERE i.deleted = 0 AND i.custom IS NOT NULL")
	List<Item> findAllCustomItems();

	@Query("SELECT i FROM Item i JOIN i.creams c GROUP BY i ORDER BY SUM(c.price) + i.bread.price")
    List<Item>findAllByOrderByPrice();
	List<Item>findAllByOrderByDateCreated();

	@Query("SELECT i FROM Item i WHERE (:bread IS NULL OR i.bread = :bread) AND (:nCreams = 0 OR (SELECT COUNT(c) FROM i.creams c WHERE c IN :creams) = :nCreams) AND (:name IS NULL OR i.name LIKE %:name% ESCAPE '_')")
	List<Item>findAllFiltered(@Param("bread") Bread bread, @Param("creams") List<Cream> creams,
	                          @Param("nCreams") Integer nCreams, @Param("name") String name);
	@Query("SELECT i FROM Item i WHERE (:bread IS NULL OR i.bread = :bread) AND (:nCreams = 0 OR (SELECT COUNT(c) FROM i.creams c WHERE c IN :creams) = :nCreams) AND (:name IS NULL OR i.name LIKE %:name% ESCAPE '_') ORDER BY i.name")
	List<Item>findAllFilteredOrderByName(@Param("bread") Bread bread, @Param("creams") List<Cream> creams,
										@Param("nCreams") Integer nCreams, @Param("name") String name);
	@Query("SELECT i FROM Item i WHERE (:bread IS NULL OR i.bread = :bread) AND (:nCreams = 0 OR (SELECT COUNT(c) FROM i.creams c WHERE c IN :creams) = :nCreams) AND (:name IS NULL OR i.name LIKE %:name% ESCAPE '_') ORDER BY i.dateCreated")
	List<Item>findAllFilteredOrderByDate(@Param("bread") Bread bread, @Param("creams") List<Cream> creams,
										@Param("nCreams") Integer nCreams, @Param("name") String name);
	@Query("SELECT i FROM Item i JOIN i.creams c WHERE (:bread IS NULL OR i.bread = :bread) AND (:nCreams = 0 OR (SELECT COUNT(c) FROM i.creams c WHERE c IN :creams) = :nCreams) AND (:name IS NULL OR i.name LIKE %:name% ESCAPE '_') GROUP BY i ORDER BY SUM(c.price) + i.bread.price")
	List<Item>findAllFilteredOrderByPrice(@Param("bread") Bread bread, @Param("creams") List<Cream> creams,
	                          @Param("nCreams") Integer nCreams, @Param("name") String name);
	@Query("SELECT i FROM Item i WHERE (:bread IS NULL OR i.bread = :bread) AND (:nCreams = 0 OR (SELECT COUNT(c) FROM i.creams c WHERE c IN :creams) = :nCreams) AND (:name IS NULL OR i.name LIKE %:name% ESCAPE '_') ORDER BY i.name DESC")
	List<Item>findAllFilteredOrderByNameDesc(@Param("bread") Bread bread, @Param("creams") List<Cream> creams,
										@Param("nCreams") Integer nCreams, @Param("name") String name);
	@Query("SELECT i FROM Item i WHERE (:bread IS NULL OR i.bread = :bread) AND (:nCreams = 0 OR (SELECT COUNT(c) FROM i.creams c WHERE c IN :creams) = :nCreams) AND (:name IS NULL OR i.name LIKE %:name% ESCAPE '_') ORDER BY i.dateCreated DESC")
	List<Item>findAllFilteredOrderByDateDesc(@Param("bread") Bread bread, @Param("creams") List<Cream> creams,
										@Param("nCreams") Integer nCreams, @Param("name") String name);
	@Query("SELECT i FROM Item i JOIN i.creams c WHERE (:bread IS NULL OR i.bread = :bread) AND (:nCreams = 0 OR (SELECT COUNT(c) FROM i.creams c WHERE c IN :creams) = :nCreams) AND (:name IS NULL OR i.name LIKE %:name% ESCAPE '_') GROUP BY i ORDER BY SUM(c.price) + i.bread.price DESC")
	List<Item>findAllFilteredOrderByPriceDesc(@Param("bread") Bread bread, @Param("creams") List<Cream> creams,
										@Param("nCreams") Integer nCreams, @Param("name") String name);
}
