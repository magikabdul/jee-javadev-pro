package pl.training.jee;

import javax.ejb.Remote;
import java.util.concurrent.Future;

@Remote
public interface PowerService {

    Future<Long> calculate(Long number);

}
