package rr.tt.ww.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.web.client.RestTemplate;
import rr.tt.ww.model.IPRange;

class JsonParsingServiceTest {
    @Test
    public void testParsingService(){
        String JSON_IP_RANGE_URL = "https://ip-ranges.amazonaws.com/ip-ranges.json";
        RestTemplate restTemplate = new RestTemplate();
        IPRange ipRanges = (IPRange) restTemplate.getForObject(JSON_IP_RANGE_URL, IPRange.class);
        Assertions.assertTrue(ipRanges.getSyncToken().equals("1621306452"));
    }
}