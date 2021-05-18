package rr.tt.ww.service;

import rr.tt.ww.model.IPRange;
import rr.tt.ww.model.Ip_Prefix;
import rr.tt.ww.model.Ipv6_Prefix;
import rr.tt.ww.repository.IpRegionServiceRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class IpRegionService {

    /**
     *
     * @param region
     * @param iprange
     * @return List containing IP and IPv6_Prefixes which match with the region
     */
    public static List<String> findbyregion(String region, IPRange iprange){
        List<String> IpList = new ArrayList<String>();
        region = region.toLowerCase().toString();
        if(region.equals("all")){
            for(Ip_Prefix ip : iprange.getPrefixes()) {
                IpList.add(ip.getIp_prefix());

            }
            for(Ipv6_Prefix ip : iprange.getIpv6_prefixes())   {
                    IpList.add(ip.getIp_prefix());
                }
        }

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
