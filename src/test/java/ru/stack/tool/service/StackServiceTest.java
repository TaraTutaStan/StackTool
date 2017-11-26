package ru.stack.tool.service;

import org.dozer.Mapper;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.util.ReflectionTestUtils;
import ru.stack.tool.converters.impl.QuestionConverter;
import ru.stack.tool.service.impl.StackService;
import ru.stack.tool.service.model.Question;
import ru.stack.tool.serviceclient.impl.StackServiceClient;
import ru.stack.tool.utils.TestUtils;

import java.util.List;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class StackServiceTest {

    @InjectMocks
    @Spy
    private StackService stackService;
    @Mock
    private StackServiceClient stackServiceClient;
    @Mock
    private QuestionConverter converter;
    @Mock
    private Mapper mapper;

    @Before
    public void setup() throws Exception
    {
        ReflectionTestUtils.setField(converter, "mapper", mapper);
    }

    @Test
    public void getQuestion() {
        when(stackServiceClient.getQuestions(TestUtils.getQuery())).thenReturn(TestUtils.getStackQuestion());
        when(converter.process(any())).thenCallRealMethod();
        when(mapper.map(any(), eq(Question.class))).thenReturn(new Question());
        List list = stackService.getQuestions(TestUtils.getQuery());
        Assert.assertNotNull(list);
        Assert.assertEquals(TestUtils.getStackQuestion().getItems().size(), list.size());
    }

    @Test
    public void getEmptyList() {
        when(stackServiceClient.getQuestions(any())).thenReturn(TestUtils.getStackQuestion());
        List list = stackService.getQuestions(null);
        Assert.assertNotNull(list);
        Assert.assertEquals(0, list.size());
    }

}
