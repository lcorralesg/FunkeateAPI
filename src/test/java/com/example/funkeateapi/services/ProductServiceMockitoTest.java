package com.example.funkeateapi.services;

import com.example.funkeateapi.model.Producto;
import com.example.funkeateapi.repository.ProductoRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import lombok.extern.slf4j.Slf4j;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 *
 * @author Jacko_Tinoco
 */

@Slf4j
@ExtendWith(MockitoExtension.class)
public class ProductServiceMockitoTest {
    private Producto productModel;

    @Mock //Bean
    private ProductoRepository repository;

    @Test
    public void testFindProductByCategoryName() {

        String CATEGORY_NAME = "SuperHeroes";

        List<Producto> productsExpected = repository.findByCategoria_Nombre(CATEGORY_NAME);

        Mockito.when(this.repository.findByCategoria_Nombre(CATEGORY_NAME))
                .thenReturn(productsExpected);

        log.info("PRODUCTSL1 :" + productsExpected.toString());

        List<Producto> products = this.repository.findByCategoria_Nombre(CATEGORY_NAME);

        log.info("PRODUCTSL2 :" + products.toString());

        assertEquals(productsExpected.size(), products.size());

    }
    
}
