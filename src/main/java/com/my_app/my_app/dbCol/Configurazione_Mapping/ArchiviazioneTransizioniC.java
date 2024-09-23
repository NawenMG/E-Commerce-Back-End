package com.my_app.my_app.dbCol.Configurazione_Mapping;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.cassandra.config.AbstractCassandraConfiguration;
import org.springframework.data.cassandra.core.CassandraTemplate;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;

import com.datastax.oss.driver.api.core.CqlSession;

@Configuration
@EnableCassandraRepositories(basePackages = "com.my_app.my_app.dbCol.Repository.Classsss")
public class ArchiviazioneTransizioniC extends AbstractCassandraConfiguration {

    @Override
    protected String getKeyspaceName() {
        return "ArchiviazioneTransizioni"; 
    }

    @Bean
    public CqlSession session() {
        return CqlSession.builder()
                .withKeyspace(getKeyspaceName())
                .build();
    }

    @Bean
    public CassandraTemplate cassandraTemplate(CqlSession session) {
        return new CassandraTemplate(session);
    }
}
