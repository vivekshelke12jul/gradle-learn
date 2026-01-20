package com.vivek.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class CategoryController {

    @GetMapping("/category")
    public List<Category> getCategories(){
        return Arrays.asList(
                new Category("odd", List.of(1,3,5,7,9)),
                new Category("even", List.of(2,4,6,8)),
                new Category("prime", List.of(2,3,5,7,11))
        );
    }
}
