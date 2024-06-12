package jp.co.creambakery.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import jp.co.creambakery.entity.Cream;


public interface CreamRepository extends JpaRepository<Cream, Integer>{
List<Cream>findAllByOrderByDate_createdAsc();

}
