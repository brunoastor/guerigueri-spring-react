package net.schreck.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import net.schreck.project.model.Produto;
import net.schreck.project.model.RespostaModelo;
import net.schreck.project.repository.ProdutoRepository;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository pr;

    @Autowired
    private RespostaModelo rm;

    public Iterable<Produto> listar(){
        return pr.findAll();
    }

    //Metodo para cadastrar ou alterar produto
    public ResponseEntity<?> cadastrarAlterar(Produto produto, String acao){
        if(produto.getDescricao().equals("")){
            rm.setMensagem("O nome do produto é obrigatorio");
            return new ResponseEntity<RespostaModelo>(rm, HttpStatus.BAD_REQUEST);
        }else if(produto.getMarca().equals("")){
            rm.setMensagem("O nome da marca é obrigatorio");
            return new ResponseEntity<RespostaModelo>(rm, HttpStatus.BAD_REQUEST);
        }else{
            if(acao.equals("cadastrar")){
                return new ResponseEntity<Produto>(pr.save(produto), HttpStatus.CREATED);
            }else{
                return new ResponseEntity<Produto>(pr.save(produto), HttpStatus.OK);                
            }
        }
    }

    //Metodo para remover produto
    public ResponseEntity<RespostaModelo> remover(long id){
        pr.deleteById(id);
        rm.setMensagem("O produto foi removido com Sucesso");
        return new ResponseEntity<RespostaModelo>(rm, HttpStatus.OK);
    }
}
