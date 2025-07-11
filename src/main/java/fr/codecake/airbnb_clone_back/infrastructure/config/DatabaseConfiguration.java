package fr.codecake.airbnb_clone_back.infrastructure.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableJpaRepositories({"fr.codecake.airbnb_clone_back.user.repository",
        "fr.codecake.airbnb_clone_back.listing.repository",
        "fr.codecake.airbnb_clone_back.booking.repository",
})
@EnableTransactionManagement
@EnableJpaAuditing
public class DatabaseConfiguration {
}
