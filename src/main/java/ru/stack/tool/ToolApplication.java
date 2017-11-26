package ru.stack.tool;

import org.dozer.spring.DozerBeanMapperFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.Resource;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

@SpringBootApplication
@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class})
public class ToolApplication {

    private final ApplicationContext context;

    @Autowired
    public ToolApplication(ApplicationContext context) {
        this.context = context;
    }

    public static void main(String[] args) {
        SpringApplication.run(ToolApplication.class, args);
    }

    @Bean(name = "restService")
    public RestOperations initRest() {
        HttpComponentsClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory();
        Integer THREE_SEC = 3 * 1000;
        Integer ONE_MINUTE = 60 * 1000;
        requestFactory.setConnectTimeout(THREE_SEC);
        requestFactory.setReadTimeout(ONE_MINUTE);
        return new RestTemplate(requestFactory);
    }

    @Bean(name = "mapper")
    public DozerBeanMapperFactoryBean initDozer() throws IOException {
        DozerBeanMapperFactoryBean dozer = new DozerBeanMapperFactoryBean();
        Resource[] configs = context.getResources("classpath*:dozer/map.xml");
        dozer.setMappingFiles(configs);
        return dozer;
    }

}
