import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Author: yinqianhui
 * @Date Created by ThinkPad on 2017/10/11.
 */
public class MyShiroApp {
    private static final transient Logger log = LoggerFactory.getLogger(MyShiroApp.class);
    public static void main(String[] args) {
        IniSecurityManagerFactory factory = new IniSecurityManagerFactory("classpath:mytest.ini");

        //2.
        org.apache.shiro.mgt.SecurityManager securityManager = factory.getInstance();

        //3.
        SecurityUtils.setSecurityManager(securityManager);

        Subject currentUser = SecurityUtils.getSubject();

        if(!currentUser.isAuthenticated()){
            UsernamePasswordToken token = new UsernamePasswordToken("root", "root");
            token.setRememberMe(true);
            try {
                currentUser.login(token);
            } catch (UnknownAccountException uae) {
                log.info("没有此用户: " + token.getPrincipal());
            } catch (IncorrectCredentialsException ice) {
                log.info( token.getPrincipal() + " 密码不对！");
            } catch (LockedAccountException lae) {
                log.info( token.getPrincipal() + " 被锁住  " +
                        "请联系管理员进行解锁！");
            }
            // ... catch more exceptions here (maybe custom ones specific to your application?
            catch (AuthenticationException ae) {
                //unexpected condition?  error?
            }
        }
        //查看角色
        if(currentUser.hasRole("admin")){
            log.info("你是管理员，可以掌管一切！");
        }else if(currentUser.hasRole("guest")){
            log.info("你是客人，只能在此游览！");
        }else if(currentUser.hasRole("worker")){
            log.info("你是工作人员，可以在此工作！");
        }else {
            log.info("身份不明，保安拿下！");
        }

        //测试权限
        if(currentUser.isPermitted("room:eat")){
            log.info("你可以在房间吃东西！");
        }else {
            log.info("你不能在房间吃东西！");
        }

        if(currentUser.isPermitted("factory:work:bed-a")){
            log.info("你可以在a床工作！");
        }else {
            log.info("你不可以在a床工作！");
        }
    }
}
