package com.threading.Test.Repository;

import com.threading.Test.Domains.Number;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface WebRepository extends JpaRepository<Number, Integer> {
    List<Number> findAllByStatus(int status);
    Number save(Number number);


    @Modifying
    @Query(value = "update Number n set n.status= 1")
    void updateNumber(Number number);
}
