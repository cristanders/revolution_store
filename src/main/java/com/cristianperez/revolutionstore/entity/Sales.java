    package com.cristianperez.revolutionstore.entity;

    import com.cristianperez.revolutionstore.enums.StatusSalesEnum;
    import com.cristianperez.revolutionstore.enums.UserRoleEnum;
    import jakarta.persistence.*;
    import jakarta.validation.constraints.*;
    import java.time.LocalDate;

    @Entity
    @Table(name = "sales")
    public class Sales {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "code_sales")
        private Integer codeSales;

        @NotNull(message = "The sale date cannot be null")
        @Column(name = "sale_date", nullable = false)
        private LocalDate saleDate;

        @NotNull(message = "The total cannot be empty")
        @DecimalMin(value = "0.0", message = "The total cannot be negative.")
        @DecimalMax(value = "670000.0", message = "The total exceeds the permitted limit.")
        @Column(name = "total")
        private Float totalSales;

        @NotNull(message = "The status of the sales cannot be null")
        @Enumerated(EnumType.STRING)
        @Column(name = "status_sales")
        private StatusSalesEnum statusSales;

        @ManyToOne(fetch = FetchType.EAGER)
        @JoinColumn(name = "dpi_customer", referencedColumnName = "dpi_customer", nullable = false)
        @NotNull(message = "Customer is required")
        private Customer customer;

        @ManyToOne(fetch = FetchType.EAGER)
        @JoinColumn(name = "code_user", referencedColumnName = "code_user", nullable = false)
        @NotNull(message = "User is required")
        private User user;

        public Integer getCodeSales() {
            return codeSales;
        }

        public void setCodeSales(Integer codeSales) {
            this.codeSales = codeSales;
        }

        public LocalDate getSaleDate() {
            return saleDate;
        }

        public void setSaleDate(LocalDate saleDate) {
            this.saleDate = saleDate;
        }

        public StatusSalesEnum getStatusSales() {
            return statusSales;
        }

        public void setStatusSales(StatusSalesEnum statusSales) {
            this.statusSales = statusSales;
        }

        public Float getTotalSales() {
            return totalSales;
        }

        public void setTotalSales(Float totalSales) {
            this.totalSales = totalSales;
        }

        public Customer getCustomer() {
            return customer;
        }

        public void setCustomer(Customer customer) {
            this.customer = customer;
        }

        public User getUser() {
            return user;
        }

        public void setUser(User user) {
            this.user = user;
        }
    }
