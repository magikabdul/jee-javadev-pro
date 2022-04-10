package pl.training.calculator.common;

import jakarta.enterprise.event.Event;
import jakarta.inject.Inject;
import jakarta.interceptor.AroundInvoke;
import jakarta.interceptor.Interceptor;
import jakarta.interceptor.InvocationContext;
import lombok.RequiredArgsConstructor;

@Controller
@Interceptor
@RequiredArgsConstructor(onConstructor_ = @Inject)
public class ControllerInterceptor {

    private final Event<ModelAndView> dispatcher;

    @AroundInvoke
    public Object dispatch(InvocationContext invocationContext) throws Exception {
        var result = (ModelAndView) invocationContext.proceed();
        dispatcher.fire(result);
        return result;
    }

}
