package pl.bykowski.kolo5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class ComputerApi {

    @Autowired
    private ComputerRepo computerRepo;

    @PostMapping("/addComputer")
    public void addComputer(@RequestBody Computer computer) {
        computerRepo.save(computer);
    }

    @DeleteMapping("/deleteComputer")
    public void deleteComputer(@RequestParam("id") long id) {
        computerRepo.deleteById(id);
    }

    @GetMapping("/getAll")
    public Iterable<Computer> getAll() {
        return computerRepo.findAll();
    }

    @GetMapping("/findComputerWhereMemorySizeMoreThan")
    public Iterable<Computer> findComputerWhereMemorySizeMoreThan(@RequestParam("memorySize") int memorySize) {
        return computerRepo.findComputerWhereMemorySizeMoreThan(memorySize);
    }
}
