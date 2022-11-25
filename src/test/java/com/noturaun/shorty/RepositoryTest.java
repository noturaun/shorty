package com.noturaun.shorty;

import com.noturaun.shorty.config.DataBaseDecryptor;
import com.noturaun.shorty.model.Url;
import com.noturaun.shorty.repository.UrlRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.context.annotation.Import;

import java.util.Date;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace.NONE;

//@ExtendWith(SpringExtension.class)
@DataJpaTest
@Import(DataBaseDecryptor.class)
@AutoConfigureTestDatabase(replace = NONE)
public class RepositoryTest {

    @Autowired
    UrlRepository urlRepository;

    @Autowired
    TestEntityManager entityManager;

    @Test
    void shouldSaveLongUrlAndReturnsEncodedUrl() {

        String shortened = "new-number";
        String origin = "https://api.whatsapp.com/send?phone=6285890381299";
        Url url = new Url();
                url.setId(100L);
                url.setCreatedAt(new Date());
                url.setExpiresAt(new Date());
                url.setOrigin(origin);
                url.setShortened(shortened);
        entityManager.persist(url);

        Optional<Url> result = urlRepository.getUrlByShortened(shortened);
//        System.out.println(result.get().getOrigin());
        String originUrl = result.isPresent() ? result.get().getOrigin() : "";
        assertThat(originUrl).isNotNull();
        assertThat(originUrl).isNotBlank();

    }

    @Test
    void shouldGetUrlById() {
        Optional<Url> url = urlRepository.findById(1L);

        assertThat(url.get().getOrigin()).isNotNull();
        assertThat(url.get().getId()).isEqualTo(1);
    }
}
