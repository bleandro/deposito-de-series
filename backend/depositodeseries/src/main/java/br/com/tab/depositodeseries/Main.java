package br.com.tab.depositodeseries;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.tab.depositodeseries.domain.LoginAuthentication;
import br.com.tab.depositodeseries.domain.User;
import br.com.tab.depositodeseries.repository.LoginAuthenticationRepository;
import br.com.tab.depositodeseries.repository.UserRepository;

@SpringBootApplication
public class Main implements CommandLineRunner
{
	@Autowired
	private UserRepository usuarioRepository;

	@Autowired
	LoginAuthenticationRepository acessoRepository;

	public static void main(String[] args)
	{
		SpringApplication.run(Main.class, args);
	}

	public void run(String... args) throws Exception
	{
		LoginAuthentication a1 = new LoginAuthentication("user1", "senha123");
		LoginAuthentication a2 = new LoginAuthentication("user2", "senha123");

		User u1 = new User(null, "João da Silva", "joão.silva@gmail.com", a1);
		User u2 = new User(null, "Maria Joana", "maria.joana@gmail.com", a2);

		acessoRepository.saveAll(Arrays.asList(a1, a2));
		usuarioRepository.saveAll(Arrays.asList(u1, u2));
	}
}
