package pl.bykowski.kolo5;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;


@Route("computer")
public class ComputerGui extends VerticalLayout {

    @Autowired
    private ComputerRepo computerRepo;

    private TextField textFieldDdrType = new TextField("DDR Type");
    private TextField textFieldMhz = new TextField("Mhz");
    private TextField textFieldMemorySize = new TextField("Memory size");
    private Button button = new Button("Add");

    public ComputerGui() {
        add(textFieldDdrType);
        add(textFieldMhz);
        add(textFieldMemorySize);
        add(button);

        button.addClickListener(clickEvent-> {
            Computer computer = new Computer();
            computer.setDdrType(textFieldDdrType.getValue());
            computer.setMhz(Long.parseLong(textFieldMhz.getValue()));
            computer.setMemorySize(Integer.parseInt(textFieldMemorySize.getValue()));
            computerRepo.save(computer);
        });
    }
}
