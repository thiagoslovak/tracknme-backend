package com.app.tracknmebackend.service;

import com.app.tracknmebackend.model.FuncionarioModel;
import org.json.JSONObject;
import org.jsoup.Connection;
import org.springframework.stereotype.Service;

@Service
public class FuncionarioService {

    public boolean contemApenasCep(FuncionarioModel funcionario) {

        if ((!funcionario.getCep().isBlank()) && funcionario.getEndereco().isBlank()
                    && funcionario.getBairro().isBlank() && funcionario.getCidade().isBlank()
                    && funcionario.getEstado().isBlank()) {

            return true;
        }

       return false;
    }

    public FuncionarioModel setFuncionario(Connection.Response response, FuncionarioModel funcionario) {
        JSONObject object = new JSONObject(response.body());
        funcionario.setBairro(object.getString("bairro"));
        funcionario.setCep(object.getString("cep"));
        funcionario.setEndereco(object.getString("logradouro"));
        funcionario.setCidade(object.getString("localidade"));
        funcionario.setEstado(object.getString("uf"));

        return funcionario;
    }
}
