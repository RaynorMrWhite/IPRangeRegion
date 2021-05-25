package rr.tt.ww.service;

import inet.ipaddr.AddressStringException;
import inet.ipaddr.IPAddressString;
import rr.tt.ww.model.IPRange;
import rr.tt.ww.model.Ip_Prefix;
import rr.tt.ww.model.Ipv6_Prefix;

import java.util.ArrayList;
import java.util.List;

public class IpRegionService {

    /**
     *
     * @param region
     * @param iprange
     * @return List containing IP and IPv6_Prefixes which match with the region
     */
    public List<String> findbyregion(String region, IPRange iprange){
        List<String> IpList = new ArrayList<String>();
        region = region.toLowerCase();
        if(region.equals("all")){
            for(Ip_Prefix ip : iprange.getPrefixes()) {
                IpList.add(this.getIPRange(ip.getIp_prefix()));

            }
            for(Ipv6_Prefix ip : iprange.getIpv6_prefixes())   {
                IpList.add(this.getIPRange(ip.getIp_prefix()));
                }
        }

        for(Ip_Prefix ip : iprange.getPrefixes()) {
            if (ip.getRegion().substring(0,2).equals(region)) {
                IpList.add(this.getIPRange(ip.getIp_prefix()));
            }
        }
        for(Ipv6_Prefix ip : iprange.getIpv6_prefixes())   {
            if (ip.getRegion().substring(0,2).equals(region)) {
                IpList.add(this.getIPRange(ip.getIp_prefix()));
            }
        }
        return IpList;
    }

    public String getIPRange(String ipprefix){
        IPAddressString subnet = new IPAddressString(ipprefix);
        try {
            return subnet.toSequentialRange().toString();
        } catch (AddressStringException e) {
            e.printStackTrace();
        }
        return ipprefix;
    }
}
