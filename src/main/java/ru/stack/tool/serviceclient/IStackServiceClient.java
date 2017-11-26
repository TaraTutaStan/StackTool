package ru.stack.tool.serviceclient;

import ru.stack.tool.serviceclient.model.StackResponse;

/**
 * Interface for foreign service
 */
public interface IStackServiceClient {

    StackResponse getQuestions(String intitle);

}
