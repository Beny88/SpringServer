package com.tomson.service;

import com.tomson.external.TypeService;
import com.tomson.model.Property;
import com.tomson.model.Room;
import com.tomson.model.Item;
import com.tomson.dto.CreatePropertyDto;
import com.tomson.dto.CreateRoomDto;
import com.tomson.dto.CreateItemDto;
import com.tomson.model.Typeable;
import com.tomson.repository.ItemRepository;
import com.tomson.repository.RoomRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.tomson.repository.PropertyRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class PropertyService {
    private PropertyRepository propertyRepository;
    private RoomRepository roomRepository;
    private ItemRepository itemRepository;
    private TypeService typeService;

    public PropertyService(PropertyRepository propertyRepository, RoomRepository roomRepository,ItemRepository itemRepository, TypeService typeService) {
        this.propertyRepository = propertyRepository;
        this.roomRepository = roomRepository;
        this.itemRepository = itemRepository;
        this.typeService = typeService;
    }
    public Property getProperty (final Long propertyId) {
        return propertyRepository.findById(propertyId).orElse(null);
    }

    public List<Room> getRoomForProperty (Long propertyId){
        return propertyRepository.findById(propertyId).orElseThrow(()-> new NullPointerException()).getRoomList();
    }

    @Transactional
    public Property createProperty(final CreatePropertyDto createPropertyDto){
        final Property property = new Property();
        property.setHouseType(createPropertyDto.getHouseType());

        return propertyRepository.save(property);
    }

    @Transactional
    public Room createRoom(final CreateRoomDto createRoomDto, final Long propertyId){
        final Room room = new Room();
        final Property property = propertyRepository.findById(propertyId).orElseThrow(() -> new NullPointerException());
        room.setProperty(property);
        room.setRoomType(createRoomDto.getRoomType());
        room.setAmmount(createRoomDto.getAmmount());

        return roomRepository.save(room);
    }

    @Transactional
    public Item createItem(final CreateItemDto createItemDto, final Long roomId){
        final Item item = new Item();
        final Room room = roomRepository.findById(roomId).orElseThrow(() -> new NullPointerException());
        item.setRoom(room);
        item.setItemName(createItemDto.getItemName());
        item.setItemType(createItemDto.getItemType());
        item.setItemAmount(createItemDto.getItemAmount());
        return itemRepository.save(item);
    }

    @Transactional
    public List<String> getAllTypes() {
        final List<Typeable> allObjectList = new ArrayList<>();

        //tutal w  petlach poddowaja  wsyztkie objety do tej listy
        propertyRepository.findAll().forEach(property -> {
            allObjectList.add(property);

            allObjectList.addAll(property.getRoomList());

            property.getRoomList().forEach(room -> allObjectList.addAll(room.getItemList()));
        });
        return typeService.getAllObjectTypes(allObjectList);
    }
}

