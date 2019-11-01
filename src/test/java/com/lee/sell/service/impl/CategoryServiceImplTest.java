package com.lee.sell.service.impl;

import com.lee.sell.dataobject.ProductCategory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CategoryServiceImplTest {

    @Autowired
    private CategoryServiceImpl categoryService;
    @Test
    public void findOne() {
        ProductCategory one = categoryService.findOne(2);
        System.out.println(one.getCategoryType()+"==="+one.getCategoryName());
    }

    @Test
    public void findAll() {
        List<ProductCategory> all = categoryService.findAll();
        for (ProductCategory productCategory : all) {
            System.out.println(productCategory.getCategoryType()+"==="+productCategory.getCategoryName());
        }
    }

    @Test
    public void findByCategoryTypeIn() {
        List<ProductCategory> byCategoryTypeIn = categoryService.findByCategoryTypeIn(Arrays.asList(2, 3));
        for (ProductCategory productCategory : byCategoryTypeIn) {
            System.out.println(productCategory.getCategoryType()+"==="+productCategory.getCategoryName());
        }
    }

    @Test
    public void save() {
        categoryService.save(new ProductCategory("男生专享",4));
    }
}