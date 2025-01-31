package dev.pedro.EncurtaUrl.service;

import dev.pedro.EncurtaUrl.model.Url;
import dev.pedro.EncurtaUrl.repository.UrlRepository;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;

@Service
public class UrlService {

    private final UrlRepository urlRepository;


    public UrlService(UrlRepository urlRepository) {
        this.urlRepository = urlRepository;
    }

    public String encurtarUrl(String urlOriginal) {
        String urlEncurtada;
        do {
            urlEncurtada = RandomStringUtils.randomAlphanumeric(5, 10);
        } while (urlRepository.existsByUrlEncurtada(urlEncurtada));

        Url url = new Url();
        url.setUrlOriginal(urlOriginal);
        url.setUrlEncurtada(urlEncurtada);
        urlRepository.save(url);
        return urlEncurtada;
    }

    public String obterUrlOriginal(String urlEncurtada) {
        Url url = urlRepository.findByUrlEncurtada(urlEncurtada);
        return (url != null) ? url.getUrlOriginal() : null;
    }

    public void deletarUrlsExpiradas() {
        urlRepository.deleteAll(urlRepository.findByDataCriacaoBefore(LocalDateTime.now().minusMinutes(15)));
    }
}