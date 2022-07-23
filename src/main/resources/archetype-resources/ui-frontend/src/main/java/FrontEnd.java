package ${package};

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;

import javax.annotation.PostConstruct;

@Controller
@Slf4j
public class FrontEnd {

    @PostConstruct
    public void init() {
        log.info("@@ Controller loaded: "+this.getClass().getCanonicalName());
    }
}