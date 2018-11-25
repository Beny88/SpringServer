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
import java.util.List;

@RestController
@RequestMapping("/property")
public class PropertyController {

    @Autowired
    private PropertyService propertyService;

    @PostMapping
    public Property createProperty(@RequestBody final CreatePropertyDto property) { return propertyService.createProperty(property); }

    @GetMapping(value = "/{id}")
    public Property getProperty (@PathVariable(value = "id") Long propertyId) {
        return propertyService.getProperty(propertyId);
    }
    @GetMapping("/{propertyId}/room")
    public List<Room> getRoomForProperty(@PathVariable(value = "propertyId") Long propertyId) {
        return propertyService.getRoomForProperty(propertyId);
    }

    @PostMapping("/{propertyId}/room")
    public Room createRoom(@RequestBody final CreateRoomDto room, @PathVariable  Long propertyId) {
        return propertyService.createRoom(room, propertyId);
    }

    @PostMapping("/{roomId}/item")
    public Item createItem(@RequestBody final CreateItemDto item, @PathVariable  Long roomId) {
        return propertyService.createItem(item, roomId);
    }
}
