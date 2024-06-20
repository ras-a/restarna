package jp.co.creambakery.repository;

import java.util.*;

import org.springframework.data.jpa.repository.*;

import jp.co.creambakery.entity.*;
import jp.co.creambakery.entity.keys.*;

public interface CartRepository extends JpaRepository<Cart, CartKey>
{
    List<Cart>findAllByUserId(Integer id);
}
