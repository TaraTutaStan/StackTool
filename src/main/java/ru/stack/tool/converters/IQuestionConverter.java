package ru.stack.tool.converters;

import ru.stack.tool.service.model.Question;
import ru.stack.tool.serviceclient.model.StackResponse;

import java.util.List;

/**
 * Interface for question converter
 */
public interface IQuestionConverter {

    List<Question> process(StackResponse response);

}
