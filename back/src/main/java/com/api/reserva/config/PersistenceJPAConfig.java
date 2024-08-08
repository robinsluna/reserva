package com.api.reserva.config;

import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@AutoConfiguration
@EnableJpaRepositories
@EnableTransactionManagement
public class PersistenceJPAConfig {

}
