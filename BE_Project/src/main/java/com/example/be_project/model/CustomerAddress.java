package com.example.be_project.model;

<<<<<<< HEAD
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
=======
import jakarta.persistence.*;
>>>>>>> b35e407cc910bbc170830f6682501c1b401af7a5

@Entity
@Table(name="Customer_Address")
public class CustomerAddress {
    @Id
    @Column(name = "customer_id")
    private int customerId;

    @Column(name = "address_id")
    private int addressId;
<<<<<<< HEAD
}
=======
}
>>>>>>> b35e407cc910bbc170830f6682501c1b401af7a5
