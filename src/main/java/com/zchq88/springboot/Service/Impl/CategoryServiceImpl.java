package com.zchq88.springboot.Service.Impl;

import com.zchq88.springboot.DAO.ProductCategoryDAO;
import com.zchq88.springboot.DataObject.ProductCategory;
import com.zchq88.springboot.Service.CategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class CategoryServiceImpl implements CategoryService {

    private final ProductCategoryDAO dao;

    @Autowired
    public CategoryServiceImpl(ProductCategoryDAO dao) {
        this.dao = dao;
    }

    @Override
    public ProductCategory findOne(Integer categoryId) {
        ProductCategory ex = new ProductCategory();
        ex.setCategoryId(categoryId);
        Example<ProductCategory> example = Example.of(ex);
        Optional<ProductCategory> opt = dao.findOne(example);
        if (opt.isPresent()) {
            log.warn("find");
            return opt.get();
        } else {
            log.error("not find");
            return null;
        }
    }

    @Override
    public List<ProductCategory> findAll() {
        return dao.findAll();
    }

    @Override
    public List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList) {
        return dao.findByCategoryTypeIn(categoryTypeList);
    }

    @Override
    public ProductCategory save(ProductCategory productCategory) {
        return dao.save(productCategory);
    }
}
