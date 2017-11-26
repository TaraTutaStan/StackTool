package ru.stack.tool.serviceclient.model;

import lombok.Data;

import java.util.List;

/**
 * Model for foreign service
 */
@Data
public class StackResponse {
    private List<Item> items;
}
