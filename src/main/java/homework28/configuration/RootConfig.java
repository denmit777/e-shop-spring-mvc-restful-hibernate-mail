package homework28.configuration;

import homework28.dao.GoodDAO;
import homework28.dao.ImageDAO;
import homework28.dao.OrderDAO;
import homework28.dao.UserDAO;
import homework28.dao.impl.GoodDAOImpl;
import homework28.dao.impl.ImageDAOImpl;
import homework28.dao.impl.OrderDAOImpl;
import homework28.dao.impl.UserDAOImpl;
import homework28.service.CartService;
import homework28.service.GoodService;
import homework28.service.OrderService;
import homework28.service.UserService;
import homework28.service.attachment.ImageService;
import homework28.service.attachment.impl.ImageServiceImpl;
import homework28.service.impl.*;

import homework28.service.impl.security.UserDetailsServiceImpl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetailsService;

@Configuration
@ComponentScan(value = {"homework28.service", "homework28.dao"})
public class RootConfig {

    @Autowired
    private SessionFactory sessionFactory;

    @Bean
    public GoodDAO goodDAO() {
        return new GoodDAOImpl(sessionFactory);
    }

    @Bean
    public UserDAO userDAO() {
        return new UserDAOImpl(sessionFactory);
    }

    @Bean
    public OrderDAO orderDAO() {
        return new OrderDAOImpl(sessionFactory);
    }

    @Bean
    public ImageDAO imageDAO() {
        return new ImageDAOImpl(sessionFactory);
    }

    @Bean
    public GoodService goodService() {
        return new GoodServiceImpl(goodDAO());
    }

    @Bean
    public OrderService orderService() {
        return new OrderServiceImpl(orderDAO());
    }

    @Bean
    public UserService userService() {
        return new UserServiceImpl(userDAO());
    }

    @Bean
    public ImageService imageService() {
        return new ImageServiceImpl(imageDAO());
    }

    @Bean
    public UserDetailsService userDetailsService() {
        return new UserDetailsServiceImpl(userDAO());
    }

    @Bean
    public CartService cartService() {
        return new CartServiceImpl();
    }
}
