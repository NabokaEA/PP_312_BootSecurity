package ru.nabokae.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.nabokae.DAO.UserRepository;
import ru.nabokae.entity.User;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    UserRepository repo;
    @Autowired
    public void setRepo(UserRepository repo){
        this.repo=repo;
    }

    @Transactional
    @Override
    public void save(User user) {
        repo.save(user);
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<User> findById(Long id) {
        return repo.findById(id);
    }

    @Transactional(readOnly = true)
    @Override
    public Iterable<User> findAll() {
        return repo.findAll();
    }
    @Transactional
    @Override
    public void delete(Long id) {
        repo.deleteById(id);
    }

    @Override
    public Optional<User> findByName(String name) {
        return repo.findByName(name);
    }
}
