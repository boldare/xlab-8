package pl.xsolve.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import pl.xsolve.model.UserAccount;

@RepositoryRestResource(path = "user-accounts")
public interface UserAccountRepository extends JpaRepository<UserAccount, Long> {

}
