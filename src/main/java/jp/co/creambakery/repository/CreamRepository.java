package jp.co.creambakery.repository;

import java.util.*;

import org.springframework.data.jpa.repository.*;

import jp.co.creambakery.entity.*;


public interface CreamRepository extends JpaRepository<Cream, Integer>
{
	List<Cream>findAllByOrderByDateCreatedAsc();
	@Query("SELECT c FROM Cream c WHERE c.deleted = 0")
    List<Cream> findAllNotDeleted();
}
