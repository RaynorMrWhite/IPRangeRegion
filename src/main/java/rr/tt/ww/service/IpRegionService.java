package rr.tt.ww.service;

import inet.ipaddr.AddressStringException;
import inet.ipaddr.IPAddressString;
import rr.tt.ww.model.IpAddresses;
import rr.tt.ww.model.IpPrefix;
import rr.tt.ww.model.Ipv6Prefix;

import java.util.ArrayList;
import java.util.List;

public class IpRegionService {

    /**
     *
     * @param region
     * @param iprange
     * @return List containing IP-Range of IP and IPv6_Prefixes matching the region
     */
    public List<String> findbyregion(String region, IpAddresses iprange){
        List<String> IpList = new ArrayList<String>();
        region = region.toLowerCase();
        if(region.equals("all")){
            for(IpPrefix ip : iprange.getPrefixes()) {
                IpList.add(this.getIPRange(ip.getIp_prefix()));

            }
            for(Ipv6Prefix ip : iprange.getIpv6_prefixes())   {
                IpList.add(this.getIPRange(ip.getIpv6_prefix()));
                }
        }

        for(IpPrefix ip : iprange.getPrefixes()) {
            if (ip.getRegion().substring(0,2).equals(region)) {
                IpList.add(this.getIPRange(ip.getIp_prefix()));
            }
        }
        for(Ipv6Prefix ip : iprange.getIpv6_prefixes())   {
            if (ip.getRegion().substring(0,2).equals(region)) {
                IpList.add(this.getIPRange(ip.getIpv6_prefix()));
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
