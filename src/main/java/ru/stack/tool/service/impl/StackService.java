package ru.stack.tool.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import ru.stack.tool.converters.IQuestionConverter;
import ru.stack.tool.repository.ICacheRepository;
import ru.stack.tool.service.IStackService;
import ru.stack.tool.service.model.Question;
import ru.stack.tool.serviceclient.IStackServiceClient;

import java.util.Collections;
import java.util.List;

/**
 * Bussiness layout service
 */
@Component
public class StackService implements IStackService {

    /**
     * it will be done in future
     */
    private ICacheRepository repository;
    private final IStackServiceClient stackServiceClient;
    private final IQuestionConverter converter;

    @Autowired
    public StackService(IStackServiceClient stackServiceClient, IQuestionConverter converter) {
        this.stackServiceClient = stackServiceClient;
        this.converter = converter;
    }

    @Override
    public List<Question> getQuestions(String inititle) {
        if (StringUtils.isEmpty(inititle)) {
            return Collections.emptyList();
        }
        return converter.process(stackServiceClient.getQuestions(inititle));
    }
}
