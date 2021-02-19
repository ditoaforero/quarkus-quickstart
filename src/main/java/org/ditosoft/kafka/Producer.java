package org.ditosoft.kafka;

import io.reactivex.Flowable;
import org.eclipse.microprofile.reactive.messaging.Outgoing;

import javax.enterprise.context.ApplicationScoped;
import java.math.BigDecimal;
import java.util.Random;
import java.util.concurrent.TimeUnit;

@ApplicationScoped
public class Producer {

    private Random random = new Random();

    @Outgoing("generate-authorizations")
    public Flowable<Authorization> generate() {
        //return Flowable.interval(1, TimeUnit.SECONDS).map(tick -> new Authorization(random.nextInt(100),"998"));
        return Flowable.interval(5, TimeUnit.SECONDS).map(tick -> generateAuthorization());
    }


    private Authorization generateAuthorization() throws Exception {
        Authorization authorization = new Authorization();

        //RandomObjectFiller randomObjectFiller = new RandomObjectFiller();
        //authorization = randomObjectFiller.createAndFill(Authorization.class);
        authorization.setID_OFICINA("ABCDE");
        authorization.setAUTORIZACIONES_NUMERO(random.nextInt(99999999));
        authorization.setID_OFICINA("ABCDE");
        authorization.setCODTIPOS_SERVICIO(99999);
        authorization.setNUMIDE("ABCDEEFGHIJKLMN");
        authorization.setTIPIDE("CC");
        authorization.setNROCON("ABCDEEFGHIJKLMNOPQRSTUVWX");
        authorization.setNUMBEN(99);
        authorization.setAUTORIZACIONES_TIPMEDAUT("AB");
        authorization.setAUTORIZACIONES_NITMEDAUT(999999999999999L);


        return authorization;
    }
}
