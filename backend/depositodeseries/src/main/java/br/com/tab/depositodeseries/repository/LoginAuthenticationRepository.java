package br.com.tab.depositodeseries.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.tab.depositodeseries.domain.LoginAuthentication;

public interface LoginAuthenticationRepository extends JpaRepository<LoginAuthentication, String> {
	LoginAuthentication findByLoginAndPassword(String login, String password);
}
