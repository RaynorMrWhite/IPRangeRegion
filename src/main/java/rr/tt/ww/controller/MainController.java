package rr.tt.ww.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import rr.tt.ww.model.IpAddresses;
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
    public void findbyregion(@RequestParam String region){
        IpRegionService ipRegionService = new IpRegionService();
        IpAddresses ipAddresses = (IpAddresses) parsingService.parse(JSON_IP_RANGE_URL);
        List<String> ipRangeByRegion = ipRegionService.findbyregion(region, ipAddresses);
        String FILE_NAME = String.format("src/main/resources/%sIpRange.text", region);
        if (!ipRangeByRegion.isEmpty()){
            for (String range : ipRangeByRegion) {
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
