package rr.tt.ww.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import rr.tt.ww.model.IPRange;
import rr.tt.ww.service.IpRegionService;
import rr.tt.ww.service.JsonParsingService;

import java.io.*;
import java.util.List;

@RestController
@RequestMapping(value="", method= RequestMethod.GET)
public class MainController {
    private static final String JSON_IP_RANGE_URL = "https://ip-ranges.amazonaws.com/ip-ranges.json";
    @Autowired
    private JsonParsingService parsingService;

    @PostMapping
    public void findbyregion(@RequestParam String region) throws FileNotFoundException {
        IpRegionService ipRegionService = new IpRegionService();
        IPRange ipRanges = (IPRange) parsingService.parse(JSON_IP_RANGE_URL);
        List<String> iprangebyregion = ipRegionService.findbyregion(region, ipRanges);
        String FILE_NAME = String.format("src/main/resources/%sIpRange.text", region);
        if (!iprangebyregion.isEmpty()){
            for (String range : iprangebyregion) {
                try {
                    FileWriter writer = new FileWriter(FILE_NAME, true);
                    writer.append(range+"\n");
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
