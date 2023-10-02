package patterns.example.commands;

import patterns.example.entities.Customer;
import patterns.example.storage.CustomerStorage;

import java.io.IOException;

public class AddNewCustomer implements Command {
    Customer customer;
    CustomerStorage customerStorage = new CustomerStorage();

    public AddNewCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public void execute() {
        try {
            customerStorage.addNewCustomer(customer);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
