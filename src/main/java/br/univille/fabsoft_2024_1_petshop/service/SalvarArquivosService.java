package br.univille.fabsoft_2024_1_petshop.service;

import org.springframework.web.multipart.MultipartFile;

public interface SalvarArquivosService {
    String save(MultipartFile file);
}
