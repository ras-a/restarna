package jp.co.creambakery.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import jp.co.creambakery.entity.Admin;

public interface  AdminRepository extends JpaRepository<Admin,Integer>
{
    
}
