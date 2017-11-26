package ru.stack.tool.utils;

import ru.stack.tool.service.model.Question;
import ru.stack.tool.serviceclient.model.Item;
import ru.stack.tool.serviceclient.model.Owner;
import ru.stack.tool.serviceclient.model.StackResponse;

import java.util.ArrayList;
import java.util.List;

public class TestUtils {

    private final static String QUERY = "lombok";

    public static String getQuery() {
        return QUERY;
    }

    public static StackResponse getStackQuestion() {
        StackResponse response = new StackResponse();
        response.setItems(getItems());
        return response;
    }

    private static List<Item> getItems() {
        List<Item> list = new ArrayList<>();
        list.add(Item.builder()
                .answerCount(1)
                .answered(true)
                .link("link")
                .title("title")
                .owner(getOwner("Joe"))
                .build());
        list.add(Item.builder()
                .answerCount(2)
                .answered(false)
                .link("link2")
                .title("title2")
                .owner(getOwner("Nick"))
                .build());
        return list;
    }

    private static Owner getOwner(String displayName) {
        return Owner.builder()
                .display_name(displayName)
                .build();
    }

    public static List<Question> getQuestions() {
        List<Question> list = new ArrayList<>();
        list.add(Question.builder()
                .answerCount(1)
                .answered(true)
                .link("link")
                .title("title")
                .owner("Joe")
                .build());
        list.add(Question.builder()
                .answerCount(2)
                .answered(false)
                .link("link2")
                .title("title2")
                .owner("Nick")
                .build());
        return list;
    }
}
