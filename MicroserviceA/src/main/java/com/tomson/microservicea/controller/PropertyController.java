package com.tomson.microservicea.controller;

import com.tomson.microservicea.dto.CreateItemDto;
import com.tomson.microservicea.dto.CreateRoomDto;
import com.tomson.microservicea.dto.CreatePropertyDto;
import com.tomson.microservicea.model.Item;
import com.tomson.microservicea.model.Room;
import com.tomson.microservicea.model.Property;
import com.tomson.microservicea.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
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
    @GetMapping("/types")
    public List<String> getAllTypes() {
        return propertyService.getAllTypes();
    }
}
