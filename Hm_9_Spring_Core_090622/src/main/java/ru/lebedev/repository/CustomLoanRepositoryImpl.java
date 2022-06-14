package ru.lebedev.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.lebedev.core.Client;
import ru.lebedev.core.Loan;
import ru.lebedev.core.Repayment;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.List;


public class CustomLoanRepositoryImpl implements CustomLoanRepository {

    @PersistenceUnit
    private EntityManagerFactory emf;


    @Override
    public void pay(Integer loanId, BigDecimal amount) {

        EntityManager entityManager = emf.createEntityManager();
        try {
            entityManager.getTransaction().begin();

            TypedQuery<Loan> tl = entityManager
                    .createQuery("select l from Loan l join fetch l.client where l.id = :id", Loan.class)
                    .setParameter("id", loanId);
            Loan l = tl.getSingleResult();

            Client c = entityManager.find(Client.class, l.getClient().getId());
            c.setCash(c.getCash().subtract(amount));
            entityManager.merge(c);

            Repayment r = new Repayment();
            r.setAmount(amount);
            r.setRepaymentDate(LocalDate.now());
            r.setLoan(l);

            entityManager.persist(r);
            entityManager.getTransaction().commit();

        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            e.printStackTrace();
        }
    }
}
