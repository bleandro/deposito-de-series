package br.com.tab.depositodeseries.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.tab.depositodeseries.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}
