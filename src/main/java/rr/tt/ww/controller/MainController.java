package rr.tt.ww.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import rr.tt.ww.model.IPRange;
import rr.tt.ww.service.IpRegionService;
import rr.tt.ww.service.JsonParsingService;

@Controller
public class MainController {
    private static final String MAIN_PAGE = "home";
    private static final String JSON_IP_RANGE_URL = "https://ip-ranges.amazonaws.com/ip-ranges.json";

    @Autowired
    private JsonParsingService parsingService;

    @GetMapping
    public String main(final Model model) throws Exception {
        IPRange ipRanges = (IPRange) parsingService.parse(JSON_IP_RANGE_URL);
        model.addAttribute("ipaddress", ipRanges.getPrefixes());
        return MAIN_PAGE;
    }

    @RequestMapping(value="/findbyregion", method= RequestMethod.GET)
    public ModelAndView findbyregion(@RequestParam(required=false) String region) {
        ModelAndView mv = new ModelAndView();
        IPRange ipRanges = (IPRange) parsingService.parse(JSON_IP_RANGE_URL);
        mv.addObject("title", "IP-Adress by Region");
        mv.addObject("ipaddresses", IpRegionService.findbyregion(region,ipRanges));
        System.out.println(IpRegionService.findbyregion(region,ipRanges).size());
        mv.setViewName("list_IPbyRegion");
        return mv;
    }

}
