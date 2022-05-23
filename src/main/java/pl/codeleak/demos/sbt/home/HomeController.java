package pl.codeleak.demos.sbt.home;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@Controller
class HomeController {

    @GetMapping("/")
    String index(Model model) {
        model.addAttribute("now", LocalDateTime.now());
        Map<String,Boolean> grapOnlineReports = new HashMap<>();
        grapOnlineReports.put("checkInvalidData" , true);
        grapOnlineReports.put("checkvalidData" , false);
        model.addAttribute("grapOnlineReports",grapOnlineReports);
        return "index";
    }
    @GetMapping("/home")
    String index1(Model model) {
        model.addAttribute("now", LocalDateTime.now());
        Map<String,Boolean> grapOnlineReports = new HashMap<>();
        grapOnlineReports.put("checkInvalidData" , true);
        grapOnlineReports.put("checkvalidData" , false);
        model.addAttribute("grapOnlineReports",grapOnlineReports);
        return "reports";
    }

    @GetMapping("properties")
    @ResponseBody
    java.util.Properties properties() {
        return System.getProperties();
    }

}
