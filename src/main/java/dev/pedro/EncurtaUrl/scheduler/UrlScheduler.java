package dev.pedro.EncurtaUrl.scheduler;

import dev.pedro.EncurtaUrl.service.UrlService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class UrlScheduler {

    private final UrlService urlService;

    public UrlScheduler(UrlService urlService) {
        this.urlService = urlService;
    }

    @Scheduled(fixedRate = 900000)
    public void deletarUrlsExpiradas() {
        urlService.deletarUrlsExpiradas();
    }
}