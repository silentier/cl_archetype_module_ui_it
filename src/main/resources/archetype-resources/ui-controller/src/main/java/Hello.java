package ${package};

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.net.InetAddress;
import java.net.UnknownHostException;

@RestController
@Slf4j
public class Hello {

    @PostConstruct
    public void init() {
        log.info("@@ Controller loaded: "+this.getClass().getCanonicalName());
    }
    @GetMapping("/hello")
    public String sayBye2() {
        return "Hello <br/>" + getMachineName();
    }

    private String getMachineName() {
        String hostname = "Unknown";
        try {
            InetAddress addr;
            addr = InetAddress.getLocalHost();
            hostname = addr.getHostName();
        } catch (
                UnknownHostException ex) {
            System.out.println("Hostname can not be resolved");
        }

        return hostname;
    }
}
