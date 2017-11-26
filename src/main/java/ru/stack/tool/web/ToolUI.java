package ru.stack.tool.web;

import com.vaadin.annotations.Theme;
import com.vaadin.server.FontAwesome;
import com.vaadin.server.VaadinRequest;
import com.vaadin.shared.ui.ValueChangeMode;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.*;
import com.vaadin.ui.renderers.LocalDateTimeRenderer;
import com.vaadin.ui.themes.ValoTheme;
import org.springframework.beans.factory.annotation.Autowired;
import ru.stack.tool.service.IStackService;
import ru.stack.tool.service.model.Question;
import ru.stack.tool.web.model.QuestionForm;

import java.time.LocalDateTime;
import java.util.List;

@SpringUI
@Theme("mytheme")
public class ToolUI extends UI {

    private Grid<Question> grid = new Grid<>(Question.class);
    private TextField searchText = new TextField();
    private QuestionForm form = new QuestionForm(this);

    private final IStackService stackService;

    @Autowired
    public ToolUI(IStackService stackService) {
        this.stackService = stackService;
    }

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        final VerticalLayout layout = new VerticalLayout();

        searchText.setPlaceholder("Search from Stack Exchange...");
        searchText.addValueChangeListener(e -> updateList());
        searchText.setValueChangeMode(ValueChangeMode.LAZY);

        Button clearFilterTextBtn = new Button(FontAwesome.TIMES);
        clearFilterTextBtn.setDescription("Clear the current filter");
        clearFilterTextBtn.addClickListener(e -> searchText.clear());

        CssLayout filtering = new CssLayout();
        filtering.addComponents(searchText, clearFilterTextBtn);
        filtering.setStyleName(ValoTheme.LAYOUT_COMPONENT_GROUP);

        Button searchBtn = new Button("Search");
        searchBtn.setIcon(FontAwesome.SEARCH);
        searchBtn.addClickListener(e -> {
            grid.asSingleSelect().clear();
            updateList();
        });

        HorizontalLayout toolbar = new HorizontalLayout(filtering, searchBtn);

        grid.setColumns("owner", "title");

        Grid.Column<Question, LocalDateTime> bornColumn =
                grid.addColumn(
                        Question::getCreationDate,
                        new LocalDateTimeRenderer("yyyy MM dd 'at' HH:mm"));

        grid.setStyleGenerator(t -> {
            if (t.getAnswered()) {
                return "answered_row";
            } else {
                return null;
            }
        });

        HorizontalLayout main = new HorizontalLayout(grid, form);
        main.setSizeFull();
        grid.setSizeFull();
        main.setExpandRatio(grid, 1);

        layout.addComponents(toolbar, main);
        updateList();
        setContent(layout);

        form.setVisible(false);

        grid.asSingleSelect().addValueChangeListener(event -> {
            if (event.getValue() == null) {
                form.setVisible(false);
            } else {
                form.setVisible(true);
                form.setQuestion(event.getValue());
            }
        });
    }

    private void initGrid() {
    }

    private void updateList() {
        List<Question> answers = stackService.getQuestions(searchText.getValue());
        grid.setItems(answers);
    }

}

