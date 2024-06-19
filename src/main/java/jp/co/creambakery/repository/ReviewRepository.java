package jp.co.creambakery.repository;

import java.util.*;

import org.springframework.data.jpa.repository.*;

import jp.co.creambakery.entity.*;
import jp.co.creambakery.entity.keys.*;

public interface ReviewRepository extends JpaRepository<Review, ReviewKey>{
    Review findByPosterAndItem(Customer poster, Item item);
    @Query("SELECT r FROM Review r WHERE r.deleted = 0")
    List<Review> findAllNotDeleted();
    @Query("SELECT r FROM Review r WHERE r.deleted = 0 AND r.poster.id = poster.id")
    List<Review> findByPosterNotDeleted(Customer poster);
}
