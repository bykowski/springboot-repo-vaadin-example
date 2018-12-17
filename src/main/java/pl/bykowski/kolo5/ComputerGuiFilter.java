package pl.bykowski.kolo5;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Route
public class ComputerGuiFilter extends VerticalLayout {

    @Autowired
    private ComputerRepo computerRepo;

    private TextField textMinimumSize = new TextField("Min size");
    private Button button = new Button("Show");
    private TextArea textArea = new TextArea();

    public ComputerGuiFilter() {
        add(textMinimumSize);
        add(button);
        add(textArea);
        button.addClickListener(clickEvent -> {
            Computer computer = new Computer();
            List<Computer> computerWhereMemorySizeMoreThan = computerRepo.findComputerWhereMemorySizeMoreThan(Integer.parseInt(textMinimumSize.getValue()));
            textArea.setValue(computerWhereMemorySizeMoreThan.toString());
        });
    }
}
