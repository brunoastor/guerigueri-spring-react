package net.schreck.project.repository;

import org.springframework.data.repository.CrudRepository;

import net.schreck.project.model.Produto;

public interface ProdutoRepository extends CrudRepository<Produto, Long>{
    
}
