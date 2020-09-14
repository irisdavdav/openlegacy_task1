package com.task.openlegacy.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.task.openlegacy.entity.Item;
import com.task.openlegacy.service.ItemService;

import io.swagger.annotations.ApiOperation;

@RestController
public class ItemRestController {

	@Autowired
	private ItemService itemService;

	@GetMapping("/")
	public String sayHello() {
		return "Hello my name is Iris";
	}

	
	@GetMapping("/items")
	@ApiOperation(value = "List of the inventory items list", response = Item.class)
	public List<Item> getAllItems() {
		return itemService.getAllItems();
	}
	
	@GetMapping("/items/{itemNo}")
	@ApiOperation(value = "Read item details (by item no)", response = Item.class)
	public Item getItem(@PathVariable int itemNo) {
		return itemService.getItemById(itemNo);
	}
	
	@PutMapping("/items/{itemNo}/withdrawal/{quantity}")
	@ApiOperation(value = "Withdrawal quantity of a specific item from stock", response = Item.class)
	public void withdrawalItem(@PathVariable int itemNo, @PathVariable int quantity) {
		 itemService.updateItemforwithdrawal(itemNo,quantity);
	}

	@PutMapping("/items/{itemNo}/deposit/{quantity}")
	@ApiOperation(value = "Deposit quantity of a specific item to stock", response = Item.class)
	public void depositItem(@PathVariable int itemNo, @PathVariable int quantity) {
		itemService.updateItemforDeposit(itemNo, quantity);

	}
	
	@PostMapping("/items")
	@ApiOperation(value = "Add an items to stock", response = Item.class)
	public Item addItem(@RequestBody Item item) {
		return itemService.addItem(item);
	}
	
	@DeleteMapping("/items/{item_no}")
	@ApiOperation( value = "Delete an item from stock", response = Item.class)
	public void deleteItem(@PathVariable("itemNo") int itemNo) {
		itemService.deleteItem(itemNo);
	}
	
}
