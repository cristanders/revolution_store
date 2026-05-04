package com.cristianperez.revolutionstore.controller;

import com.cristianperez.revolutionstore.entity.Sales;
import com.cristianperez.revolutionstore.service.SalesService;
import com.cristianperez.revolutionstore.service.CustomerService;
import com.cristianperez.revolutionstore.service.UserService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/sales")
public class SalesController {

    private final SalesService salesService;
    private final CustomerService customerService;
    private final UserService userService;

    public SalesController(SalesService salesService, CustomerService customerService, UserService userService) {
        this.salesService = salesService;
        this.customerService = customerService;
        this.userService = userService;
    }

    @GetMapping
    public String list(Model model) {
        model.addAttribute("sales", salesService.list());
        return "sales";
    }

    @GetMapping("/new")
    public String showForm(Model model) {
      
        model.addAttribute("product", new Sales());
        model.addAttribute("customers", customerService.list());
        model.addAttribute("users", userService.list());
        model.addAttribute("modoEdicion", false);
        return "sales-form";
    }

    @GetMapping("/edit/{id}")
    public String showFormEdit(@PathVariable("id") Integer id, Model model) {
        Sales sales = salesService.getByCode(id);

        model.addAttribute("customers", customerService.list());
        model.addAttribute("users", userService.list());
        model.addAttribute("product", sales);
        model.addAttribute("modoEdicion", true);

        return "sales-form";
    }

    @PostMapping("/save")
    public String save(@Valid @ModelAttribute("product") Sales sales, BindingResult result, Model model) {
        if (result.hasErrors()) {

            model.addAttribute("customers", customerService.list());
            model.addAttribute("users", userService.list());
            model.addAttribute("modoEdicion", sales.getCodeSales() != null);
            return "sales-form";
        }

        salesService.save(sales);
        return "redirect:/sales";
    }

    @GetMapping("/delete/{id}")
    public String deleteSales(@PathVariable("id") Integer id) {
        salesService.eliminate(id);
        return "redirect:/sales";
    }
}