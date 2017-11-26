package ru.stack.tool.serviceclient.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestOperations;
import ru.stack.tool.serviceclient.IStackServiceClient;
import ru.stack.tool.serviceclient.model.StackResponse;

/**
 * Service for access to foreign service
 */
@Component
public class StackServiceClient implements IStackServiceClient {

    private final RestOperations rest;

    private String url;

    private final static StackResponse emptyResponse = new StackResponse();

    @Autowired
    public StackServiceClient(@Qualifier("restService") RestOperations rest,
                              @Value("${url}") String url) {
        this.rest = rest;
        this.url=url;
    }

    @Override
    public StackResponse getQuestions(String intitle) {
        ResponseEntity<StackResponse> responseEntity = rest.getForEntity(url + intitle, StackResponse.class);
        if (responseEntity.getStatusCode() == HttpStatus.OK) {
            return responseEntity.getBody();
        }
        return emptyResponse;
    }

}
