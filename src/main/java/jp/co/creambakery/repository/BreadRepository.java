package jp.co.creambakery.repository;

import java.util.*;

import org.springframework.data.jpa.repository.*;

import jp.co.creambakery.entity.*;


public interface BreadRepository extends JpaRepository<Bread, Integer>
{
	List<Bread>findAllByOrderByDateCreatedAsc();
	@Query("SELECT b FROM Bread b WHERE b.deleted = 0")
    List<Bread> findAllNotDeleted();
}
