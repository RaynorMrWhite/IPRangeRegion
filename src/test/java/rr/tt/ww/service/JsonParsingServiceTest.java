package rr.tt.ww.service;

import org.junit.jupiter.api.Test;
import org.springframework.web.client.RestTemplate;
import rr.tt.ww.model.IPRange;

import static org.junit.jupiter.api.Assertions.*;

class JsonParsingServiceTest {

    @Test
    public void testParsingService(){
        String JSON_IP_RANGE_URL = "https://ip-ranges.amazonaws.com/ip-ranges.json";
        RestTemplate restTemplate = new RestTemplate();
        IPRange ipRanges = (IPRange) restTemplate.getForObject(JSON_IP_RANGE_URL, IPRange.class);
        assertNotEquals(0, ipRanges.getPrefixes().size());
        assertNotEquals(0, ipRanges.getIpv6_prefixes().size());
        assertNotNull(ipRanges.getPrefixes().get(0).getIp_prefix());
        assertNull(ipRanges.getIpv6_prefixes().get(0).getIp_prefix());
        System.out.println(ipRanges.getIpv6_prefixes().get(0).getIp_prefix());
    }
}