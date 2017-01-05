package service.impl;


import dao.UserDao;
import model.User;
import service.UserService;

import java.util.List;

/**
 * реализовать сервисы
 * прежде чем обращаться в даошкам
 * нужно проверить данные на корректность (Verifier)
 * и  реализовать сервисы для каждой даошки
 */
public class UserServiceImpl implements UserService {
    static String passwordMistake;
    static String loginCoincidence;
    static String loginMistake;
    static String verifyPasswordMistake;
    static String passwordCoincidence;
    static String polisCoincidence;

//    private UserDao userDao;
//
//    private UserVerifier userVerifier;
//
//    private ScheduleServiceImpl scheduleService;
//
//    public UserServiceImpl() {
//        userDao = DaoFactory.getInstance().getUserDao();
//        scheduleService = new ScheduleServiceImpl();
//    }

    @Override
    public void delete(String username) {

    }

    @Override
    public User find(String username) {
        return null;
    }

    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public long save(User user) {
//        userVerifier = new UserVerifier();
//        if(userVerifier.check(user, this)){
//            userDao = new UserDAOImpl();
//            return userDao.save(user);
//        }else
            return -1;
    }

    @Override
    public void update(User user) {

    }

//    public void setPasswordCoincidence(String passwordCoincidence){
//        this.passwordCoincidence = passwordCoincidence;
//    }
//    public String getPasswordCoincidence() {
//        return passwordCoincidence;
//    }
//    public void setLoginCoincidence(String loginCoincidence){
//        this.loginCoincidence = loginCoincidence;
//    }
//    public String getLoginCoincidence() {
//        return loginCoincidence;
//    }
//    public void setPasswordMistake(String passwordMistake){
//        this.passwordMistake = passwordMistake;
//    }
//    public String getPasswordMistake() {
//        return passwordMistake;
//    }
//    public void setVerifyPasswordMistake(String verifyPasswordMistake){
//        this.verifyPasswordMistake = verifyPasswordMistake;
//    }
//    public String getVerifyPasswordMistake() {
//        return verifyPasswordMistake;
//    }
//    public void setLoginMistake(String loginMistake){
//        this.loginMistake = loginMistake;
//    }
//    public String getLoginMistake() {
//        return loginMistake;
//    }
//    public void setPolisCoincidence(String polisCoincidence){
//        this.polisCoincidence = polisCoincidence;
//    }
//    public String getPolisCoincidence() {
//        return polisCoincidence;
//    }
//
//    public void clear(){
//        String clear = "";
//        setLoginMistake(clear);
//        setVerifyPasswordMistake(clear);
//        setPasswordMistake(clear);
//        setLoginCoincidence(clear);
//        setPasswordCoincidence(clear);
//    }
}

