package com.tomson.service;




import com.tomson.model.Property;
import com.tomson.model.Room;
import com.tomson.model.Item;
import com.tomson.dto.CreatePropertyDto;
import com.tomson.dto.CreateRoomDto;
import com.tomson.dto.CreateItemDto;
import com.tomson.repository.ItemRepository;
import com.tomson.repository.RoomRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.tomson.repository.PropertyRepository;


@Service
public class PropertyService {
    private PropertyRepository propertyRepository;
    private RoomRepository roomRepository;
    private ItemRepository itemRepository;

    public PropertyService(PropertyRepository propertyRepository, RoomRepository roomRepository,ItemRepository itemRepository) {
        this.propertyRepository = propertyRepository;
        this.roomRepository = roomRepository;
        this.itemRepository = itemRepository;
    }

    @Transactional
    public Property createProperty(final CreatePropertyDto createPropertyDto){
        final Property property = new Property();
        property.setHouseType(createPropertyDto.getHouseType());

        return propertyRepository.save(property);
    }

    @Transactional
    public Room createRoom(final CreateRoomDto createRoomDto){
        final Room room = new Room();
        room.setRoomType(createRoomDto.getRoomType());

        return roomRepository.save(room);
    }

    @Transactional
    public Item createItem(final CreateItemDto createItemDto){
        final Item item = new Item();
        item.setItemName(createItemDto.getItemName());
        item.setItemType(createItemDto.getItemType());
        item.setItemAmount(createItemDto.getItemAmount());
        return itemRepository.save(item);
    }
}
