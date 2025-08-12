package com.sahil.jpaTutorial.jpaTuts.controllers;

import com.sahil.jpaTutorial.jpaTuts.entities.ProductEntity;
import com.sahil.jpaTutorial.jpaTuts.repositories.ProductRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@RestController
@RequestMapping(path = "/products")
public class ProductController {

    private final int PAGE_SIZE = 5;

    private final ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping
    public List<ProductEntity> getAllProducts(@RequestParam(defaultValue = "") String title,
                                                @RequestParam(defaultValue = "id") String sortBy,
                                                @RequestParam(defaultValue = "0")Integer pageNumber){
//        return productRepository.findByOrderByPrice();
//        return productRepository.findBy(Sort.by(Sort.Direction.DESC, sortBy, "title"));
//        return productRepository.findBy(Sort.by(Sort.Order.asc(sortBy),
//                                            Sort.Order.desc("title")));
//
//        Pageable pageable = PageRequest.of(pageNumber,
//                PAGE_SIZE,
//                Sort.by(sortBy).descending());
//
//        return productRepository.findAll(pageable).getContent();

        return productRepository.findByTitleContainingIgnoreCase(
                title,
                PageRequest.of(
                        pageNumber,
                        PAGE_SIZE,
                        Sort.by(sortBy).descending()));
    }
}
