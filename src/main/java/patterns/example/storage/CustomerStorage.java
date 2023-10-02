package patterns.example.storage;

import com.fasterxml.jackson.databind.ObjectMapper;
import patterns.example.entities.Customer;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class CustomerStorage {
    private final File customerFile = new File("C:\\files_temp\\customerFile.txt");
    ObjectMapper objectMapper = new ObjectMapper();

    public void addNewCustomer(Customer customer) throws IOException {
        try (FileOutputStream fileOut = new FileOutputStream(customerFile, true)) {
            objectMapper.writeValue(fileOut, customer);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
