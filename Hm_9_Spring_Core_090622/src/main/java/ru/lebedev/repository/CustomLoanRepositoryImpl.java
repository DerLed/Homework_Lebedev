package ru.lebedev.repository;

import ru.lebedev.core.entity.Client;
import ru.lebedev.core.entity.Loan;
import ru.lebedev.core.entity.Repayment;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;


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
