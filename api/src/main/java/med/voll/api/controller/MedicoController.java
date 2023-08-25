package med.voll.api.controller;

import jakarta.validation.Valid;
//import med.voll.api.medico.DadosAtualizarMedico.AtualizarCadastroMedico;
import med.voll.api.medico.DadosCadastroMedico;
import med.voll.api.medico.DadosListagemMedico;
import med.voll.api.medico.Medico;
import med.voll.api.medico.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("medicos")
public class MedicoController {
  @Autowired
  private MedicoRepository repository;

  @PostMapping
  @Transactional
  public void cadastrar(@RequestBody @Valid DadosCadastroMedico dados){
    //Medico medico = new Medico(dados);
    //System.out.println(medico.getEmail());
    repository.save(new Medico(dados));
  }

  //metodo que retonar lista sem paginação
//  @GetMapping
//  public List<DadosListagemMedico> listar(){
//    //return repository.findAll();
//     return repository.findAll().stream().map(DadosListagemMedico::new).toList();
//  }


  //metodo que retorna lista com paginação
  @GetMapping
  public Page<DadosListagemMedico> listar(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao){
    return repository.findAll(paginacao).map(DadosListagemMedico::new);
  }

  @PutMapping
  @Transactional
  public void atualizar(@RequestBody @Valid DadosCadastroMedico dados){

  }
}
