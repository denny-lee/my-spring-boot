package com.lee.aspect;

import com.lee.dao.GirlMapper;
import com.lee.model.Girl;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Calendar;
import java.util.List;

@Aspect
@Component
public class TimerAspect {
    @Autowired
    private GirlMapper mapper;

    private static final Logger logger = LoggerFactory.getLogger(TimerAspect.class);
//    @Pointcut("execution(* com.lee.service.*.*(..))")
    @Pointcut("@within(org.springframework.transaction.annotation.Transactional)")
    public void cutAllService() {}

    @Before("cutAllService()")
    public void logExecTime() {
        logger.info("---execute begin time is :" + Calendar.getInstance().getTime());
        List<Girl> girls = mapper.listAll();
        logger.info("girls:" + girls.size());
        for (Girl g : girls) {
            logger.info(g.getName());
        }
    }

}
