package pl.xsolve.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.xsolve.model.UserAccountDTO;
import pl.xsolve.serivces.UserAccountService;

import java.util.List;

@RestController
public class UserAccountController {

    protected final UserAccountService userAccountService;

    @Autowired
    public UserAccountController(UserAccountService userAccountService) {
        this.userAccountService = userAccountService;
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public UserAccountDTO create(@RequestBody UserAccountDTO accountDTO) {

        return userAccountService.create(accountDTO);
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<UserAccountDTO> getAll() {

        return userAccountService.getAll();
    }

    @RequestMapping(value = "/{accountId}/email", method = RequestMethod.GET)
    public UserAccountDTO getEmail(@PathVariable Long accountId) {
        String email = userAccountService.getEmail(accountId);
        UserAccountDTO userAccountDTO = new UserAccountDTO();
        userAccountDTO.setEmail(email);

        return userAccountDTO;
    }

}
