package ${package}.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;

import javax.annotation.PostConstruct;

@Controller
@Slf4j
public class service {

    @PostConstruct
    public void init() {
        log.info("@@ Controller loaded: "+this.getClass().getCanonicalName());
    }
}