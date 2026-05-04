package com.cristianperez.revolutionstore.controller;


import com.cristianperez.revolutionstore.entity.Product;
import com.cristianperez.revolutionstore.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Controller
@Validated
@RequestMapping("/products")
public class ProductController {
        private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }


    // list records
        @GetMapping
        public String list(Model model) {
            model.addAttribute("products", productService.list());
            return "products";
        }

        // open a view
        @GetMapping("/new")
        public String showForm(Model model) {
            model.addAttribute("product", new Product());
            model.addAttribute("modeEdicion", false);
            return "product-form";
        }

        // create a new product
        @PostMapping("/save")
        public String save(@Valid @ModelAttribute("product") Product product, BindingResult result, Model model) {

            if (result.hasErrors()) {
                model.addAttribute("modeEdicion", product.getCodeProduct() != null);
                return product.getCodeProduct() != null ? "product-edition" : "product-form";
            }
            productService.save(product);
            return "redirect:/products";
        }

        // delete a product
        @GetMapping("/delete/{id}")
        public String deleteCustomer(@PathVariable("id") Integer id) {
            productService.eliminate(id);
            System.out.println( id + " removed ");
            return "redirect:/products";
        }

        // edit a product
        @GetMapping("/edit/{id}")
        public String showFormEdit(@PathVariable("id") Integer id, Model model) {
            Product product = productService.getByCode(id);

            model.addAttribute("product", product);
            model.addAttribute("modoEdicion", true);

            return "product-edition";
        }
    }


