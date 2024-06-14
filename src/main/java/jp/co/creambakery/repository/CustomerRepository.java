package jp.co.creambakery.repository;
import java.util.*;

import org.springframework.data.jpa.repository.*;

import jp.co.creambakery.entity.*;

public interface  CustomerRepository extends JpaRepository<Customer,Integer>
{
    List<Customer>findAllByOrderByDateCreatedAsc();
    Customer findByEmailAndPassword(String email, String password);
}