package ru.stack.tool.repository;

import ru.stack.tool.repository.entites.QuestionEntity;

import java.util.List;

/**
 * Repository for cache of questions
 */
public interface ICacheRepository // extends JpaRepository<QuestionEntity, Long>
{
    /**
     * Use in future
     */
    List<QuestionEntity> findAllById(Long id);
}
