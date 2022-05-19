package com.app.tracknmebackend.bo;

import com.app.tracknmebackend.model.FuncionarioModel;
import com.app.tracknmebackend.service.FuncionarioService;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class CepBo {

    @Autowired
    FuncionarioService funcionarioService;

    private static final String URL_VIACEP = "https://viacep.com.br/ws/%s/json/";

    public FuncionarioModel consultar(String cep, FuncionarioModel funcionario) throws IOException {
        String url = String.format(URL_VIACEP, cep);

        Connection.Response response = Jsoup.connect(url)
                .ignoreContentType(true)
                .method(Connection.Method.GET)
                .execute();

        return funcionarioService.setFuncionario(response, funcionario);
    }
}
