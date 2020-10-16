package info.quiquedev.userservice

import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.DynamicPropertyRegistry
import org.springframework.test.context.DynamicPropertySource
import org.testcontainers.containers.PostgreSQLContainer
import org.testcontainers.junit.jupiter.Container
import org.testcontainers.junit.jupiter.Testcontainers


@Testcontainers
@SpringBootTest
class UserserviceApplicationTests {
    companion object {
        const val APP_USER = "app_user"
        const val APP_PASSWORD = "app_user"

        @Container
        val container = PostgreSQLContainer<Nothing>("postgres:13.0").apply {
            withDatabaseName("test_db")
            withUsername("test_user")
            withPassword("test_password")
        }

        @JvmStatic
        @DynamicPropertySource
        fun properties(registry: DynamicPropertyRegistry) {
            registry.add("spring.datasource.url", container::getJdbcUrl)
            registry.add("spring.datasource.password") { APP_USER }
            registry.add("spring.datasource.username") { APP_PASSWORD }
            registry.add("flyway.url", container::getJdbcUrl)
            registry.add("flyway.user", container::getUsername)
            registry.add("flyway.password", container::getPassword)
            registry.add("flyway.placeholders.dbAppUser") { APP_USER }
            registry.add("flyway.placeholders.dbAppPassword") { APP_PASSWORD }
        }
    }

    @Test
    fun contextLoads() {
    }
}

