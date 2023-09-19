package net.schreck.project.controll;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import net.schreck.project.model.Produto;
import net.schreck.project.model.RespostaModelo;
import net.schreck.project.service.ProdutoService;

@RestController
@CrossOrigin(origins = "*" )
public class ProdutoControll {

    @Autowired
    private ProdutoService ps;

    @PutMapping("/alterar")
    public ResponseEntity<?> alterar(@RequestBody Produto produto){
        return ps.cadastrarAlterar(produto, "alterar");
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<?> cadastrar(@RequestBody Produto produto){
        return ps.cadastrarAlterar(produto, "cadastrar");
    }

    @DeleteMapping("/remover/{id}")
    public ResponseEntity<RespostaModelo> remover(@PathVariable long id){
        return ps.remover(id);

    }

    @GetMapping("/listar")
    public Iterable<Produto> listar(){
        return ps.listar();
    }

    @GetMapping("/alo")
    public String rota(){
        return "ALÔ BRASIL";
    }
    
}
