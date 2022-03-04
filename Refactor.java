import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

enum Customer {
    ORACLE
}

class Invoice {

    public Enum<Customer> getCustomer() {
        return Customer.ORACLE;
    }

    public Integer getId() {
        return 1;
    }

    public Double getAmount(){
        return 1.2;
    }

    public String getTitle() {
        return "Training";
    }

}

public class HomeWork2 {
    public void refactor() {
        List<Invoice> invoices = new ArrayList<>();
        invoices.add(new Invoice());
        List<Invoice> oracleAndTrainingInvoices = new ArrayList<>();
        List<Integer> ids = new ArrayList<>();
        List<Integer> firstFiveIds = new ArrayList<>();

        oracleAndTrainingInvoices = invoices.stream()
                .filter(data -> data.getCustomer() == Customer.ORACLE)
                .filter(data -> data.getTitle().contains("Training"))
                .collect(Collectors.toList());

        oracleAndTrainingInvoices = oracleAndTrainingInvoices.stream()
                .sorted(Comparator.comparingDouble(Invoice::getAmount))
                .collect(Collectors.toList());

        ids = oracleAndTrainingInvoices.stream()
                .map(Invoice::getId)
                .collect(Collectors.toList());

        firstFiveIds = ids.stream()
                .limit(5)
                .collect(Collectors.toList());
    }


}