package pl.training.jee;

import javax.ejb.Remote;

@Remote
public interface IdGenerator {

    String getNext();

}
