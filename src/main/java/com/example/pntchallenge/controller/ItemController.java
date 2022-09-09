package com.example.pntchallenge.controller;
import java.net.URI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import com.example.pntchallenge.dao.ItemDAO;
import com.example.pntchallenge.model.Item;
import com.example.pntchallenge.model.Items;

@RestController
@RequestMapping(path = "/Item")
public class ItemController
{
    @Autowired
    private ItemDAO ItemDao;

    @GetMapping(path="/item", produces = "application/json")
    public Items getItems()
    {
        return ItemDao.getAllItems();
    }

    @GetMapping (path="/item/{id}")
    public String checkItem(@PathVariable int id){
        return ItemDao.getItem(id);
    }

    @PostMapping(path= "/", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Object> addItem(
            @RequestHeader(name = "X-COM-PERSIST", required = true) String headerPersist,
            @RequestHeader(name = "X-COM-LOCATION", required = false, defaultValue = "ASIA") String headerLocation,
            @RequestBody Item item)
            throws Exception
    {
        Integer id = ItemDao.getAllItems().getItemList().size() + 1;
        item.setId(id);

        ItemDao.addItem(item);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(item.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }
}
