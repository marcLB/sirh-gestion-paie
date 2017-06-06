package dev.paie.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.paie.entite.BulletinSalaire;

public interface BulletinEmployeRepository extends JpaRepository<BulletinSalaire, Integer> {

}
