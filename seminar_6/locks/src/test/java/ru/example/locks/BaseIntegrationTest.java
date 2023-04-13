package ru.example.locks;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;

@Sql(
    value = "classpath:sql/clean.sql",
    executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD
)
@SpringBootTest
@ContextConfiguration(initializers = {TestcontainersContextInitializer.class})
public class BaseIntegrationTest {

}
