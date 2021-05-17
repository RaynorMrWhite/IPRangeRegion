package rr.tt.ww.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import rr.tt.ww.model.IPRange;
import rr.tt.ww.service.JsonParsingService;

import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

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

    public static <T> List<T> jsonArrayToList(String json, Class<T> elementClass) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        CollectionType listType =
                objectMapper.getTypeFactory().constructCollectionType(ArrayList.class, elementClass);
        return objectMapper.readValue(json, listType);
    }

}
