package com.tomson.controller;

import com.tomson.dto.CreatePropertyDto;
import com.tomson.dto.CreateRoomDto;
import com.tomson.dto.CreateItemDto;
import com.tomson.model.Property;
import com.tomson.model.Room;
import com.tomson.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.tomson.service.PropertyService;

@RestController
@RequestMapping("/property")

public class PropertyController {

    @Autowired
    private PropertyService propertyService;

    @PostMapping
    public Property createProperty(@RequestBody final CreatePropertyDto property) { return propertyService.createProperty(property); }

    @GetMapping(value = "/{id}")
    public Property getProperty (@PathVariable(value = "id") Long propertyId) {
        return propertyService.getPropery(propertyId);
    }

    @PostMapping("/{propertyId}/room")
    public Room createRoom(@RequestBody final CreateRoomDto room, @PathVariable Long propertyId) {
        return propertyService.createRoom(room, propertyId);
    }

    @PostMapping("/room/item")
    public Item createItem(@RequestBody final CreateItemDto item) {
        return propertyService.createItem(item);
    }
}
