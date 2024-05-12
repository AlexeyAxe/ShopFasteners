package org.axenov.shop.db;

import com.zaxxer.hikari.HikariConfig;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockedConstruction;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.Test;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mockConstruction;
import static org.mockito.Mockito.times;

@ExtendWith(MockitoExtension.class)
public class DBConfigurationTest {

        @Mock
    HikariConfig hikariConfig;

        @Test
        public void getHikariConfigTest() {

            try (MockedConstruction<HikariConfig> ignored =
                mockConstruction(HikariConfig.class, (mock, context) -> hikariConfig = mock)) {
                DBConfiguration.getHikariConfig();
                Mockito.verify(hikariConfig, times(1)).setDataSourceClassName(anyString());
            }
        }
    }
