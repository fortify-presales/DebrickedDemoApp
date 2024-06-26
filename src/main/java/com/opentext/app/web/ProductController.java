/*
        DebrickedDemoApp - an insecure web application.

        Copyright (C) Copyright 2024 OpenText Corp.

        This program is free software: you can redistribute it and/or modify
        it under the terms of the GNU General Public License as published by
        the Free Software Foundation, either version 3 of the License, or
        (at your option) any later version.

        This program is distributed in the hope that it will be useful,
        but WITHOUT ANY WARRANTY; without even the implied warranty of
        MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
        GNU General Public License for more details.

        You should have received a copy of the GNU General Public License
        along with this program.  If not, see <http://www.gnu.org/licenses/>.
*/

package com.opentext.app.web;

import com.opentext.app.entity.Product;
import com.opentext.app.exception.ProductNotFoundException;
import com.opentext.app.repository.ProductRepository;
import com.opentext.app.service.FileSystemService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api")
public class ProductController {
    private static final Logger log = LogManager.getLogger(ProductController.class);

    private final ProductRepository productRepository;

    private final FileSystemService fileSystemService;

    public ProductController(ProductRepository productRepository, FileSystemService fileSystemService) {
        this.productRepository = productRepository;
        this.fileSystemService = fileSystemService;
    }

    @GetMapping({"/products"})
    public List<Product> all() {
        log.debug("ProductController:all");
        return this.productRepository.findAll();
    }

    @GetMapping("/products/{id}")
    public Product one(@PathVariable("id") UUID id) {
        log.debug("ProductController:one");
        List<Product> p = productRepository.findById(id);
        if (!p.isEmpty()) {
            return p.get(0);
        } else {   
            throw new ProductNotFoundException(id);
        }    
    }

}
