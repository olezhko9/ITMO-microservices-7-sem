package com.microservices.warehouse.dao;

import com.microservices.warehouse.dto.ItemCreationDto;
import com.microservices.warehouse.dto.ItemDto;
import com.microservices.warehouse.model.Item;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository("sqlDao")
public class WarehouseDataService implements ItemDao {

    private static List<Item> DB = new ArrayList<>();
    private static final String CONNECTION_STRING = "jdbc:sqlite:warehouse.db";
    private Connection connection;

    public WarehouseDataService() {
        try {
            connection = DriverManager.getConnection(CONNECTION_STRING);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public ItemDto addItem(ItemCreationDto itemCreationDto) {
        Item createdItem = itemCreationDto.toItem();

        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(
                    "INSERT INTO items ('name', 'price', 'actualAmount', 'availableAmount')" +
                            "VALUES (?, ?, ?, ?)"
            );

            statement.setString(1, itemCreationDto.getName());
            statement.setFloat(2, itemCreationDto.getPrice());
            statement.setInt(3, itemCreationDto.getAmount());
            statement.setInt(4, itemCreationDto.getAmount());
            statement.executeUpdate();

            ResultSet itemID = statement.getGeneratedKeys();
            if (itemID.next()) {
                createdItem.setId(itemID.getInt(1));
                return ItemDto.fromItem(createdItem);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public List<ItemDto> getAllItems() {
        return DB.stream()
                .map(ItemDto::fromItem)
                .collect(Collectors.toList());
    }

    @Override
    public ItemDto getItemById(int id) {
        Optional<Item> item = DB.stream()
                .filter(_item -> _item.getId() == id)
                .findFirst();
        return item.map(ItemDto::fromItem).orElse(null);
    }

    @Override
    public ItemDto updateItemAmount(int id, String amountType, int amountDiff) {
        Optional<Item> item = DB.stream()
                .filter(_item -> _item.getId() == id)
                .findFirst();

        if (item.isPresent()) {
            int itemIdx = DB.indexOf(item.get());
            Item itemToUpdate = item.get();
            System.out.println(itemIdx);

            if (amountType.equals("actual")) {
                itemToUpdate.setActualAmount(itemToUpdate.getActualAmount() + amountDiff);
            }
            else if (amountType.equals("available")) {
                itemToUpdate.setAvailableAmount(itemToUpdate.getAvailableAmount() + amountDiff);
            }
            DB.set(itemIdx, itemToUpdate);
            return ItemDto.fromItem(itemToUpdate);
        } else {
            return null;
        }
    }
}
