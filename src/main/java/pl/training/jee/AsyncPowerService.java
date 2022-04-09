package pl.training.jee;

import lombok.SneakyThrows;

import javax.ejb.AsyncResult;
import javax.ejb.Asynchronous;
import javax.ejb.Stateless;
import java.util.concurrent.Future;

@Stateless
public class AsyncPowerService implements PowerService {

    @Asynchronous
    @Override
    public Future<Long> calculate(Long number) {
        sleep(5_000);
        return new AsyncResult<>(number * number);
    }

    @SneakyThrows
    private void sleep(long timeInMilliseconds) {
        Thread.sleep(timeInMilliseconds);
    }

}
