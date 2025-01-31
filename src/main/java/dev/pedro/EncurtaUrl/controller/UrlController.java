package dev.pedro.EncurtaUrl.controller;

import dev.pedro.EncurtaUrl.service.UrlService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/url")
public class UrlController {

    private final UrlService urlService;

    public UrlController(UrlService urlService) {
        this.urlService = urlService;
    }

    @PostMapping("/encurtar")
    public ResponseEntity<?> encurtarUrl(@RequestParam String urlOriginal) {
        if (urlOriginal == null || urlOriginal.trim().isEmpty()) {
            return ResponseEntity.badRequest().body("URL original não pode ser vazia");
        }
        return ResponseEntity.ok(urlService.encurtarUrl(urlOriginal));
    }

    @GetMapping("/original")
    public ResponseEntity<?> obterUrlOriginal(@RequestParam String urlEncurtada) {
        if (urlEncurtada == null || urlEncurtada.trim().isEmpty()) {
            return ResponseEntity.badRequest().body("URL encurtada não pode ser vazia");
        }
        String urlOriginal = urlService.obterUrlOriginal(urlEncurtada);
        return (urlOriginal != null)
                ? ResponseEntity.ok(urlOriginal)
                : ResponseEntity.status(HttpStatus.NOT_FOUND).body("URL não encontrada");
    }
}