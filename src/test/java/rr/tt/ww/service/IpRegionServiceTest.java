package rr.tt.ww.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.web.client.RestTemplate;
import rr.tt.ww.model.IPRange;

import static org.junit.jupiter.api.Assertions.*;

class IpRegionServiceTest {

    @Test
    public void testRegions(){
        String JSON_IP_RANGE_URL = "https://ip-ranges.amazonaws.com/ip-ranges.json";
        RestTemplate restTemplate = new RestTemplate();
        IPRange ipRanges = (IPRange) restTemplate.getForObject(JSON_IP_RANGE_URL, IPRange.class);
        assertTrue(
                IpRegionService.findbyregion("all", ipRanges).size()== 5506);
        assertTrue(
                IpRegionService.findbyregion("us", ipRanges).size()== 1825);
        assertTrue(
                IpRegionService.findbyregion("ap", ipRanges).size()== 1340);
        assertTrue(
                IpRegionService.findbyregion("eu", ipRanges).size()== 1336);
        assertTrue(
                IpRegionService.findbyregion("cn", ipRanges).size()== 225);
        assertTrue(
                IpRegionService.findbyregion("sa", ipRanges).size()== 196);
        assertTrue(
                IpRegionService.findbyregion("ca", ipRanges).size()== 132);
        assertTrue(
                IpRegionService.findbyregion("af", ipRanges).size()== 96);

    }
    @Test
    public void testWrongRegions() {
        String JSON_IP_RANGE_URL = "https://ip-ranges.amazonaws.com/ip-ranges.json";
        RestTemplate restTemplate = new RestTemplate();
        IPRange ipRanges = (IPRange) restTemplate.getForObject(JSON_IP_RANGE_URL, IPRange.class);
        Assertions.assertTrue(0 == IpRegionService.findbyregion("lat", ipRanges).size());
        Assertions.assertTrue(0 == IpRegionService.findbyregion("ru", ipRanges).size());
        Assertions.assertTrue(0 == IpRegionService.findbyregion("ch", ipRanges).size());
    }
}