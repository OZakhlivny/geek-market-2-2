package com.geekbrains.geek.market;


import com.geekbrains.geek.market.entities.Category;
import com.geekbrains.geek.market.repositories.CategoryRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

@DataJpaTest
@ActiveProfiles("test")
public class CategoryRepositoryTest {
    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void categoryRepositoryTest() {
        Category category = new Category();
        category.setTitle("Food");
        entityManager.persist(category);
        entityManager.flush();

        List<Category> categoryList = categoryRepository.findAll();

        Assertions.assertEquals(4, categoryList.size());
        Assertions.assertEquals("Notebook", categoryList.get(1).getTitle());
    }

    @Test
    public void initDbTest() {
        List<Category> categoryList = categoryRepository.findAll();
        Assertions.assertEquals(3, categoryList.size());
    }
}
