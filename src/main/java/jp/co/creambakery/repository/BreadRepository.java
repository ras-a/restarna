package jp.co.creambakery.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import jp.co.creambakery.entity.Bread;


public interface BreadRepository extends JpaRepository<Bread, Integer>{

List<Bread>findAllByOrderByDate_createdAsc();

}
