package rr.tt.ww.service;

import org.junit.jupiter.api.Test;
import org.springframework.web.client.RestTemplate;
import rr.tt.ww.model.IpAddresses;

import static org.junit.jupiter.api.Assertions.*;

class JsonParsingServiceTest {

    @Test
    public void testParsingService() {
        String JSON_IP_RANGE_URL = "https://ip-ranges.amazonaws.com/ip-ranges.json";
        RestTemplate restTemplate = new RestTemplate();
        IpAddresses ipRanges = (IpAddresses) restTemplate.getForObject(JSON_IP_RANGE_URL, IpAddresses.class);
        assertNotEquals(0, ipRanges.getPrefixes().size());
        assertNotEquals(0, ipRanges.getIpv6_prefixes().size());
        assertNotNull(ipRanges.getPrefixes().get(0).getIp_prefix());
        assertNotNull(ipRanges.getIpv6_prefixes().get(0).getIpv6_prefix());
    }
}