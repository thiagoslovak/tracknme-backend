package com.app.tracknmebackend.funcionario;

import com.app.tracknmebackend.model.FuncionarioModel;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class FuncionarioControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    private ObjectMapper oBjectMapper;

    @Before
    public FuncionarioModel responseFuncionario() {
        FuncionarioModel funcionario = new FuncionarioModel();
        funcionario.setBairro("Bairro Teste");
        funcionario.setCep("22222-222");
        funcionario.setCidade("Maringá");
        funcionario.setEndereco("Rua Teste");
        funcionario.setEstado("Paraná");
        funcionario.setSexo("Masculino");
        funcionario.setIdade(24);
        funcionario.setNome("Thiago Slovak");

        return funcionario;
    }

    @Test
    void funcionarioTestConsultarTodosFuncionarios() throws Exception {
        mockMvc.perform(get("/funcionario"))
                .andExpect(status().isOk());
    }

    @Test
    void funcionarioTestCadastrarFuncionario() throws Exception {
        mockMvc.perform(post("/funcionario/novo")
                .contentType("application/json")
                .content(oBjectMapper.writeValueAsString(this.responseFuncionario())))
                .andExpect(status().isOk());
    }

    @Test
    void funcionarioTestContemApenasCep() throws Exception {
        FuncionarioModel funcionario = new FuncionarioModel();
        funcionario.setBairro("");
        funcionario.setCep("87015440");
        funcionario.setCidade("");
        funcionario.setEndereco("");
        funcionario.setEstado("");
        funcionario.setSexo("Masculino");
        funcionario.setIdade(24);
        funcionario.setNome("Thiago Slovak");

        mockMvc.perform(post("/funcionario/novo")
                        .contentType("application/json")
                        .content(oBjectMapper.writeValueAsString(funcionario)))
                .andExpect(status().isOk());
    }

    @Test
    void funcionarioTestAtualziarFuncionario() throws Exception {
        mockMvc.perform(put("/funcionario/atualizar")
                        .contentType("application/json")
                        .content(oBjectMapper.writeValueAsString(this.responseFuncionario())))
                        .andExpect(status().isOk());
    }

    @Test
    void funcionarioTestExcluirFuncionario() throws Exception {
        mockMvc.perform(delete("/funcionario/deletar")
                        .contentType("application/json")
                        .content(oBjectMapper.writeValueAsString(this.responseFuncionario())))
                        .andExpect(status().isOk());
    }

    @Test
    void funcionarioTestConsultarFuncionarioId() throws Exception {
        mockMvc.perform(get("/funcionario/{id}", "1"))
                .andExpect(status().isOk());
    }

    @Test
    void funcionarioTestCunsultarPorCep() throws Exception {
        mockMvc.perform(get("/funcionario/cep/{cep}", "00000-000"))
                .andExpect(status().isOk());
    }
}
