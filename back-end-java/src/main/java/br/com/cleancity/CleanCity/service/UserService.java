package br.com.cleancity.CleanCity.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cleancity.CleanCity.model.User;
import br.com.cleancity.CleanCity.repository.UserRepository;

@Service
public class UserService {

  @Autowired
  private UserRepository alunoRepository;

  public User findByEmail(String email) {
    for(User aluno: alunoRepository.findAll()) {
      if(aluno.getEmail().equals(email)) {
        return aluno;
      }
    }
    return null;
  }

  public String findByLogin(String email, String senha) {
    for(User aluno: alunoRepository.findAll()) {
      if(aluno.getEmail().equals(email)) {
        return conferirSenha(aluno, senha);
      }
    }
    return "Esse e-mail não foi cadastrado";
  }

  public String conferirSenha(User aluno, String senha) {
    if(aluno.getSenha().equals(senha)) {
      return "Login realizado com sucesso!";
    } else {
      return "Senha incorreta!";
    }
  }
}
