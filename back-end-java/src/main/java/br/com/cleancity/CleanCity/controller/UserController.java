package br.com.cleancity.CleanCity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.cleancity.CleanCity.model.User;
import br.com.cleancity.CleanCity.repository.UserRepository;
import br.com.cleancity.CleanCity.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
  @Autowired
  private UserRepository userRepository;

  @Autowired
  private UserService userService;

  // CRUD - CREATE , READ , UPDATE , DELETE

  // CREATE
  @PostMapping
  public String cadastrarUsuario(@RequestBody User user) {
    userRepository.save(user);
    return user.getNome() + ", seu cadastro foi um sucesso!";
  }

  // READ
  @GetMapping
  public List<User> mostrarUsuarios() {
    return userRepository.findAll();
  }

  @GetMapping("/{email}")
  public User mostrarPorEmail(@PathVariable String email) {
    return userService.findByEmail(email);
  }
  
  @GetMapping("/{email}/{senha}")
  public String validarLogin(@PathVariable String email, @PathVariable String senha) {
    return userService.findByLogin(email, senha);
  }

  // UPDATE
  @PutMapping
  public String atualizarUsuario(@RequestBody User user) {
    userRepository.save(user);
    return "Os dados do pedagogo foram atualizados!";
  }

  // DELETE
  @DeleteMapping("/{id}")
  public String deletarUsuario(@PathVariable("id") int id) {
    userRepository.deleteById(id);
    return "Aluno descadastrado!";
  }
}