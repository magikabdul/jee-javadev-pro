package pl.training.jee;

import lombok.extern.java.Log;

import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

@Log
public class TimerInterceptor {

    @AroundInvoke
    public Object measure(InvocationContext invocationContext) throws Exception {
        var stratTime = System.nanoTime();
        var result= invocationContext.proceed();
        var endTime = System.nanoTime() - stratTime;
        log.info("### " + invocationContext.getMethod().getName() + " execution time: " + endTime + " ns");
        return result;
    }

}
