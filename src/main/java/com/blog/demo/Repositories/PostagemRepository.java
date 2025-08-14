package com.blog.demo.Repositories;

import com.blog.demo.Entities.Postagem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostagemRepository extends JpaRepository<Postagem, Integer> {
}
