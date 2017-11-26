package ru.stack.tool.serviceclient;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ru.stack.tool.serviceclient.impl.StackServiceClient;
import ru.stack.tool.serviceclient.model.StackResponse;
import ru.stack.tool.utils.TestUtils;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class StackServiceClientIntegrationTest {

    @Autowired
    private StackServiceClient stackServiceClient;

    @Test
    public void getQuestion() {
        StackResponse response = stackServiceClient.getQuestions(TestUtils.getQuery());
        Assert.assertNotNull(response.getItems());
        Assert.assertTrue(response.getItems().size() > 0);
    }
}
