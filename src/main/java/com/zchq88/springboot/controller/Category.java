package com.zchq88.springboot.controller;

import com.zchq88.springboot.DataObject.ProductCategory;
import com.zchq88.springboot.Service.Impl.CategoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/Category")
public class Category {
    private final CategoryServiceImpl categoryService;

    @Autowired
    public Category(CategoryServiceImpl categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/list")
    public List<ProductCategory> list() {
        return categoryService.findAll();
    }

    @GetMapping("/list/page")
    public List<ProductCategory> list(@RequestParam(value = "page", defaultValue = "0") Integer page,
                                      @RequestParam(value = "size", defaultValue = "10") Integer size) {
        PageRequest pageRequest = PageRequest.of(page, size);
        return categoryService.findAll(pageRequest).getContent();
    }
}
