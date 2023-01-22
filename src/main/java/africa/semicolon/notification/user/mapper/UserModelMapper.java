package africa.semicolon.notification.user.mapper;

import africa.semicolon.notification.user.User;
import africa.semicolon.notification.user.dtos.requests.RegistrationRequest;
import org.springframework.stereotype.Component;

@Component
public class UserModelMapper {

    public User map(User user, RegistrationRequest request){
        user.setEmail(request.getEmail());
        user.setPhoneNumber(request.getPhoneNumber());
        user.setPassword(request.getPassword());
        return user;
    }
}