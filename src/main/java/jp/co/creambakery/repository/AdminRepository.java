package jp.co.creambakery.repository;

import org.springframework.data.jpa.repository.*;

import jp.co.creambakery.entity.*;

public interface  AdminRepository extends JpaRepository<Admin,Integer>
{
    Admin findByNameAndPassword(String name, String password);
}
