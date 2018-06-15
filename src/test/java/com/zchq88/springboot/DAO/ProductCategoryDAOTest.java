package com.zchq88.springboot.DAO;

import com.zchq88.springboot.DataObject.ProductCategory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCategoryDAOTest {
    @Autowired
    private ProductCategoryDAO dao;

    @Test
    public void findOneTest() {
        ProductCategory ex = new ProductCategory();
        ex.setCategoryId(1);
        Example<ProductCategory> example = Example.of(ex);
        Optional<ProductCategory> opt = dao.findOne(example);
        if (opt.isPresent()) {
            ProductCategory productCategory = opt.get();
            System.out.println(productCategory.toString());
        }
    }

    @Test
    @Transactional
    public void saveTest() {
        ProductCategory productCategory = new ProductCategory("zchq881", 31);
        dao.save(productCategory);
    }

    @Test
    public void findByCategoryTypeIn() {
        List<Integer> list = Arrays.asList(2, 3, 4);
        List<ProductCategory> result = dao.findByCategoryTypeIn(list);
        Assert.assertNotEquals(0, result.size());
    }
}