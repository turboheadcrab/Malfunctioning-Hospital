package servlet;

import model.User;
import service.UserService;
import service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Администратор on 25.11.2016.
 */
@WebServlet(name="registration",
        urlPatterns = "/registration")
public class RegistrationPageServlet extends HttpServlet{
    private UserService userService;
    private final String REGISTRATION_PAGE = "/WEB-INF/views/RegistrationPage.jsp";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher(REGISTRATION_PAGE).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String login = req.getParameter("login");
        String password = req.getParameter("password");
        String confirmPassword = req.getParameter("confirmPassword");
        String name = req.getParameter("name");
        String patronymic = req.getParameter("patronymic");
        String surname = req.getParameter("surname");
        String polis = req.getParameter("polis");

        if (login != null && password != null &&
                confirmPassword != null && name != null &&
                patronymic != null && surname != null && polis != null
                ) {
            User user = new UserBuilder()
                    .setLogin(login)
                    .setPassword(password)
                    .setConfirmPassword(confirmPassword)
                    .setName(name)
                    .setPatronymic(patronymic)
                    .setSurname(surname)
                    .setPolis(polis)
                    .createUser();
            UserServiceImpl userService = new UserServiceImpl();
            long userId = userService.save(user);
            if (userId == -1){
//                req.setAttribute("password_mistake", userService.getPasswordMistake());
//                req.setAttribute("verify_password_mistake", userService.getVerifyPasswordMistake());
//                req.setAttribute("login_coincidence", userService.getLoginCoincidence());
//                req.setAttribute("password_coincidence", userService.getPasswordCoincidence());
//                req.setAttribute("login_mistake", userService.getLoginMistake());
//                req.setAttribute("polis_coincidence", userService.getPolisCoincidence());
//
//                userService.clear();

                req.setAttribute("login", login);
                req.setAttribute("password", password);
                req.setAttribute("confirmPassword", confirmPassword);
                req.setAttribute("name", name);
                req.setAttribute("surname", surname);
                req.setAttribute("patronymic", patronymic);
                req.setAttribute("polis", polis);
                getServletContext().getRequestDispatcher(REGISTRATION_PAGE).forward(req, resp);
            }else {
                resp.sendRedirect("/home");
            }
        }else {
            req.setAttribute("message", "Пожалуйста, заполните все поля регистрации");
            getServletContext().getRequestDispatcher(REGISTRATION_PAGE).forward(req, resp);
        }

    }

    @Override
    public void init() throws ServletException {
//        userService = ServiceFactory.getInstance().getUserService();
    }
}
