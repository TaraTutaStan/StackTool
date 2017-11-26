package ru.stack.tool.web.model;

import com.vaadin.data.Binder;
import com.vaadin.server.ExternalResource;
import com.vaadin.ui.*;
import ru.stack.tool.service.model.Question;
import ru.stack.tool.web.ToolUI;
import ru.stack.tool.web.util.LayoutUtils;

/**
 * Detail form for question
 */
public class QuestionForm extends FormLayout {

    private TextField owner = new TextField("Posted");
    private TextField title = new TextField("Title");
    private CheckBox answered = new CheckBox("Answered");
    private DateTimeField creationDate = new DateTimeField("Create");
    private Link linkField = new Link(LayoutUtils.LINK_CAPTION, new ExternalResource("https://stackoverflow.com/questions"), "_blank", 10, 10, null);

    private Question question;
    private ToolUI toolUI;
    private Binder<Question> binder = new Binder<>(Question.class);

    public QuestionForm(ToolUI toolUI) {
        this.toolUI = toolUI;
        setSizeUndefined();
        addComponents(owner, creationDate, title, answered, linkField);
        binder.bindInstanceFields(this);
    }

    public void setQuestion(Question question) {
        this.question = question;
        linkField.setResource(new ExternalResource(question.getLink()));
        binder.setBean(question);
        owner.selectAll();
    }
}

