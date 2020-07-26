package app.ledger.demo.model;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IncomeRepository extends JpaRepository<Income, String> {
}
