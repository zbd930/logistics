package com.yiwutong.Aspect;

import com.yiwutong.Mail.Mymail;
import com.yiwutong.entities.chehang.order;
import com.yiwutong.entities.huodai.Ship;
import com.yiwutong.mapper.ShipMapper;
import com.yiwutong.mapper.UserMapper;
import com.yiwutong.mapper.chehangMapper;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Aspect    //该标签把LoggerAspect类声明为一个切面
@Component //该标签把LoggerAspect类放到IOC容器中
public class Update_status_aspect {
    @Autowired
    private Mymail mymail;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private com.yiwutong.mapper.chehangMapper chehangMapper;
    @Autowired
    private ShipMapper shipMapper;

    /**
     * 通过注解@Pointcut定义切点，conference()只是一个标识，无所谓是什么，
     * 方法中内容本身也是空的，使用该切点的地方直接通过标识conference()引用切点表达式。
     */
    @Pointcut("execution(public * com.yiwutong.service.Chaxunservice.update_status(..)) ")
    public void conference() {}

    /**
     * 前置通知
     * @param joinPoint
     * 2代表 更新仓位信息成功，3代表失败，4代表仓位不够
     */
    @Before("conference()")
    public void beforMethod(JoinPoint joinPoint){
        String methodName = joinPoint.getSignature().getName();
        List<Object> args = Arrays.asList(joinPoint.getArgs());
        System.out.println("this method "+methodName+" begin. param<"+ args+">");
    }
    /**
     * 后置通知（无论方法是否发生异常都会执行,所以访问不到方法的返回值）
     * @param joinPoint
     */
    @After("conference()")
    public void afterMethod(JoinPoint joinPoint){
        String methodName = joinPoint.getSignature().getName();
        System.out.println("this method "+methodName+" end.");
    }
    /**
     * 返回通知（在方法正常结束执行的代码）
     * 返回通知可以访问到方法的返回值！
     * @param joinPoint
     */
    public void afterReturnMethod(JoinPoint joinPoint,Object result){
        String methodName = joinPoint.getSignature().getName();
        System.out.println("this method "+methodName+" end.result<"+result+">");
    }
    /**
     * 异常通知（方法发生异常执行的代码）
     * 可以访问到异常对象；且可以指定在出现特定异常时执行的代码
     * @param joinPoint
     * @param ex
     */
    public void afterThrowingMethod(JoinPoint joinPoint,Exception ex){
        String methodName = joinPoint.getSignature().getName();
        System.out.println("this method "+methodName+" end.ex message<"+ex+">");
    }
    /**
     * 环绕通知(需要携带类型为ProceedingJoinPoint类型的参数)
     * 环绕通知包含前置、后置、返回、异常通知；ProceedingJoinPoin 类型的参数可以决定是否执行目标方法
     * 且环绕通知必须有返回值，返回值即目标方法的返回值
     * @param point
     * 2是更新仓位情况有误，3是仓位不够,4是更新ship_schdule状态有误
     */

    @Around("conference()")
    public Boolean aroundMethod(ProceedingJoinPoint point) throws Exception{
        int result = 0;
        String methodName = point.getSignature().getName();
        List<Object> args = Arrays.asList(point.getArgs());
        //获取切点方法的参数
        int status= (int) args.get(0);
        //int id=(int)args.get(1);
        String number=(String)args.get(1);
            String new_status = swtich(status);
            //获取一个航次中对应的所有用户订单
            List<order> orders = chehangMapper.get_address_id(number);
            String[] emails = new String[orders.size()];
            int[] ids = new int[orders.size()];
            String[] upss=new String[orders.size()];
            Boolean value = false;
            int[] statu=new int[orders.size()];
            String[] numbers=new String[orders.size()];
            for (int i = 0; i < orders.size(); i++) {
                //获取对应的邮件
                emails[i] = userMapper.get_emial(orders.get(i).getAddress_id()).getEmail();
                //获取对应的单号
                ids[i] = orders.get(i).getId();
                //获取对应的UPS单号
                upss[i]=orders.get(i).getOrder_details().getUps();
                //获取对应的状态
                statu[i]=orders.get(i).getStatus();
                numbers[i]=orders.get(i).getNumbers();
            }
            try {
                //前置通知
                System.out.println("The method " + methodName + " start. param<" + Arrays.asList(point.getArgs()) + ">");
                if(yanzheng(statu)) {
                    value = (Boolean) point.proceed();
                }  else return false;
                System.out.println("The method " + methodName + " end. result<" + result + ">");
            } catch (Throwable e) {
                //异常通知
                System.out.println("this method " + methodName + " end.ex message<" + e + ">");
                throw new RuntimeException(e);
            }
            //后置通知
            System.out.println("The method " + methodName + " end.");
                if (value == true) {
                    //发送邮件
                    for (int i = 0; i < emails.length; i++) {
                        StringBuilder s =new StringBuilder();
                        if (upss[i] .equals("0")) {
                            s.append("单号：" + numbers[i]+ "。<br>更新状态为：" + new_status+",<br>如有问题，请及时与客服取得联系");
                        } else {
                            s.append("单号：" + numbers[i] + "。<br>更新状态为：" + new_status +",UPS单号为 " + upss[i]+",<br>如有问题，请及时与客服取得联系");
                        }
                        try {
                            mymail.send(emails[i], String.valueOf(s),"【您的货物状态更新了】");
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    return value;
                } else return value;

    }
//    验证车行订单状态为到达货代公司仓库或者在运输途中
    private boolean yanzheng(int[] shuju) {
        for (int i = 0; i <shuju.length ; i++) {
            if (shuju[i]==2||shuju[i]==3){
                return true;
            }
        } return false;
    }

    private String swtich(int i) {
        switch (i) {
            case 0:
                return("未拼柜");
            case 1:
                return("已装柜");
            case 2:
                return("报关中");

            case 3:
                return("开船");

            case 4:
                return("货到港");

            case 5:
                return("查验中");

            case 6:
                return("已完成");

        }
        return null;
    }
}
