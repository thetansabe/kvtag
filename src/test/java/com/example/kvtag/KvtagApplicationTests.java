package com.example.kvtag;

import ai.qworks.dao.nontransaction.CatalogTree;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class KvtagApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	void getCatalogDataByFilter(){
		CatalogTree root = com.example.kvtag.services.CatalogTreeService.mockCatalogTree();
		String filter = "Product.model == 'furniture' && Product.productFamily == 'xyz'";
		String objectType = "Product";

		List<CatalogTree> result = com.example.kvtag.services.CatalogTreeService.getCatalogDataByFilter(filter, objectType, root);

		System.out.println("Result:");
		for(CatalogTree ct : result){
			System.out.println(ct);
		}
	}

}
