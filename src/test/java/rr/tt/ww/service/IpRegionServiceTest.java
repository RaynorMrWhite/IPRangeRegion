package rr.tt.ww.service;

import org.junit.jupiter.api.Test;
import org.springframework.web.client.RestTemplate;
import rr.tt.ww.model.IpAddresses;

import static org.junit.jupiter.api.Assertions.*;

class IpRegionServiceTest {

    @Test
    public void testRegions(){
        String JSON_IP_RANGE_URL = "https://ip-ranges.amazonaws.com/ip-ranges.json";
        RestTemplate restTemplate = new RestTemplate();
        IpRegionService ipRegionService = new IpRegionService();
        IpAddresses ipRanges = (IpAddresses) restTemplate.getForObject(JSON_IP_RANGE_URL, IpAddresses.class);
        assertNotNull(ipRegionService.findbyregion("eu", ipRanges));
        assertNotNull(ipRegionService.findbyregion("us", ipRanges));
        assertNotNull(ipRegionService.findbyregion("cn", ipRanges));
        assertNotNull(ipRegionService.findbyregion("sa", ipRanges));
        assertNotNull(ipRegionService.findbyregion("af", ipRanges));
        assertNotNull(ipRegionService.findbyregion("ca", ipRanges));
        assertNotNull(ipRegionService.findbyregion("all", ipRanges));
        assertEquals(ipRegionService.findbyregion("south", ipRanges).size(),0);
        assertEquals(ipRegionService.findbyregion("east", ipRanges).size(),0);
    }
    @Test
    public void testIPRange() {
        String JSON_IP_RANGE_URL = "https://ip-ranges.amazonaws.com/ip-ranges.json";
        IpRegionService ipRegionService = new IpRegionService();
        RestTemplate restTemplate = new RestTemplate();
        assertEquals("54.245.168.0 -> 54.245.168.63", ipRegionService.getIPRange("54.245.168.0/26"));
        assertEquals("2a05:d07a:a000:: -> 2a05:d07a:a0ff:ffff:ffff:ffff:ffff:ffff", ipRegionService.getIPRange("2a05:d07a:a000::/40"));

    }
}