package com.lee.sell.repository;

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
public class ProductCategoryRepositoryTest {

    @Autowired
    private ProductCategoryRepository repository;

    @Test
    public void save(){
        ProductCategory productCategory= new ProductCategory("男生最爱",3);
        repository.save(productCategory);

    }
    @Test
    public void findByCategoryTypeIn(){
        List<ProductCategory> result = repository.findByCategoryTypeIn(Arrays.asList(2, 3, 4));
        for (ProductCategory productCategory : result) {
            System.out.println(productCategory.getCategoryName()+"==="+productCategory.getCategoryType());
        }

    }
}