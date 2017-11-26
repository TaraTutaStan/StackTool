package ru.stack.tool.converters.impl;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.stack.tool.converters.IQuestionConverter;
import ru.stack.tool.service.model.Question;
import ru.stack.tool.serviceclient.model.StackResponse;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Converter for question
 */
@Component
public class QuestionConverter implements IQuestionConverter {

    private final Mapper mapper;

    @Autowired
    public QuestionConverter(Mapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public List<Question> process(StackResponse answers) {
        List<Question> result = new ArrayList<>();
        Optional.ofNullable(answers.getItems()).ifPresent(
                it -> it.forEach(item -> {
                    result.add(mapper.map(item, Question.class));
                })
        );
        return result;
    }

}
