package ru.stack.tool.service;

import ru.stack.tool.service.model.Question;

import java.util.List;

/**
 * Interface for bussiness service
 */
public interface IStackService {

    List<Question> getQuestions(String inititle);

}
