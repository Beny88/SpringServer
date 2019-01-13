package com.tomson.microservicea.service;

import com.tomson.microservicea.dto.CreateItemDto;
import com.tomson.microservicea.dto.CreatePropertyDto;
import com.tomson.microservicea.dto.CreateRoomDto;
import com.tomson.microservicea.model.Item;
import com.tomson.microservicea.model.Property;
import com.tomson.microservicea.model.Room;

import java.util.List;

public interface PropertyService {
    /**
     * This methos is to get propertyby  property id
     * @param propertyId
     * @return
     */
    Property getProperty(final Long propertyId);

    Property createProperty(final CreatePropertyDto property );

    List<Room> getRoomForProperty(final Long propertyId);

    Room createRoom (final CreateRoomDto room, final Long propertyId);

    Item createItem (final CreateItemDto item, final Long roomId);

    List<String> getAllTypes();
}

