package jp.co.creambakery.repository;
import java.util.*;

import org.springframework.data.jpa.repository.*;
import jp.co.creambakery.entity.*;
import jp.co.creambakery.entity.keys.*;

public interface FavoriteRepository extends JpaRepository<Favorite, FavoriteKey>
{   
    List<Favorite> findAllByOwnerId(Integer id);
}
