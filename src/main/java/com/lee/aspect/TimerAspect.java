package com.lee.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Calendar;

@Aspect
@Component
public class TimerAspect {
//    @Autowired
    private GirlMapper mapper;

    private static final Logger logger = LoggerFactory.getLogger(TimerAspect.class);
//    @Pointcut("execution(* com.lee.service.*.*(..))")
//    @Pointcut("@within(org.springframework.transaction.annotation.Transactional)")
    @Pointcut("execution(* com.lee.controller.*Controller.*(.., String, com.lee.model.Girl))")
    public void cutAllService() {}

    @Before("cutAllService()")
    public void logExecTime(JoinPoint jp) {
        logger.info("---execute begin time is :" + Calendar.getInstance().getTime());
        logger.info(((Girl)jp.getArgs()[0]).getName());
        logger.info(jp.getArgs()[1].toString());
        ((Girl) jp.getArgs()[2]).setAge(18);
        /*List<Girl> girls = mapper.listAll();
        logger.info("girls:" + girls.size());
        for (Girl g : girls) {
            logger.info(g.getName());
        }*/
    }

}
