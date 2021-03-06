package com.tomson.microservicea.service;

import com.tomson.microservicea.dto.CreateItemDto;
import com.tomson.microservicea.dto.CreateRoomDto;
import com.tomson.microservicea.external.TypeService;
import com.tomson.microservicea.model.Item;
import com.tomson.microservicea.model.Room;
import com.tomson.microservicea.repository.ItemRepository;
import com.tomson.microservicea.repository.PropertyRepository;
import com.tomson.microservicea.repository.RoomRepository;
import com.tomson.microservicea.model.Property;
import com.tomson.microservicea.dto.CreatePropertyDto;
import com.tomson.microservicea.model.Typeable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class PropertyServiceImpl implements PropertyService {
    private PropertyRepository propertyRepository;
    private RoomRepository roomRepository;
    private ItemRepository itemRepository;
    private TypeService typeService;

    public PropertyServiceImpl(PropertyRepository propertyRepository, RoomRepository roomRepository, ItemRepository itemRepository, TypeService typeService) {
        this.propertyRepository = propertyRepository;
        this.roomRepository = roomRepository;
        this.itemRepository = itemRepository;
        this.typeService = typeService;
    }

    @Override
    public Property getProperty (final Long propertyId) {
        return propertyRepository.findById(propertyId).orElse(null);
    }

    @Override
    public List<Room> getRoomForProperty (final Long propertyId){
        return propertyRepository.findById(propertyId).orElseThrow(()-> new NullPointerException()).getRoomList();
    }

    @Override
    @Transactional
    public Property createProperty(final CreatePropertyDto createPropertyDto){
        final Property property = new Property();
        property.setHouseType(createPropertyDto.getHouseType());

        return propertyRepository.save(property);
    }

    @Override
    @Transactional
    public Room createRoom(final CreateRoomDto createRoomDto, final Long propertyId){
        final Room room = new Room();
        final Property property = propertyRepository.findById(propertyId).orElseThrow(() -> new NullPointerException());
        room.setProperty(property);
        room.setRoomType(createRoomDto.getRoomType());
        room.setAmmount(createRoomDto.getAmmount());

        return roomRepository.save(room);
    }

    @Override
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

    @Override
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

