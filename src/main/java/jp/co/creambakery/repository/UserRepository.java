package jp.co.creambakery.repository;
import java.util.*;

import org.springframework.data.jpa.repository.*;

import jp.co.creambakery.entity.*;

public interface  UserRepository extends JpaRepository<User,Integer>
{
    List<User>findAllByOrderByDateCreatedAsc();
    User findByEmailAndPassword(String email, String password);
    @Query("SELECT c FROM User c WHERE c.deleted = 0")
    List<User> findAllNotDeleted();
}