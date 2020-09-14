package com.task.openlegacy.repository;

import org.springframework.data.repository.CrudRepository;

import com.task.openlegacy.entity.Item;

public interface ItemRepository extends CrudRepository<Item, Integer> {

	

}
