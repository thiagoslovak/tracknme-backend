package com.app.tracknmebackend.controller;

import com.app.tracknmebackend.bo.CepBo;
import com.app.tracknmebackend.model.FuncionarioModel;
import com.app.tracknmebackend.repository.FuncionarioRepository;
import com.app.tracknmebackend.service.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/funcionario")
public class FuncionarioController {

    @Autowired
    private CepBo cepBo;

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    @Autowired
    FuncionarioService funcionarioService;

    @PostMapping(path = "/novo")
    public FuncionarioModel cadastrarFuncionario(@RequestBody FuncionarioModel funcionario) throws Throwable {

        if (funcionarioService.contemApenasCep(funcionario)) {
                return funcionarioRepository.save(cepBo.consultar(funcionario.getCep(), funcionario));
        }

        return funcionarioRepository.save(funcionario);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity consultarFuncionarioId(@PathVariable("id") Long id) {
        return funcionarioRepository.findById(id)
                .map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping()
    public List<FuncionarioModel> consultarTodosFuncionarios() {
        return funcionarioRepository.findByOrderById();
    }

    @GetMapping(path = "/cep/{cep}")
    public List<FuncionarioModel> cunsultarPorCep(@PathVariable("cep") String cep) {
        List<FuncionarioModel> funcionario = funcionarioRepository.findByCep(cep);
        return funcionario;
    }

    @PutMapping(path = "/atualizar")
    public FuncionarioModel atualziarFuncionario(@RequestBody FuncionarioModel funcionario) {
        return funcionarioRepository.save(funcionario);
    }

    @DeleteMapping(path = "/deletar")
    public void excluirFuncionario(@RequestBody FuncionarioModel funcionario) {
        funcionarioRepository.delete(funcionario);
    }
}
