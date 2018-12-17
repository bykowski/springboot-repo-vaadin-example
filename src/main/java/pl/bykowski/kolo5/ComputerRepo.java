package pl.bykowski.kolo5;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ComputerRepo extends CrudRepository<Computer, Long> {

    @Query(value = "SELECT * FROM COMPUTER c WHERE c.MEMORY_SIZE > :memorySize", nativeQuery = true)
    List<Computer> findComputerWhereMemorySizeMoreThan(@Param("memorySize") int memorySize);
}
