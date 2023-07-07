package com.app.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.app.entity.Product;

@DataJpaTest
@AutoConfigureTestDatabase(replace=Replace.NONE)
@Rollback(false)
public class ProdRepoTest {
	
	@Autowired
	private ProductRepository prodRepo;
	
	@Test
	void testSaveAllProds() {
		List<Product>prod=List.of(
				new Product("abc",25,50.00,"djxzcnzjdc"),
				new Product("xyz",75,600.00,"oooooooscJcn"),
				new Product("pqr",90,800.00,"jxhciushxzc")
				);
		
		List<Product> prod2=prodRepo.saveAll(prod);
		assertEquals(4,prod2.size());
	}

}
