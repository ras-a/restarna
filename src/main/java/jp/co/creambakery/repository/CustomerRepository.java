package jp.co.creambakery.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import jp.co.creambakery.entity.Customer;

public interface  CustomerRepository extends JpaRepository<Customer,Integer>
{
    List<Customer>findAllByOrderByDateCreatedAsc();
}