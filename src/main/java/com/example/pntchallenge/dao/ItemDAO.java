package com.example.pntchallenge.dao;
import com.example.pntchallenge.model.Item;
import org.springframework.stereotype.Repository;
import com.example.pntchallenge.model.Items;

@Repository
public class ItemDAO {
    private static Items itemList = new Items();

    static {
        itemList.getItemList().add(new Item(1, "Corn", "Sweet and Crunchy", 1.79));
        itemList.getItemList().add(new Item(2, "Tissues", "Four-ply for maximum comfort", 3.99));
        itemList.getItemList().add(new Item(3, "Spoon", "Comically Large", 2.50));
        itemList.getItemList().add(new Item(4, "Cookies", "98% Chips", 2.99));
    }

    public Items getAllItems() {
        return itemList;
    }

    public void addItem(Item item) {
        itemList.getItemList().add(item);
    }

    public String getItem(int id) {
        for (int i = itemList.getItemList().size(); i> 0; i--){
            if(itemList.getItemList().get(i-1).getId() == id){
                return itemList.getItemList().get(i-1).toString();
            }
        }
    return "No item with specified id Found";
    }
}
