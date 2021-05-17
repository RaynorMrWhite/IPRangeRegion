package rr.tt.ww.service;

import rr.tt.ww.model.IPRange;
import rr.tt.ww.model.Ip_Prefix;
import rr.tt.ww.model.Ipv6_Prefix;
import rr.tt.ww.repository.IpRegionServiceRepository;

import java.util.ArrayList;
import java.util.List;

public class IpRegionService {

    public static List<String> findbyregion(String region, IPRange iprange){
        List<String> IpList = new ArrayList<String>();
        for(Ip_Prefix ip : iprange.getPrefixes()) {
            if (ip.getRegion().contains(region)) {
                IpList.add(ip.getIp_prefix());
            }
        }
        for(Ipv6_Prefix ip : iprange.getIpv6_prefixes())   {
            if (ip.getRegion().contains(region)) {
                IpList.add(ip.getIp_prefix());
            }
        }
        return IpList;
    }

}
