package br.com.medeirosgabriel.config;

import br.com.medeirosgabriel.entity.*;
import br.com.medeirosgabriel.respository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class PopDB implements CommandLineRunner {

    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private OrderItemRepository orderItemRepository;
    @Autowired
    private RoleRepository roleRepository;

    @Override
    public void run(String... args) throws Exception {

        Role role1 = new Role("ROLE_ADMIN");
        Role role2 = new Role("ROLE_USER");

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        this.roleRepository.save(role1);
        this.roleRepository.save(role2);

        User user1 = new User("gabriel", "123-456-789", "gabriel@mail.com", "123456", null, role1);
        User user2 = new User("daniel", "123-456-789", "daniel@mail.com", "123456", null, role2);
        user1.setPassword(encoder.encode(user1.getPassword()));
        user2.setPassword(encoder.encode(user2.getPassword()));

        Product product = new Product("", "", 4.0);
        OrderItem orderItem = new OrderItem(product, 2);
        Order order = new Order(user1);
        order.addOrderItem(orderItem);

        this.userRepository.save(user1);
        this.userRepository.save(user2);
        this.productRepository.save(product);
        this.orderRepository.save(order);
    }
}
