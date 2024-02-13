package XindusTrade.Assignment.Controllers;

import XindusTrade.Assignment.DTOs.RequestDTOs.UserRequestDTO;
import XindusTrade.Assignment.DTOs.ResponseDTOs.UserResponseDTO;
import XindusTrade.Assignment.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @PostMapping("/add")
    private ResponseEntity<UserResponseDTO> addUser(UserRequestDTO userDTO){
        try {
            UserResponseDTO response=userService.add(userDTO);
            response.setStatusCode("202");
            response.setStatusMessage("SUCCESS!! User added successfully!!");
            return new ResponseEntity<>(response,HttpStatus.ACCEPTED);
        } catch (Exception e){
            UserResponseDTO response=new UserResponseDTO();
            response.setStatusCode("400");
            response.setStatusMessage(e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }
}
