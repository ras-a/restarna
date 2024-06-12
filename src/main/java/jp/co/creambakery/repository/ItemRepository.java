package jp.co.creambakery.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import jp.co.creambakery.entity.Item;

public interface ItemRepository extends JpaRepository<Item, Integer>
{
	List<Item>findAllByOrderByDateCreatedAsc();
}
