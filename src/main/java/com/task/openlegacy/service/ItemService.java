package com.task.openlegacy.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.task.openlegacy.entity.Item;
import com.task.openlegacy.repository.ItemRepository;

@Service
public class ItemService {
	
	@Autowired
	private ItemRepository itemRepository;
	
	public List<Item> getAllItems(){
		List<Item> items = new ArrayList<>();
		itemRepository.findAll().forEach(item -> items.add(item));
		return items;
	}	

	public Item getItemById(int itemNo) {
		Item item = itemRepository.findById(itemNo).orElse(null); 
		return item;
	}

	
	public void updateItemforwithdrawal(int itemNo,int quantity) {
	  	try {
        	Item item = itemRepository.findById(itemNo).orElse(null);
        	int totalRet=item.getAmount()-quantity;
        //	if(totalRet<0) {
        	//	System.out.println("The quatity is bigger than the item's amount");
        		//return;
        	//}
        	item.setAmount(totalRet);
        	itemRepository.save(item);
    	}
    	catch(IllegalArgumentException e) {
    		
    	}
  
    }

	public void updateItemforDeposit(int itemNo,int quantity) {
	  	try {
        	Item item = itemRepository.findById(itemNo).orElse(null);
        	item.setAmount(item.getAmount()+quantity);
        	itemRepository.save(item);
    	}
    	catch(IllegalArgumentException e) {
    		
    	}
  
    }
	
	
	public Item addItem(Item item) {
		itemRepository.save(item);
		return item;
	}	
	
	public void deleteItem(int itemNo) {
		itemRepository.deleteById(itemNo);
	}
 	
}
