package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Item;
import com.example.demo.repository.ItemRepository;

@Service
public class ItemService {

	@Autowired
	private ItemRepository itemRepository;

	public Item save(final Item item) {
		return itemRepository.save(item);
	}

	public Item findByName(final String name) {
		return itemRepository.findByName(name);
	}

	public List<Item> findAll() {
		return (List<Item>) itemRepository.findAll();
	}

	public void delete(final Item item) {
		itemRepository.delete(item);
	}

	public Item findById(final Long id) {
		return itemRepository.findById(id).get();
	}

	public List<Item> findAll(final Long id) {
		return (List<Item>) itemRepository.findAll();
	}

	public List<Item> findAllById(final List<Long> ids) {
		return (List<Item>) itemRepository.findAllById(ids);
	}

}
