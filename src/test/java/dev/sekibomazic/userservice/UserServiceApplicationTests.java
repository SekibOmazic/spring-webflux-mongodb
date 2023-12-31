package dev.sekibomazic.userservice;

import dev.sekibomazic.userservice.model.User;
import dev.sekibomazic.userservice.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Flux;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;

@SpringBootTest(classes = UserServiceApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, properties = {"job.autorun.enabled=false"})
class UserServiceApplicationTests {

    @Autowired
    private WebTestClient webTestClient;

    @MockBean
    private UserRepository userRepository;

    @Test
    public void findAllTest() {
        List<User> users = Arrays.asList(
                new User("Sekib", 15),
                new User("Doug", 25),
                new User("Kate", 35)
        );

        Flux<User> flux = Flux.fromIterable(users);
        when(userRepository.findAll())
                .thenReturn(flux);

        webTestClient.get().uri("api/v1/users")
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(User.class)
                .isEqualTo(users);
    }
}
