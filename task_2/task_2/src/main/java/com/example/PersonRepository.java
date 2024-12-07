package com.example;

import jakarta.persistence.*;

public class PersonRepository {
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("personPU");
    private EntityManager em = emf.createEntityManager();

    // Добавление объекта
    public void addPerson(Person person) {
        em.getTransaction().begin();
        em.persist(person);
        em.getTransaction().commit();
    }

    // Обновление объекта
    public void updatePerson(Person person) {
        em.getTransaction().begin();
        em.merge(person);
        em.getTransaction().commit();
    }

    // Удаление объекта
    public void deletePerson(Long id) {
        em.getTransaction().begin();
        Person person = em.find(Person.class, id);
        if (person != null) {
            em.remove(person);
        }
        em.getTransaction().commit();
    }

    // Закрытие ресурсов
    public void close() {
        em.close();
        emf.close();
    }
}
