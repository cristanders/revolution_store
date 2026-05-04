package com.cristianperez.revolutionstore.controller;

import com.cristianperez.revolutionstore.entity.Customer;
import com.cristianperez.revolutionstore.service.CustomerService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Controller
@Validated
@RequestMapping("/customers")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    // list records
    @GetMapping
    public String list(Model model) {
        model.addAttribute("customers", customerService.list());
        return "customers";
    }

    // open a view
    @GetMapping("/new")
    public String showForm(Model model) {
        model.addAttribute("customer", new Customer());
        model.addAttribute("modeEdicion", false);
        return "customer-form";
    }

    // create a new customer
    @PostMapping("/save")
    public String save(@Valid @ModelAttribute("customer") Customer customer, BindingResult result, Model model) {

        if (result.hasErrors()) {
            model.addAttribute("modeEdicion", customer.getDpiCustomer() != null);
            return customer.getDpiCustomer() != null ? "customer-edition" : "customer-form";
        }
        customerService.save(customer);
        return "redirect:/customers";
    }

    // delete a customer
    @GetMapping("/delete/{id}")
    public String deleteCustomer(@PathVariable("id") Integer id) {
        customerService.eliminate(id);
        System.out.println( id + " removed ");
        return "redirect:/customers";
    }

    // edit a customer
    @GetMapping("/edit/{id}")
    public String showFormEdit(@PathVariable("id") Integer id, Model model) {
        Customer customer = customerService.getByDpi(id);

        model.addAttribute("customer", customer);
        model.addAttribute("modoEdicion", true);

        return "customer-edition";
    }
}
