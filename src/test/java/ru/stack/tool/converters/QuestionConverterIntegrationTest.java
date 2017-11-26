package ru.stack.tool.converters;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ru.stack.tool.converters.impl.QuestionConverter;
import ru.stack.tool.service.model.Question;
import ru.stack.tool.utils.TestUtils;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class QuestionConverterIntegrationTest {

    @Autowired
    private QuestionConverter converter;

    @Test
    public void getQuestion() {
        List<Question> list = converter.process(TestUtils.getStackQuestion());
        Assert.assertNotNull(list);
        assertThat(list, is(TestUtils.getQuestions()));
    }
}
