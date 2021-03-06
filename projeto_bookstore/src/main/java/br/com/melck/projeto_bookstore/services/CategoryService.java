package br.com.melck.projeto_bookstore.services;

import br.com.melck.projeto_bookstore.entities.Category;
import br.com.melck.projeto_bookstore.repositories.CategoryRepository;
import br.com.melck.projeto_bookstore.resources.dtos.CategoryDTO;
import br.com.melck.projeto_bookstore.services.exceptions.DataIntegrityViolationException;
import br.com.melck.projeto_bookstore.services.exceptions.ObjectNotFoundException;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class CategoryService {
    
    @Autowired
    private CategoryRepository categoryRepository;

    public Category findById(Long id){
        Optional<Category> obj = categoryRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto id:" + id + " não foi encontrado"));
    }

    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    public Category create(Category obj){
        obj.setId(null);
        return categoryRepository.save(obj);
    }

    public Category update(Long id, CategoryDTO objDTO) {
        Category obj = findById(id);
        obj.setCategory(objDTO.getCategory());
        return categoryRepository.save(obj);
    }
    
    public void delete(Long id) {
        findById(id);
        try { 
            categoryRepository.deleteById(id);  
        } catch (org.springframework.dao.DataIntegrityViolationException e) {
            throw new DataIntegrityViolationException
            ("Esta categoria possui objetos associados e não pode ser deletada ");
        }
    }
}
