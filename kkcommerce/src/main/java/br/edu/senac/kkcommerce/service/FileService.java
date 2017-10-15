package br.edu.senac.kkcommerce.service;

import br.edu.senac.kkcommerce.model.ImagemProduto;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author while true
 */
public class FileService {

    private static final String PASTA_IMAGEM = new File("src\\main\\resources\\static\\imagens\\produtos").getAbsolutePath() + "\\";

    public static ArrayList<ImagemProduto> gravarArquivos(MultipartFile[] files) throws IOException {
        ArrayList<ImagemProduto> arquivos = new ArrayList<>();
        if (files != null) {
            for (MultipartFile file : files) {
                if (!file.isEmpty()) {
                    try {
                        arquivos.add(new ImagemProduto(0, 0, file.getOriginalFilename(), "Imagem Produto"));

                        Path path = Paths.get(PASTA_IMAGEM + file.getOriginalFilename());
                        byte[] bytes = file.getBytes();
                        Files.write(path, bytes);
                    } catch (IOException ex) {
                        ex.printStackTrace();
                        throw new IOException("Erro ao gravar arquivo");
                    }
                }
            }
        }
        return arquivos;
    }
}
