package br.com.melck.projeto_bookstore.resources;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.melck.projeto_bookstore.entities.Category;
import br.com.melck.projeto_bookstore.resources.dtos.CategoryDTO;
import br.com.melck.projeto_bookstore.services.CategoryService;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/{id}")
    public ResponseEntity<Category> findById(@PathVariable Long id){
        Category obj = categoryService.findById(id);
        return ResponseEntity.ok().body(obj);
      }

    @GetMapping
    public ResponseEntity<List<CategoryDTO>> findAll(){
        List<Category> list = categoryService.findAll();
        List<CategoryDTO> listDTO = list.stream()
        .map(obj -> new CategoryDTO(obj))
        .collect(Collectors.toList());
        return ResponseEntity.ok().body(listDTO);
       
    }
}
